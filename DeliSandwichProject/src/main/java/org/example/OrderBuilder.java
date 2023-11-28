package org.example;

import java.time.LocalDateTime;

public interface OrderBuilder {
    OrderBuilder setOrderDate(LocalDateTime orderDate);
    OrderBuilder addSandwich(Sandwich sandwich);
    OrderBuilder addDrink(Drink drink);
    OrderBuilder addChips(Chips chips);
    Order build();

}
