// Этот интерфейс определяет методы для получения списка напитков и выбора напитка
package src.main.vendingmachine.providers;

import java.util.List;

import src.main.vendingmachine.Beverage;

public interface BeverageProvider {
    List<Beverage> getBeverages(); // Метод для получения списка напитков
    Beverage getBeverage(String name); // Метод для получения напитка по имени
}