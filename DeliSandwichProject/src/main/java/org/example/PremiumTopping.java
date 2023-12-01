package org.example;

public class PremiumTopping extends Topping{
    private PremiumToppingType premiumToppingType;

    public PremiumTopping(String name, PremiumToppingType premiumToppingType) {
        super(name);
        this.premiumToppingType = premiumToppingType;
    }

    @Override
    public double getPrice(int sandwichSize) {
        double totalPrice = 0;
        switch (premiumToppingType) {
            case CHEESE:
                if (sandwichSize == 4) {
                    totalPrice = 0.75;
                } else if (sandwichSize == 8) {
                    totalPrice = 1.50;
                } else {
                    totalPrice = 2.25;
                }
                break;
            case EXTRA_CHEESE:
                if (sandwichSize == 4) {
                    totalPrice = 0.30;
                } else if (sandwichSize == 8) {
                    totalPrice = 0.60;
                } else {
                    totalPrice = 0.90;
                }
                break;
            case EXTRA_MEAT:
                if (sandwichSize == 4) {
                    totalPrice = 0.50;
                } else if (sandwichSize == 8) {
                    totalPrice = 1.00;
                } else {
                    totalPrice = 1.50;
                }
                break;
            case MEAT:
                if (sandwichSize == 4) {
                    totalPrice = 1;
                } else if (sandwichSize == 8) {
                    totalPrice = 2;
                } else {
                    totalPrice = 3;
                }
                break;
        }

        return totalPrice;
    }
}
