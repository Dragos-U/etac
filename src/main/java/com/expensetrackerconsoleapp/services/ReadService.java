package com.expensetrackerconsoleapp.services;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadService {

    private ReadService() {
        throw new IllegalStateException("Should not be instantiated.");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static int readInteger() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.err.println("Invalid input. Please enter a valid integer.");
            return readInteger();
        }
    }

    public static String readDescription() {
        //Scanner scanner1 = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static LocalDate readDate(){
        try {
            String input = scanner.nextLine();
            String[] parts = input.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            return LocalDate.of(year, month, day);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter a valid date (yyyy-MM-dd).");
            return readDate();
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}
