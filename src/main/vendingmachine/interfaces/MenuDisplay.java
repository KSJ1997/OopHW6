// Интерфейс MenuDisplay определяет метод для отображения меню напитков.
// Классы, реализующие этот интерфейс, должны предоставлять реализацию метода displayMenu(List<Beverage>).
// В данном проекте класс MenuDisplayImpl реализует интерфейс MenuDisplay и отображает меню напитков на консоли.
// Класс MenuDisplayImpl реализует интерфейс MenuDisplay и отображает меню напитков на консоли.
// Он выполняет только одну ответственность - отображение меню.
// Применяется принцип SRP (Single Responsibility Principle) и принцип инверсии зависимостей,
// так как класс зависит от абстракции (интерфейса MenuDisplay) и не зависит от конкретной реализации BeverageProvider.

package src.main.vendingmachine.interfaces;

import java.util.List;

import src.main.vendingmachine.Beverage;

public interface MenuDisplay {
    void displayMenu(List<Beverage> beverages); // Метод для отображения меню напитков
}