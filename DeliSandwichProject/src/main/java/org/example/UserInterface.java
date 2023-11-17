package org.example;

import java.util.Scanner;

public class UserInterface {

    public void displayHomeScreen(){

        boolean isRunning = true;
        while(isRunning){
            try{
                System.out.println("Welcome to the Sandwich Store!");
                System.out.println("Please choose one of the following options: ");
                System.out.println("1) Place a new order");
                System.out.println("0) Exit the application");

                Scanner scnr = new Scanner(System.in);
                int choice = scnr.nextInt();

                switch(choice){
                    case 1:
                        displaySandwichScreen();
                        break;
                    case 0:
                        System.out.println("Thank you! Please come again!");
                        System.exit(0);
                        break;
                }

            }
            catch(Exception ex){
                System.out.println("Invalid input. Please try again");
            }
        }
     }

    private void displayOrderScreen(){
        System.out.println("********** ORDER SCREEN **********");
        System.out.println();
     }

    private void exitProgram(){}

    private void displaySandwichScreen(){
        System.out.println("sandwich screen working correctly");
    }

    private void displayAddOnScreen(){
        System.out.println("********** ADD ONS **********");
        System.out.println();
    }

    private void displayDrinkScreen(){
        System.out.println("drink screen working");
    }

    private void displayChipsScreen(){
        System.out.println("chips screen working");
    }

    private void displayCheckoutScreen(){

    }


}
