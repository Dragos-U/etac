package com.expensetrackerconsoleapp.services;


import com.expensetrackerconsoleapp.src.Expense;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleDisplayService {

    private ConsoleDisplayService() {
        throw new IllegalStateException("This class should not be instantiated.");
    }

    public static void displayMenu() {
        System.out.println("\n-------------------------------------");
        System.out.println("| Expense Tracker Console Application |");
        System.out.println(" -------------------------------------");
        System.out.println("1. Add");
        System.out.println("2. Edit");
        System.out.println("3. View");
        System.out.println("4. Save");
        System.out.println("5. Delete");
        System.out.println("6. Exit");
        System.out.println("   > Select option [1 - 6]");
    }

    public static void printExpensesToConsole(Map.Entry<LocalDate, List<Expense>> entry) {
        LocalDate date = entry.getKey();
        List<Expense> expenses = entry.getValue();
        System.out.println("Date : " + date);
        expenses.forEach(expense ->
                System.out.println("    Expense: " +
                        expense.getDescription() + ", amount $: " +
                        expense.getAmount()));
    }

    public static String useTodayAsDate() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        while(! (answer.equalsIgnoreCase("y")|| (answer.equalsIgnoreCase("n")))){
            useTodayAsDate();
        }
        return answer;
    }
}
