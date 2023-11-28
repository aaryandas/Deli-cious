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
}
    //toppings file needs to be initialized with all toppings and their type entered at program start
    //need to be able to read from toppings file when user picks a certain option, we'll need methods for these

