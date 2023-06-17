//  * Класс Main является точкой входа в программу.
//  * Он создает меню напитков, обрабатывает ввод пользователя и отображает выбранный напиток.
//  * В данном проекте используется пул потоков ExecutorService для асинхронного чтения ввода пользователя.
//  * Применяется принцип OCP (Open-Closed Principle), так как класс готов к расширению (например, добавлению новых напитков).
package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import src.main.vendingmachine.Beverage;

import src.main.vendingmachine.providers.BeverageProviderImpl;
import src.main.vendingmachine.providers.BeverageProvider;
import src.main.vendingmachine.interfaces.MenuDisplay;
import src.main.vendingmachine.interfaces.MenuDisplayImpl;

public class Main {
    public static void main(String[] args) {
        BeverageProvider beverageProvider = new BeverageProviderImpl();
        List<Beverage> menu = beverageProvider.getBeverages();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        while (true) {
            MenuDisplay menuDisplay = new MenuDisplayImpl();
            menuDisplay.displayMenu(menu);
            System.out.print("Введите номер напитка: ");

            try {
                int choice = Integer.parseInt(reader.readLine());

                if (choice >= 1 && choice <= menu.size()) {
                    Beverage selectedBeverage = menu.get(choice - 1);
                    System.out.println("Вы выбрали: " + selectedBeverage);

                    System.out.println("Напиток готовится...");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Ваш напиток готов!");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Нажмите Enter, чтобы продолжить...");
                    executorService.submit(() -> {
                        try {
                            reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).get(5, TimeUnit.SECONDS);

                    executorService.shutdownNow();
                } else {
                    System.out.println("Неверный номер напитка. Пожалуйста, выберите снова.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода. Пожалуйста, введите целое число.");
            } catch (Exception e) {
                System.out.println("Истекло время ожидания.");
                executorService.shutdownNow();
                break;
            }
        }
    }
    
    private static List<Beverage> createMenu() {
        BeverageProvider beverageProvider = new BeverageProviderImpl();
        List<Beverage> menu = new ArrayList<>();

        // Добавление напитков через BeverageProvider
        menu.addAll(beverageProvider.getAllBeverages());

        return menu;
    }
}
 