package src.main.vendingmachine;

import java.util.*;

public class VendingMachine {
    private List<Beverage> beverages;

    public VendingMachine() {
        this.beverages = new ArrayList<>();
    }

    public void addBeverage(Beverage beverage) {
        beverages.add(beverage);
    }

    public void removeBeverage(Beverage beverage) {
        beverages.remove(beverage);
    }

    public void displayMenu() {
        for (Beverage beverage : beverages) {
            System.out.println(beverage.getName() + " - " + beverage.getPrice() + " руб.");
        }
    }

    public void sortByPrice() {
        beverages.sort(null);
    }
}

// Класс VendingMachine реализует интерфейсы Sortable и BeverageProvider
// Интерфейс MenuDisplay вынесен в отдельный файл MenuDisplay.java