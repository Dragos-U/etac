package com.expensetrackerconsoleapp.services;

import com.expensetrackerconsoleapp.src.ExpenseDiary;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReportingService {

    public static void saveToJsonFile(String filePath, ExpenseDiary expenseDiary) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filePath), expenseDiary.getExpenseMap());
            System.out.println("ExpenseMap saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openJsonFile(String filePath){
        File jsonFile = new File(filePath);
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(jsonFile);
            } else {
                System.out.println("Desktop class is not supported on this platform.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
