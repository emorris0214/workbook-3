package com.pluralsight;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class APP {
    public static void main(String[] args) {

            Scanner keyboard = new Scanner(System.in);
            boolean running = true;

            while (running){
                System.out.println("Welcome to Em's Bedtime Story Corner!\n");
                System.out.println("What story would you like to read?");
                System.out.println("We have: Goldilocks, Hansel and Gretel, and Mary Had a Little Lamb.\n");
                System.out.print("Input the first letter of the story you would like to read ('G', 'H', or 'M' ('Q' to quit app)): ");

                String choice = keyboard.nextLine();
                String fileName = null;

                if (choice.equalsIgnoreCase("G")){

                    System.out.println("\nYou have chosen: 'Goldilocks'.");
                    fileName = "src/main/resources/goldilocks.txt";
                } else if (choice.equalsIgnoreCase("H")) {
                    System.out.println("\nYou have chosen: 'Hansel and Gretel'.");
                    fileName = "src/main/resources/hansel_and_gretel.txt";
                } else if (choice.equalsIgnoreCase("M")) {
                    System.out.println("\nYou have chosen: 'Mary Had a Little Lamb'.");
                    fileName = "src/main/resources/mary_had_a_little_lamb.txt";
                } else if (choice.equalsIgnoreCase("Q")) {
                    System.out.println("Goodnight, my sleepy-eepy friend! :) ");
                    running = false;
                    continue;
                } else {
                    System.out.println("Sorry that wasn't a valid input choice. Try again, my friend.");
                    continue;
                }

                if (fileName != null) {
                    try (FileInputStream fis = new FileInputStream(fileName);
                         Scanner fileScan = new Scanner(fis)) {

                        while (fileScan.hasNextLine()){
                            System.out.println(fileScan.nextLine());
                        }
                    } catch (IOException e) {
                        System.out.println("Sorry, there's been an issue with reading the selected file: " + fileName);
                        e.printStackTrace();
                    }
                }

            }
    }
}
