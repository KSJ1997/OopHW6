// Интерфейс MenuDisplay определяет метод для отображения меню напитков.
// Классы, реализующие этот интерфейс, должны предоставлять реализацию метода displayMenu(List<Beverage>).
package src.main.vendingmachine.interfaces;

import java.util.List;

import src.main.vendingmachine.Beverage;

public interface MenuDisplay {
    void displayMenu(List<Beverage> beverages); // Метод для отображения меню напитков
}