package org.example;

import java.util.ArrayList;

public class Sandwich implements SandwichBuilder{


    @Override
    public SandwichBuilder setSize(int size) {
        return null;
    }

    @Override
    public SandwichBuilder setBreadType(String breadType) {
        return null;
    }

    @Override
    public SandwichBuilder setToasted(boolean isToasted) {
        return null;
    }

    @Override
    public SandwichBuilder addMeat(Topping meatType) {
        return null;
    }

    @Override
    public SandwichBuilder addCheese(Topping cheeseType) {
        return null;
    }

    @Override
    public SandwichBuilder addRegularTopping(Topping topping) {
        return null;
    }

    @Override
    public SandwichBuilder addSauce(Topping sauceType) {
        return null;
    }

    @Override
    public Sandwich build() {
        return null;
    }
}
