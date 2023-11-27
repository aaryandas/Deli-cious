package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToppingFileManager {
    private static final String ToppingFilePath = "src/main/resources/toppingData.txt";

    public static List<Topping> loadToppings() {
        List<Topping> toppings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ToppingFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String category = parts[1].trim();
                    ToppingCategory toppingCategory = ToppingCategory.valueOf(category.toUpperCase());
                    toppings.add(new Topping(name, toppingCategory));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return toppings;
    }

    public static void saveToppings(List<Topping> toppings){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ToppingFilePath))){
            for (Topping topping : toppings) {
                String line = String.format("%s, %s", topping.getName(), topping.getCategory());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //Example usage:
    public static void main(String[] args) {
        //Load toppings from file
        List<Topping> loadedToppings = ToppingFileManager.loadToppings();
        System.out.println("Loaded Toppings: ");
        for (Topping topping : loadedToppings){
            System.out.println(topping);
        }

        //Regular toppings
        loadedToppings.add(new Topping("Lettuce", ToppingCategory.REGULAR));
        loadedToppings.add(new Topping("Peppers", ToppingCategory.REGULAR));
        loadedToppings.add(new Topping("Onions", ToppingCategory.REGULAR));
        loadedToppings.add(new Topping("Tomatoes", ToppingCategory.REGULAR));
        loadedToppings.add(new Topping("Jalepenos", ToppingCategory.REGULAR));
        loadedToppings.add(new Topping("Cucumbers", ToppingCategory.REGULAR));
        loadedToppings.add(new Topping("Pickles", ToppingCategory.REGULAR));
        loadedToppings.add(new Topping("Guacamole", ToppingCategory.REGULAR));
        loadedToppings.add(new Topping("Mushrooms", ToppingCategory.REGULAR));
        //Premium toppings
        loadedToppings.add(new Topping("Steak", ToppingCategory.PREMIUM));
        loadedToppings.add(new Topping("Ham", ToppingCategory.PREMIUM));
        loadedToppings.add(new Topping("Salami", ToppingCategory.PREMIUM));
        loadedToppings.add(new Topping("Roast Beef", ToppingCategory.PREMIUM));
        loadedToppings.add(new Topping("Chicken", ToppingCategory.PREMIUM));
        loadedToppings.add(new Topping("Bacon", ToppingCategory.PREMIUM));




        //Save toppings to file
        ToppingFileManager.saveToppings(loadedToppings);
        System.out.println("Toppings saved.");
    }
}