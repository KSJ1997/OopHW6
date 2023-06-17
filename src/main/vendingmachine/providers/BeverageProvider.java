package src.main.vendingmachine.providers;

import java.util.List;

import src.main.vendingmachine.Beverage;

public interface BeverageProvider {
    List<Beverage> getBeverages();
    Beverage getBeverage(String name);
}

// Интерфейс BeverageProvider вынесен в отдельный файл BeverageProvider.java
// Этот интерфейс определяет методы для получения списка напитков и выбора напитка