package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private static Checkout checkout = new Checkout();

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
                        displayOrderScreen();
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

    private void displayOrderScreen() throws IOException {
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
                break;
            case 2:
                displayDrinkScreen();
                break;
            case 3:
                displayChipsScreen();
                break;
            case 4:
                displayCheckoutScreen();
                break;
            case 5:
                cancelOrder();
                break;
            case 0:
                System.out.println("Invalid selection, choose from options listed above please.");
                displayOrderScreen();
        }
    }

    private void displaySandwichScreen() {
        System.out.println("********** BUILD YOUR SANDWICH **********");
            Scanner scanner = new Scanner(System.in);
            System.out.println("What type of bread do you want?");
            System.out.println("Bread Options: White, Wheat, Rye, Wrap");
            String breadType = scanner.nextLine();
            System.out.println("Please select sandwich size (4/8/12 inches): ");
            int sandwichSize = scanner.nextInt();
            System.out.println("Do you want premium meat? (yes/no): ");
            boolean premiumMeat = "yes".equalsIgnoreCase(scanner.next());
            String meatType = "";
            boolean extraMeat = false;
            if (premiumMeat) {
                System.out.println("What type of premium meat do you want?");
                scanner.nextLine();
                System.out.println("Meat Options: Steak, ham, salami, roast beef, chicken, bacon");
                meatType = scanner.nextLine();
                System.out.println("Do you want extra meat? (yes/no): ");
                extraMeat = "yes".equalsIgnoreCase(scanner.next());
            }
            System.out.println("Do you want premium cheese? (yes/no): ");
            boolean premiumCheese = "yes".equalsIgnoreCase(scanner.next());
            String cheeseType = "";
            boolean extraCheese = false;
            if (premiumCheese) {
                System.out.println("What type of premium cheese do you want?");
                scanner.nextLine();
                System.out.println("Cheese options: American, Provolone, Cheddar, Swiss");
                cheeseType = scanner.nextLine();
                System.out.println("Do you want extra cheese? (yes/no): ");
                extraCheese = "yes".equalsIgnoreCase(scanner.next());
            }
            Sandwich sandwich = new Sandwich(sandwichSize, breadType);
            if (premiumMeat) {
                PremiumTopping premiumMeatTopping = new PremiumTopping("Premium Meat", PremiumToppingType.MEAT);
                sandwich.addTopping(premiumMeatTopping);
                if (extraMeat) {
                    PremiumTopping extraMeatTopping = new PremiumTopping("Extra Meat", PremiumToppingType.EXTRA_MEAT);
                    sandwich.addTopping(extraMeatTopping);
                }
            }
            if (premiumCheese) {
                PremiumTopping premiumCheeseTopping = new PremiumTopping("Premium Cheese", PremiumToppingType.CHEESE);
                sandwich.addTopping(premiumCheeseTopping);
                if (extraCheese) {
                    PremiumTopping extraCheeseTopping = new PremiumTopping("Extra Cheese", PremiumToppingType.EXTRA_CHEESE);
                    sandwich.addTopping(extraCheeseTopping);
                }
            }
            boolean addingToppings = true;
            while (addingToppings) {
                System.out.println("Enter a regular topping to add (type 'done' to finish): ");
                System.out.println("Here are your options again: lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms");
                String regularTopping = scanner.next();
                if (regularTopping.equalsIgnoreCase("done")) {
                    addingToppings = false;
                } else {
                    RegularTopping topping = new RegularTopping(regularTopping);
                    sandwich.addTopping(topping);
                }
            }
            System.out.println("Do you want to remove toppings? (yes/no): ");
            boolean removeToppings = "yes".equalsIgnoreCase(scanner.next());
            if (removeToppings) {
                boolean removingToppings = true;
                while (removingToppings) {
                    System.out.println("Enter a regular topping to remove (type 'done' to finish): ");
                    System.out.println("Here are your options again: lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms");
                    String regularTopping = scanner.next();

                    if (regularTopping.equalsIgnoreCase("done")) {
                        removingToppings = false;
                    } else {
                        RegularTopping topping = new RegularTopping(regularTopping);
                        sandwich.removeTopping(topping);
                    }
                }
            }
            System.out.println("Do you want to add sauces? (yes/no): ");
            boolean addSauces = "yes".equalsIgnoreCase(scanner.next());
            if (addSauces) {
                System.out.println("Enter sauce type (e.g., mayo, mustard, ketchup, etc.): ");
                String sauceType = scanner.next();
                Sauces sauce = Sauces.valueOf(sauceType.toUpperCase());

                if (sauce != null) {
                    RegularTopping sauceTopping = new RegularTopping(sauce.name());
                    sandwich.addTopping(sauceTopping);
                }
            }
            checkout.addSandwich(sandwich);
        }

    /*private void displayAddOnScreen() {
        System.out.println("********** ADD ONS **********");
        displayRegularToppings();
        displayPremiumToppings();
    }*/

    private void displayDrinkScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Drinks: ");
        for(DrinkEnum drink : DrinkEnum.values()){
            System.out.println(drink.name());
        }
        String userInput = scanner.nextLine().toUpperCase();
        try{
            DrinkEnum selectedDrink = DrinkEnum.valueOf(userInput);
            System.out.println("You selected: " + selectedDrink);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice. Please select from the options.");
            displayDrinkScreen();
        }
    }

    private void displayChipsScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Drinks: ");
        for(ChipsEnum chips : ChipsEnum.values()){
            System.out.println(chips.name());
        }
        String userInput = scanner.nextLine().toUpperCase();
        try{
            ChipsEnum selectedChips = ChipsEnum.valueOf(userInput);
            System.out.println("You selected: " + selectedChips);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid size. Please select from the options.");
            displayChipsScreen();
        }
    }

    private void displayCheckoutScreen() throws IOException {
        //when they have completed the order, application should display order details
        // including the list of sandwiches that were ordered to verify the order is correct
        System.out.println("Order details. Would you like to confirm? (Y/N)");
        Scanner scnr = new Scanner(System.in);
        String choice = scnr.nextLine();
        if(choice.equalsIgnoreCase("Y")){
            generateReceipt();
        }else if(choice.equalsIgnoreCase("N")){
            System.out.println("Canceling Order");
            displayOrderScreen();
        }

    }

    private static void generateReceipt() throws IOException {

        ArrayList<Sandwich> sandwiches = checkout.getSandwiches();
        ArrayList<Drink> drinks = checkout.getDrinks();
        ArrayList<Chips> chips = checkout.getChips();

        ArrayList<String> items = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        for (Sandwich sandwich : sandwiches) {
            items.add("Sandwich");
            prices.add(sandwich.getTotalPrice());
        }
        for (Drink drink : drinks) {
            items.add("Drink");
            prices.add(drink.getDrinkPrice());
        }
        for (Chips chip : chips) {
            items.add("Chips");
            prices.add(chip.getChipsPrice());
        }

        double totalPrice = checkout.totalPrice();

        String[] itemsArray = items.toArray(new String[0]);
        double[] pricesArray = prices.stream().mapToDouble(Double::doubleValue).toArray();

        ArrayList<RegularTopping> regularToppingsList = new ArrayList<>();

        ArrayList<String> saucesList = new ArrayList<>();

        ReceiptsFileManager receiptFileManager = new ReceiptsFileManager("src/main/resources/Receipt.csv");
        ReceiptsFileManager.createReceipt(itemsArray, pricesArray, totalPrice, regularToppingsList, saucesList, drinks, chips);

        ArrayList<String> receiptDetails = receiptFileManager.getReceipt();
        System.out.println("Receipt Details:");
        for (String line : receiptDetails) {
            System.out.println(line);


        }
        checkout.clearOrder();
    }

    private void cancelOrder() {
        System.out.println("Canceling selection.");
    }

    /*private void displaySandwichSize() {
        Scanner scanner = new Scanner(System.in);

        // converting users input to corresponding enum using "valueOf"
        System.out.println("Sandwich sizes: 4in, 8in, 12in");
        for (Size size : Size.values()) {
            System.out.println(size.name());
        }

        String userChoice = scanner.nextLine().toUpperCase();

        try {
            Size selectedSize = Size.valueOf(userChoice);
            System.out.println("You selected size: " + selectedSize);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid size. Please select from the options.");
            displaySandwichSize();
        }
    }

    private void displayBreadOptions() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bread options: ");
        for (BreadType breadType : BreadType.values()) {
            System.out.println(breadType.name());
        }
        String userChoice = scanner.nextLine().toUpperCase();

        try {
            BreadType selectedBreadType = BreadType.valueOf(userChoice);
            System.out.println("You selected: " + selectedBreadType);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid bread type. Please select from the options.");
            displayBreadOptions();
        }
    }

    private void displayToastOptions() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning){
            try{
                System.out.println("Would you like your sandwich toasted? (Y/N)");
                String choice = scanner.nextLine();
                if(choice.equalsIgnoreCase("y")){

                }
            }
        }
    }

    private void displayPremiumToppings() {
        System.out.println("Premium toppings:");
    }

    private void displayRegularToppings() {
        System.out.println("Regular toppings: lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms");
    }

    private void displaySauceOptions() {
        System.out.println("Sauce options:mayo, mustard, ketchup, ranch, thousand island, vinaigrette");
    }

    private void displaySideOptions() {
        System.out.println("Side Options: au jus or sauce");
    }*/


}