package org.example;

import java.util.Scanner;

public class UserInterface {

    public void displayHomeScreen() {

        boolean isRunning = true;
        while (isRunning) {
            try {
                System.out.println("Welcome to Sobway! Sandwiches so good you can't help but cry!");
                System.out.println("Please choose one of the following options: ");
                System.out.println("1) Place a new order");
                System.out.println("0) Exit the application");

                Scanner scnr = new Scanner(System.in);
                int choice = scnr.nextInt();

                switch (choice) {
                    case 1:
                        displaySandwichScreen();
                        break;
                    case 0:
                        System.out.println("Thank you for dining with us! Please come again!");
                        System.exit(0);
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }


    private void displayOrderScreen() {
        System.out.println("********** ORDER HERE **********");
        System.out.println("1. Sandwiches");
        System.out.println("2. Add-ons");
        System.out.println("3. Drinks");
        System.out.println("4. Chips");
        System.out.println("5. Checkout");
        System.out.println("6. Cancel order");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                displaySandwichScreen();
                displaySandwichSize();
                displayBreadOptions();
                displayToastOptions();
                break;
            case 2:
                displayAddOnScreen();
                displayPremiumToppings();
                displayRegularToppings();
                displaySauceOptions();
                displaySideOptions();
                break;
            case 3:
                displayDrinkScreen();
                break;
            case 4:
                displayChipsScreen();
                break;
            case 5:
                displayCheckoutScreen();
                displayReceiptScreen();
                break;
            case 6:
                cancelOrder();
                break;
            case 7:
                System.out.println("Invalid selection, choose from options listed above please.");
                displayOrderScreen();
        }

    }

    private void exitProgram() {
    }

    Scanner scanner = new Scanner(System.in);

    private void displaySandwichScreen() {
        int sandwichSize;
        String breadType;
        boolean toastedOption;

        System.out.println("********** BUILD YOUR SANDWICH **********");
        displaySandwichSize();
        System.out.println("Select desired size");
        sandwichSize = scanner.nextInt();
        displayBreadOptions();
        System.out.println("Select desired bread type ");
        breadType = scanner.nextLine();
        displayToastOptions();
        System.out.println("Toasted or untoasted?");
        toastedOption = scanner.nextBoolean();
    }

    private void displayAddOnScreen() {
        String regularToppings;
        String premiumToppings;

        System.out.println("********** ADD ONS **********");
        displayRegularToppings();
        System.out.println("Select desired free toppings");
        regularToppings = scanner.nextLine();
        displayPremiumToppings();
        System.out.println("Select desired premium toppings");
        premiumToppings = scanner.nextLine();
    }

    private void displayDrinkScreen() {
        String drinkType;
        char drinkSize;

        System.out.println("Select desired drink");
        drinkType= scanner.nextLine();
        System.out.println("Select drink size: S, M, L");
        drinkSize = scanner.nextLine().charAt(0);

    }

    private void displayChipsScreen() {
        String chipType;

        System.out.println("Select your desired chips");
        chipType = scanner.nextLine();

    }

    private void displayCheckoutScreen() {
        //when they have completed the order, application should display order details
        // including the list of sandwiches that were ordered to verify the order is correct
        System.out.println("Order details. Would you like to confirm?");
    }

    private void cancelOrder() {
        System.out.println("Canceling selection.");
    }


    private void displaySandwichSize() {
        System.out.println("Sandwich sizes: 4in, 8in, 12in");
    }

    private void displayBreadOptions() {
        System.out.println("Bread options: white, wheat, rye, wrap");
    }

    private void displayToastOptions() { System.out.println("Toasted or untoasted?");}

    private void displayPremiumToppings() {
        System.out.println("Premium toppings:");
    }

    private void displayRegularToppings() {
        System.out.println("Regular toppings: lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms");
    }

    private void displaySauceOptions() { System.out.println("Sauce options:mayo, mustard, ketchup, ranch, thousand island, vinaigrette");}

    private void displaySideOptions() { System.out.println("Side Options: au jus or sauce");}

    private void displayReceiptScreen() { System.out.println("Here are your order details:     come again soon!");}

}
