//  * Класс MenuDisplayImpl реализует интерфейс MenuDisplay и отображает меню напитков на консоли.
//  * Он выполняет только одну ответственность - отображение меню.
//  * Применяется принцип SRP (Single Responsibility Principle) и принцип инверсии зависимостей,
//  * так как класс зависит от абстракции (интерфейса MenuDisplay) и не зависит от конкретной реализации BeverageProvider.
package src.main.vendingmachine.interfaces;

import src.main.vendingmachine.Beverage;

import java.util.List;

public class MenuDisplayImpl implements MenuDisplay {
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