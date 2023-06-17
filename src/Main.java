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
import src.main.vendingmachine.Coffee;
import src.main.vendingmachine.Tea;
import src.main.vendingmachine.CoffeeType;
import src.main.vendingmachine.TeaType;
import src.main.vendingmachine.interfaces.MenuDisplay;

public class Main {
    public static void main(String[] args) {
        List<Beverage> menu = createMenu();
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
        List<Beverage> menu = new ArrayList<>();

        menu.add(new Tea(TeaType.BLACK_TEA));
        menu.add(new Tea(TeaType.GREEN_TEA));

        menu.add(new Coffee(CoffeeType.AMERICANO));
        menu.add(new Coffee(CoffeeType.CAPPUCCINO));
        menu.add(new Coffee(CoffeeType.LATTE));

        return menu;
    }
}

class MenuDisplayImpl implements MenuDisplay {
    @Override
    public void displayMenu(List<Beverage> menu) {
        System.out.println("Меню напитков:");
        for (int i = 0; i < menu.size(); i++) {
            Beverage beverage = menu.get(i);
            System.out.println((i + 1) + ". " + beverage.getName() + " Цена: " + beverage.getPrice() + "р.");
        }
        System.out.println();
    }
}
