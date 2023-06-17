// Класс Tea представляет собой напиток "чай" и наследуется от абстрактного класса Beverage.
// Он имеет свой собственный тип чая (TeaType) и вычисляет цену на основе выбранного типа.
// Применяется принцип LSP (Liskov Substitution Principle), так как Tea является подтипом Beverage 
// и может использоваться везде, где ожидается Beverage.
package src.main.vendingmachine;

public class Tea extends Beverage {
    public static final TeaType BLACK_TEA = TeaType.BLACK_TEA;
    public static final TeaType GREEN_TEA = TeaType.GREEN_TEA;

    private TeaType type;

    public Tea(TeaType type) {
        super("", 0);
        this.type = type;
        this.name = type.getName();
        this.price = calculatePrice(); // Вычисление цены чая
    }

    private long calculatePrice() {
        long price;

        if (type == TeaType.BLACK_TEA) {
            price = 60;
        } else if (type == TeaType.GREEN_TEA) {
            price = 70;
        } else {
            price = 0;
        }

        return price;
    }

    @Override
    public String toString() {
        return this.name;
    }
}