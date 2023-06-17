package src.main.vendingmachine;

public enum CoffeeType {
    AMERICANO("Американо", 99),
    CAPPUCCINO("Капуччино", 109),
    LATTE("Латте", 119);

    private String name;
    private long price;

    private CoffeeType(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}

// Класс CoffeeType выделен в отдельный файл CoffeeType.java
// Добавлен метод getPrice() для получения цены напитка