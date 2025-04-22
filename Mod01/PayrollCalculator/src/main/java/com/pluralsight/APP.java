package com.pluralsight;

import java.io.*;

public class APP {
    public static void main(String args[])
    {
        try {
            // Create a FileReader object to connect to the CSV file
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");

            // Create a BufferedReader to efficiently read the file line by line
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input; // Holds each line of input from the file
            boolean isFirstLine = true; // Used to skip the header line

            // Print report heading
            System.out.println("Payroll Report: ");
            System.out.println("--------------------------------------------------");

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
                System.out.printf("ID: %s | Name: %s | Gross Pay: $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }

            // Close the BufferedReader to release file resources
            bufReader.close();

        } catch(IOException e) {
            // Handle file read errors (e.g., file not found)
            System.out.println("There was an error reading the file.");
            e.printStackTrace(); // Print detailed error info for debugging
        } catch (NumberFormatException e) {
            // Handle errors converting strings to float (e.g., bad data format)
            System.out.println("Invalid number format in file.");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle errors caused by lines with missing fields
            System.out.println("Distorted line in input file.");
            e.printStackTrace();
        }
    }
}
