package src.main.vendingmachine;

import src.main.vendingmachine.interfaces.Comparable;

public abstract class Beverage implements Comparable<Beverage> {
    protected String name;
    protected long price;

    public Beverage(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public int compareTo(Beverage other) {
        return Long.compare(this.price, other.price);
    }
}

// Отделяем интерфейс Comparable в отдельный файл Comparable.java
// Это позволит классу Beverage быть ответственным только за свою основную функциональность
// Принцип SOLID, примененный в этом классе, это Open/Closed Principle (OCP). 
// Класс Beverage является абстрактным и реализует интерфейс Comparable<Beverage>. 
// Метод compareTo(Beverage other) в этом классе открыт для расширения, так как его можно переопределить в подклассах, 
// не изменяя кода самого класса Beverage.