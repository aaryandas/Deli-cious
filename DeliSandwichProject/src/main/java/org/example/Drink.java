package org.example;

//Attributes: name, size (Enum: Small, Medium, Large)
//Methods: Getters and setters for attributes


public class Drink {

    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public double getDrinkPrice(){
        switch(size.toLowerCase()){
            case "small":
                return 2.0;
            case "medium":
                return 2.50;
            case "large":
                return 3.0;
            default:
                return 0.0;
        }
    }
}
