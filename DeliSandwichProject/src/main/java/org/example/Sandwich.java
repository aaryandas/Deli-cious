package org.example;

import java.util.ArrayList;

public class Sandwich implements SandwichBuilder{
    private int size;
    private BreadType breadType;
    private boolean isToasted;
    private List<MeatType> meatTypeList = new ArrayList<>();
    private List<CheeseType> cheeseTypeList = new ArrayList<>();
    private List<RegularToppingType> regularToppingTypeList = new ArrayList<>();
    private List<SauceType> sauceTypeList = new ArrayList<>();

    @Override
    public SandwichBuilder setSize(int size) {
        this.size = size;
        return this;
    }

    @Override
    public SandwichBuilder setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    @Override
    public SandwichBuilder setToasted(boolean isToasted) {
        return null;
    }

    @Override
    public SandwichBuilder addMeat(MeatType meatType) {
        return null;
    }

    @Override
    public SandwichBuilder addCheese(CheeseType cheeseType) {
        return null;
    }

    @Override
    public SandwichBuilder addRegularTopping(RegularTopping topping) {
        return null;
    }

    @Override
    public SandwichBuilder addSauce(SauceType sauceType) {
        return null;
    }

    @Override
    public Sandwich build() {
        return null;
    }
}
