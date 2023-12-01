package org.example;

import java.util.ArrayList;

public class Sandwich{
    private int size;
    private String breadType;
    private ArrayList<Topping> toppings = new ArrayList<>();
    private boolean isToasted;

    public Sandwich(int sandwichSize, String breadType) {
        this.size = sandwichSize;
        this.breadType = breadType;
    }

    public int getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }
    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void  addTopping(Topping topping){
        toppings.add(topping);
    }
    public void  removeTopping(Topping topping){
        toppings.remove(topping);
    }


    public double getTotalPrice(){
        double totalprice=0;
        for (Topping topping:toppings){
            totalprice+= topping.getPrice(size);
        }
        return getSandwichBasePrice()+ totalprice;
    }
    public double getSandwichBasePrice() {
        double basePrice;
        switch (size) {
            case 4:
                basePrice = 5.50;
                break;
            case 8:
                basePrice = 7.00;
                break;
            case 12:
                basePrice = 8.50;
                break;
            default:
                basePrice = 0.0;
                break;
        }
        return basePrice ;
    }
}
