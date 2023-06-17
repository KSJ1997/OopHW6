// Класс VendingMachine реализует интерфейсы Sortable и BeverageProvider
// Интерфейс MenuDisplay вынесен в отдельный файл MenuDisplay.java
// Он хранит список доступных напитков и предоставляет методы для добавления, удаления и сортировки напитков.
// В данном проекте применяется принцип SRP (Single Responsibility Principle), так как класс отвечает только за 
// управление напитками в автомате.


package src.main.vendingmachine;

import java.util.*;

public class VendingMachine {
    private List<Beverage> beverages;

    public VendingMachine() {
        this.beverages = new ArrayList<>();
    }

    public void addBeverage(Beverage beverage) {
        beverages.add(beverage); // Добавление напитка в список
    }

    public void removeBeverage(Beverage beverage) {
        beverages.remove(beverage); // Удаление напитка из списка
    }

    public void displayMenu() {
        for (Beverage beverage : beverages) {
            System.out.println(beverage.getName() + " - " + beverage.getPrice() + " руб."); // Отображение имени и цены напитка
        }
    }

    public void sortByPrice() {
        beverages.sort(null); // Сортировка списка напитков по цене
    }
}