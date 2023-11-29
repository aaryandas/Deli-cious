package org.example;
//Attributes: name, category (Enum: Regular, Premium)
//Methods: Getters and setters for attributes
public class Topping {
    private String name;
    private ToppingCategory category;

    public Topping(String name, ToppingCategory category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public ToppingCategory getCategory() {
        return category;
    }



    public String getCategory() {
        return String.valueOf(category);
    }


    //Debug
    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", category=" + category +
                '}';
    }

}

}

