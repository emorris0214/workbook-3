package com.pluralsight;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class APP {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Quotes[] fameQuotes = new Quotes[10];

        // ....

        fameQuotes[0] = new Quotes(1, "'Comparison is the thief of joy.' - Theodore Roosevelt"); //
        fameQuotes[1] = new Quotes(2, "'The Lord laughs at the wicked, for He knows their day is coming.' - Bible"); // Psalms 37: 13
        fameQuotes[2] = new Quotes(3, "'Whoever wins this war becomes justice!' - Doflamingo from One Piece"); // Doflamingo
        fameQuotes[3] = new Quotes(4, "'Don't try to find a reason for somebodies love.' - Sengoku from One Piece"); // Sengoku
        fameQuotes[4] = new Quotes(5, "'Forgetting is like a wound. The wound may heal, but it has already left a scar.' - Monkey D. Luffy from One Piece"); // Luffy
        fameQuotes[5] = new Quotes(6, "'Fools who don't respect the past are likely to repeat it.' - Nico Robin from One Piece"); // Nico Robin
        fameQuotes[6] = new Quotes(7, "'A man dies when he is forgotten.' - Dr. Hiriluk from One Piece"); // Dr. Hiriluk
        fameQuotes[7] = new Quotes(8, "'Power comes in response to need, not a desire. You have to create that need.' - Goku from Dragon Ball Z"); // Goku
        fameQuotes[8] = new Quotes(9, "'Throughout heaven and earth, I alone am the honored one.' - Satoru Gojo from Jujutsu Kaisen"); // Gojo
        fameQuotes[9] = new Quotes(10, "'Dead people receive more flowers than the living because regret is stronger than gratitude.' - Violet from Violet Evergarden");

        boolean running = true;

        while (running){
            System.out.println("Welcome to our Quote Machine!");
            System.out.print("Please enter a number 1-10: ");

            //
            if (keyboard.hasNextInt()) {
                int choice = keyboard.nextInt();
                keyboard.nextLine();

                if (choice >= 1 && choice <=10) {
                    System.out.println(fameQuotes[choice - 1].getQuote());
                } else {
                    System.out.println("Number is invalid/out of range. Try again");
                    continue;
                }
            } else {
                System.out.println("That's not a number. Try again.");
                keyboard.nextLine();
                continue;
            }
            // prompting user to input whether they do or do not want another quote
            System.out.print("\nWould you like to see another quote? (Y/N): ");
            String loop = keyboard.nextLine();

            // if loop is not Y, quit the quote machine
            if (!loop.equalsIgnoreCase("Y")){
                running = false;
                System.out.println("Thanks for using the Quote Machine.");
            }

        }
    }
}
