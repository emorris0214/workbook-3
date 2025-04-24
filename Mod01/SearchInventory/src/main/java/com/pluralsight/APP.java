package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class APP {
    public static void main(String[] args) {

        System.out.println("Welcome to E's Electronic Emporium");
        ArrayList<Product> inventory = getInventory();
        sortInventorybyName(inventory);

        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f",
                    p.getId(), p.getName(), p.getPrice());
        }
        scanner.close();
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
// this method loads product objects into inventory
// and its details are not shown
            String filePath = "src/main/resources/inventory.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] portions = line.split("\\|");

                if (portions.length == 3) {
                    int id = Integer.parseInt(portions[0]);
                    String name = portions[1];
                    float price = Float.parseFloat(portions[2]);

                    Product product = new Product(id, name, price);
                    inventory.add(product);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }
        return inventory;
    }

    public static void sortInventorybyName(ArrayList<Product> inventory) {
        Collections.sort(inventory, new Comparator<Product>() {
            @Override
            public int compare(Product a, Product b) {
                return a.getName().compareToIgnoreCase(b.getName());
            }
        });
    }
}