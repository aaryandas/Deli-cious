package org.example;

public abstract class Topping {
    private String name;
    public Topping (String name){
        this.name = name;
    }

    public abstract double getPrice(int sandwichSize);
}
