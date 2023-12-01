package org.example;

public class PremiumTopping extends Topping{
    private PremiumToppingType premiumToppingType;

    public PremiumTopping(String name, PremiumToppingType premiumToppingType) {
        super(name);
        this.premiumToppingType = premiumToppingType;
    }

    @Override
    public double getPrice(Size sandwichSize) {
        double totalPrice = 0;
        switch (premiumToppingType) {
            case CHEESE:
                if (sandwichSize == Size.FOUR) {
                    totalPrice = 0.75;
                } else if (sandwichSize == Size.EIGHT) {
                    totalPrice = 1.50;
                } else {
                    totalPrice = 2.25;
                }
                break;
            case EXTRA_CHEESE:
                if (sandwichSize == Size.FOUR) {
                    totalPrice = 0.30;
                } else if (sandwichSize == Size.EIGHT) {
                    totalPrice = 0.60;
                } else {
                    totalPrice = 0.90;
                }
                break;
            case EXTRA_MEAT:
                if (sandwichSize == Size.FOUR) {
                    totalPrice = 0.50;
                } else if (sandwichSize == Size.EIGHT) {
                    totalPrice = 1.00;
                } else {
                    totalPrice = 1.50;
                }
                break;
            case MEAT:
                if (sandwichSize == Size.FOUR) {
                    totalPrice = 1;
                } else if (sandwichSize == Size.EIGHT) {
                    totalPrice = 2;
                } else {
                    totalPrice = 3;
                }
                break;
        }

        return totalPrice;
    }
}
