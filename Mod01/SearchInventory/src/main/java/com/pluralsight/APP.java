package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class APP {
    public static void main(String[] args) {

        // Welcome message to the user
        System.out.println("Welcome to E's Electronic Emporium");

        // Loads product data from the CSV file into an inventory list
        ArrayList<Product> inventory = getInventory();

        // Sorts the inventory list alphabetically by product name
        sortInventorybyName(inventory);

        // Initializes scanner for future user input (though input is not used here)
        Scanner scanner = new Scanner(System.in);

        // Displays the sorted product inventory
        System.out.println("We carry the following inventory: ");
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice()); // Added newline for better output format
        }

        // Closes the scanner to prevent resource leak
        scanner.close();
    }

    // Reads the product inventory from a CSV file and returns a list of Product objects
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        // Path to the inventory file (relative to project root or resources folder)
        String filePath = "src/main/resources/inventory.csv";
        // Tip: Make sure this path is correct relative to your working directory.
        // If you're running from an IDE, it might not be the project root.

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Reads the file line by line
            while ((line = reader.readLine()) != null){
                // Splits each line by the '|' delimiter
                String[] portions = line.split("\\|");

                // Expects 3 columns: ID, Name, Price
                if (portions.length == 3) {
                    int id = Integer.parseInt(portions[0]);          // Parses the product ID
                    String name = portions[1];                       // Parses the product name
                    float price = Float.parseFloat(portions[2]);     // Parses the product price

                    // Creates a new product and adds it to the inventory list
                    Product product = new Product(id, name, price);
                    inventory.add(product);
                }
            }
        } catch (IOException e) {
            // Catches any issues with file reading (e.g., file not found)
            System.out.println("Error reading inventory file: " + e.getMessage());
        }

        // Returns the populated inventory list
        return inventory;
    }

    // Sorts the given inventory list alphabetically by product name
    public static void sortInventorybyName(ArrayList<Product> inventory) {
        Collections.sort(inventory, new Comparator<Product>() {
            @Override
            public int compare(Product a, Product b) {
                // Case-insensitive string comparison
                return a.getName().compareToIgnoreCase(b.getName());
            }
        });
    }
}
