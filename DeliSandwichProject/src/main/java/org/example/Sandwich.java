package org.example;

import java.util.ArrayList;

public class Sandwich{
    private Size size;
    private BreadType breadType;
    private ArrayList<Topping> toppings = new ArrayList<>();
    private boolean isToasted;

    public Sandwich(Size sandwichSize, BreadType breadType) {
        this.size = sandwichSize;
        this.breadType = breadType;
    }

    public Size getSize() {
        return size;
    }

    public BreadType getBreadType() {
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
            case SMALL:
                basePrice = 5.50;
                break;
            case MEDIUM:
                basePrice = 7.00;
                break;
            case LARGE:
                basePrice = 8.50;
                break;
            default:
                basePrice = 0.0;
                break;
        }
        return basePrice ;
    }
}
