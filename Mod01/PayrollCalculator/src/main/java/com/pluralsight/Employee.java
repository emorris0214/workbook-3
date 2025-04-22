package com.pluralsight;

public class Employee {
    private String employeeId;
    private String name;
    private float hoursWorked, payRate;

    public Employee(String employeeId, String name, float hoursWorked, float payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public float getPayRate() {
        return payRate;
    }

    public float getGrossPay(){
        return hoursWorked * payRate;
    }
}
