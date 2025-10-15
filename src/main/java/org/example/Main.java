package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to my Near Earth Object Tracker!");
        System.out.println("Enter start date (YYYY-MM-DD): ");
        String sDate = userInput.nextLine();

        // might have to turn into local date object, to pass to API?

    }
}