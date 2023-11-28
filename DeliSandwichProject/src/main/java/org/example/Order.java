package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order implements OrderBuilder{
    private int orderNumber;
    private LocalDateTime orderDate;
    private List<Sandwich> sandwichList = new ArrayList<>();
    private List<Drink> drinkList = new ArrayList<>();
    private List<Chips> chipsList = new ArrayList<>();

    @Override
    public OrderBuilder setOrderDate(LocalDateTime orderDate){
        this.orderDate = orderDate;
        return this;
    }

    @Override
    public OrderBuilder addSandwich(Sandwich sandwich) {
        this.sandwichList.add(sandwich);
        return this;
    }

    @Override
    public OrderBuilder addDrink(Drink drink) {
        this.drinkList.add(drink);
        return this;
    }

    @Override
    public OrderBuilder addChips(Chips chips) {
        this.chipsList.add(chips);
        return this;
    }

    @Override
    public Order build() {
        return this;
    }

}
