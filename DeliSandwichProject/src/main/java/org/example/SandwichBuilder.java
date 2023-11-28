package org.example;

public interface SandwichBuilder {
    SandwichBuilder setSize(int size);
    SandwichBuilder setBreadType(String breadType);
    SandwichBuilder setToasted(boolean isToasted);
    SandwichBuilder addMeat(Topping meatType);
    SandwichBuilder addCheese(Topping cheeseType);
    SandwichBuilder addRegularTopping(Topping regularTopping);
    SandwichBuilder addSauce(Topping sauceType);

    Sandwich build();
}
