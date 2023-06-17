package src.main.vendingmachine;

public class Coffee extends Beverage {
    private CoffeeType type;

    public Coffee(CoffeeType type) {
        super("", 0);
        this.type = type;
        this.name = type.getName();
        this.price = calculatePrice();
    }

    private long calculatePrice() {
        switch (type) {
            case AMERICANO:
                return 99;
            case CAPPUCCINO:
                return 109;
            case LATTE:
                return 119;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}

// Класс Coffee выделен в отдельный файл Coffee.java