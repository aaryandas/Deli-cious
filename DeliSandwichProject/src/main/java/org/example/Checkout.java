package org.example;

import java.util.ArrayList;

public class Checkout {

    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drink> drinks;
    private ArrayList<Chips> chips;

    public Checkout(){
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }
    public ArrayList<Sandwich> getSandwiches(){
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chips> getChips() {
        return chips;
    }

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }
    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void addChips(Chips chip){
        chips.add(chip);
    }

    public double totalPrice(){
        double totalPrice = 0;

        for(Sandwich sandwich : sandwiches){
            totalPrice+=sandwich.getTotalPrice();
        }

        for(Drink drink : drinks){
            totalPrice += drink.getDrinkPrice();
        }

        for(Chips chip : chips){
            totalPrice += chip.getChipsPrice();
        }
        return totalPrice;
    }
    public void clearOrder(){
        sandwiches.clear();
        drinks.clear();
        chips.clear();
    }

}
