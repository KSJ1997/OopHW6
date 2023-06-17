// Класс Coffee представляет собой напиток "кофе" и наследуется от абстрактного класса Beverage.
// Он имеет свой собственный тип кофе (CoffeeType) и вычисляет цену на основе выбранного типа.
// Применяется принцип LSP (Liskov Substitution Principle), так как Coffee является подтипом Beverage 
// и может использоваться везде, где ожидается Beverage.

package src.main.vendingmachine;

public class Coffee extends Beverage {
    private CoffeeType type;

    public Coffee(CoffeeType type) {
        super("", 0);
        this.type = type;
        this.name = type.getName();
        this.price = calculatePrice(); // Вычисление цены кофе
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