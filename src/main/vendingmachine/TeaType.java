package src.main.vendingmachine;

public enum TeaType {
    BLACK_TEA("Черный чай", 60),
    GREEN_TEA("Зеленый чай", 70);

    private String name;
    private long price;

    private TeaType(String name, long price) {
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

// Класс TeaType выделен в отдельный файл TeaType.java
// Добавлен метод getPrice() для получения цены напитка