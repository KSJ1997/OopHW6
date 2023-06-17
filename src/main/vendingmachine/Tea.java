package src.main.vendingmachine;

public class Tea extends Beverage {
    public static final TeaType BLACK_TEA = TeaType.BLACK_TEA;
    public static final TeaType GREEN_TEA = TeaType.GREEN_TEA;

    private TeaType type;

    public Tea(TeaType type) {
        super("", 0);
        this.type = type;
        this.name = type.getName();
        this.price = calculatePrice();
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

// Класс Tea выделен в отдельный файл Tea.java