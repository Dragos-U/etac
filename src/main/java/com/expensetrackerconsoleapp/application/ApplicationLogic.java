package com.expensetrackerconsoleapp.application;


import com.expensetrackerconsoleapp.services.ConsoleDisplayService;
import com.expensetrackerconsoleapp.services.ReadService;
import com.expensetrackerconsoleapp.services.ReportingService;
import com.expensetrackerconsoleapp.src.Expense;
import com.expensetrackerconsoleapp.src.ExpenseDiary;

import java.time.LocalDate;

public class ApplicationLogic {

    private final String filePath = "D:/Expenses.json";
    private final ExpenseDiary expenseDiary;

    public ApplicationLogic(ExpenseDiary expenseDiary) {
        this.expenseDiary = expenseDiary;
    }

    public void checkUserSelection(int number) {
        switch (number) {
            case 1 -> {
                System.out.println(" > Enter expense data...");
                System.out.println(" > Use today as date? (y/n)");
                String ans = ConsoleDisplayService.useTodayAsDate();
                LocalDate date = LocalDate.now();
                if (ans.equalsIgnoreCase("n")) {
                    System.out.println(" > Date :  format [yyyy-MM-dd]");
                    date = ReadService.readDate();
                }

                System.out.println(" > Amount :  ");
                int amount = ReadService.readInteger();

                System.out.println(" > Description :  ");
                String description = ReadService.readDescription();

                expenseDiary.addExpense(date, Expense.builder().amount(amount).description(description).build());
                System.out.println(" >>> Expense added successfully.\n");
            }
            case 2 -> {
                System.out.println("Expense diary info: ");
                expenseDiary
                        .getExpenseMap()
                        .entrySet()
                        .stream()
                        .forEach(ConsoleDisplayService::printExpensesToConsole);
            }
            case 3 ->   ReportingService.openJsonFile(filePath);
            case 4 -> {
                System.out.println("    Saving to file...");
                ReportingService.saveToJsonFile(filePath, expenseDiary);
            }
            case 5 -> {
                expenseDiary.deleteExpense();
                System.out.println("Last saved date entries were deleted.");
            }
            case 6 -> System.out.println("Thank you for using the app.");
            default -> {
                System.out.println("Unknown input. Try again...\n");
                ConsoleDisplayService.displayMenu();
                ReadService.readInteger();
            }
        }
    }
}
