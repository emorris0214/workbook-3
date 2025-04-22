package com.pluralsight;

import java.io.*;
public class APP {
    public static void main(String args[])
    {
        try
        {
// create a FileReader object connected to the File
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
// create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;

            boolean isFirstLine = true;

            System.out.println("Payroll Report: ");
            System.out.println("--------------------------------------------------");

            while((input = bufReader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] tokens = input.split("\\|");

                String id = tokens[0];
                String name = tokens[1];
                float hoursWorked = Float.parseFloat(tokens[2]);
                float payRate = Float.parseFloat(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                System.out.printf("ID: %s | Name: %s | Gross Pay: $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }
// close the stream and release the resources
            bufReader.close();

        } catch(IOException e) {
            System.out.println("There was an error reading the file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file.");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Distorted line in input file.");
            e.printStackTrace();
        }
    }
}