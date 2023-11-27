package org.example;

public interface SandwichBuilder {
    Sandwich build();
    SandwichBuilder setSize(int size);
    SandwichBuilder setBreadType(BreadType breadType);
    SandwichBuilder setToasted(boolean isToasted);
    SandwichBuilder addMeat(MeatType meatType);
    SandwichBuilder addCheese(CheeseType cheeseType);
    SandwichBuilder addRegularTopping(RegularTopping topping);
    SandwichBuilder addSauce(SauceType sauceType);

    Sandwich build();
}
