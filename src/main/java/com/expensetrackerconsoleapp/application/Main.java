package com.expensetrackerconsoleapp.application;


import com.expensetrackerconsoleapp.services.ConsoleDisplayService;
import com.expensetrackerconsoleapp.services.ReadService;
import com.expensetrackerconsoleapp.src.ExpenseDiary;

public class Main {

    public static void main(String[] args) {
        boolean isRunning = true;
        ExpenseDiary expenseDiary = new ExpenseDiary();
        ApplicationLogic applicationLogic = new ApplicationLogic(expenseDiary);

        while (isRunning){
            ConsoleDisplayService.displayMenu();
            int userInput = ReadService.readInteger();
            applicationLogic.checkUserSelection(userInput);
            int exitValue = 6;
            isRunning = userInput != exitValue;
        }
    }
}
