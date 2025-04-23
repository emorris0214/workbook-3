package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class APP {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);


        try {
            System.out.print("Enter the name of the file to process: ");
            String inputFileName = keyboard.nextLine();

            System.out.print("Enter the name of the payroll file to create: ");
            String outputFileName = keyboard.nextLine();

            // Create a FileReader object to connect to the CSV file / Create a BufferedReader to efficiently read the file line by line
            FileReader fileReader = new FileReader("src/main/resources/" + inputFileName);
            BufferedReader bufReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("src/main/resources/" + outputFileName);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            String input; // Holds each line of input from the file
            boolean isFirstLine = true; // Used to skip the header line

            /* Print report heading
            System.out.println("Payroll Report: ");
            System.out.println("--------------------------------------------------"); */

            // Read each line of the file
            while((input = bufReader.readLine()) != null) {
                // Skip the first line (assumed to be the header)
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // Split the line into fields using the pipe symbol as delimiter
                String[] tokens = input.split("\\|");

                // Parse each field from the tokens array
                String id = tokens[0];
                String name = tokens[1];
                float hoursWorked = Float.parseFloat(tokens[2]);
                float payRate = Float.parseFloat(tokens[3]);

                // Create an Employee object with the parsed values
                Employee employee = new Employee(id, name, hoursWorked, payRate);

                // Print employee info including calculated gross pay
                String payrollLine = String.format("%s|%s|$%.2f",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

                // Write line to output file
                bufWriter.write(payrollLine);
                bufWriter.newLine();
            }

            // Close the BufferedReader to release file resources
            bufReader.close();
            bufWriter.close();
            System.out.println("Payroll file created smoothly.");

        } catch(IOException e) {
            // Handle file read errors (e.g., file not found)
            System.out.println("A file error has occurred.");
            e.printStackTrace(); // Print detailed error info for debugging
        } catch (NumberFormatException e) {
            // Handle errors converting strings to float (e.g., bad data format)
            System.out.println("Invalid number format in file.");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle errors caused by lines with missing fields
            System.out.println("Distorted or incomplete line in input file.");
            e.printStackTrace();
        }
    }
}
