// Класс BeverageProviderImpl реализует интерфейс BeverageProvider и предоставляет список напитков.
// Применяется принцип SRP (Single Responsibility Principle) и принцип инверсии зависимостей,
// так как класс зависит от абстракции (интерфейса BeverageProvider) и не зависит от конкретной реализации MenuDisplay.

package src.main.vendingmachine.providers;

import src.main.vendingmachine.Beverage;
import src.main.vendingmachine.Coffee;
import src.main.vendingmachine.CoffeeType;
import src.main.vendingmachine.Tea;
import src.main.vendingmachine.TeaType;

import java.util.ArrayList;
import java.util.List;

public class BeverageProviderImpl implements BeverageProvider {
    private List<Beverage> beverages;

    public BeverageProviderImpl() {
        this.beverages = new ArrayList<>();
        initializeBeverages(); // Инициализация списка напитков
    }

    private void initializeBeverages() {
        // Добавляем чай в список напитков
        beverages.add(new Tea(TeaType.BLACK_TEA));
        beverages.add(new Tea(TeaType.GREEN_TEA));

        // Добавляем кофе в список напитков
        beverages.add(new Coffee(CoffeeType.AMERICANO));
        beverages.add(new Coffee(CoffeeType.CAPPUCCINO));
        beverages.add(new Coffee(CoffeeType.LATTE));
    }

    @Override
    public List<Beverage> getBeverages() {
        return beverages;
    }

    @Override
    public Beverage getBeverage(String name) {
        for (Beverage beverage : beverages) {
            if (beverage.getName().equalsIgnoreCase(name)) {
                return beverage;
            }
        }
        return null; // Возвращаем null, если напиток не найден
    }
}
