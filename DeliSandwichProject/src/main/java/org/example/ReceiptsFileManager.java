package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReceiptsFileManager{

    private static String fileName;

    public ReceiptsFileManager(String fileName) {
        this.fileName = fileName;
    }

    public static void createReceipt(String[] items, double[] prices, double totalPrice, ArrayList<RegularTopping> regularTList, ArrayList<String> sauceList, ArrayList<Drink> drinks, ArrayList<Chips> chips) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String receiptFileName = "Receipt_" + currentDateTime.format(formatter) + ".txt";

            writer.write("Receipt\n");
            writer.write("Date:," + currentDateTime.format(formatter) + "\n");
            writer.write("Item/Price\n");


            for (int i = 0; i < items.length; i++) {
                writer.write(items[i] + "," + prices[i] + "\n");
            }
            boolean hasRegularTopping = !regularTList.isEmpty();
            boolean hasSauces = !sauceList.isEmpty();
            boolean hasDrinks = !drinks.isEmpty();
            boolean hasChips = !chips.isEmpty();
            if (hasRegularTopping || hasSauces || hasDrinks || hasChips) {
                writer.write("\n---Additional Details---\n");
            }

            if (hasRegularTopping) {
                writer.write("Regular Toppings:\n");
                for (RegularTopping topping : regularTList) {
                    writer.write(topping.getToppingName() + "\n");
                }
            }

            if (hasSauces) {
                writer.write("Sauces:\n");
                for (String sauce : sauceList) {
                    writer.write(sauce + "\n");
                }
            }
            if (hasDrinks) {
                writer.write("Drinks:\n");
                for (Drink drink : drinks) {
                    writer.write("Size: " + drink.getSize() + "\n\n");
                }
            }
            if (hasChips) {
                writer.write("Chips:\n");
                for (Chips chip : chips) {
                    writer.write(chip.getType() + "\n\n");
                }
            }
            writer.write("Total Price:" + totalPrice + "\n\n");
            System.out.println("Receipt details added to file: " + fileName);



        } catch (IOException e) {
            System.out.println("An error occurred while writing to the receipt file.");
            e.printStackTrace();

        }
    }
    public ArrayList<String> getReceipt() {
        ArrayList<String> receipt = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                receipt.add(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the receipt file.");
            e.printStackTrace();
        }
        return receipt;
    }
}
