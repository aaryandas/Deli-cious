package org.example;

public class RegularTopping extends Topping {

    private String toppingName;

    public RegularTopping(String name) {
        super(name);
        this.toppingName = name;
    }
    public String getToppingName() {
        return toppingName;
    }

    @Override
    public double getPrice(Size sandwichSize) {
        return 0;
    }

    public int getNames() {
        return getNames();
    }
}
