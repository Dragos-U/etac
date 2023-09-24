package com.expensetrackerconsoleapp.services;

import com.expensetrackerconsoleapp.src.ExpenseDiary;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


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
}
