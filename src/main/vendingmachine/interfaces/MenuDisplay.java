package src.main.vendingmachine.interfaces;

import java.util.List;

import src.main.vendingmachine.Beverage;

public interface MenuDisplay {
    void displayMenu(List<Beverage> beverages);
}

// Интерфейс MenuDisplay вынесен в отдельный файл MenuDisplay.java
// Этот интерфейс определяет метод displayMenu() для отображения меню