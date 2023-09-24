package com.expensetrackerconsoleapp.src;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
public class ExpenseDiary {

    private Map<LocalDate, List<Expense>> expenseMap = new HashMap<>();

    public void addExpense(LocalDate date, Expense expense){
        if(expense == null){
            throw new IllegalArgumentException("Not a valid expense");
        }
        List<Expense> expenseForDate = expenseMap.getOrDefault(date,new ArrayList<>());
        expenseForDate.add(expense);
        expenseMap.put(date,expenseForDate);
    }

    public List<Expense> getExpenseForDate(LocalDate date){
        return expenseMap.getOrDefault(date, new ArrayList<>());
    }

    public void editExpense(Expense expense){

    }

    public void deleteExpense(){
        if (!expenseMap.isEmpty()) {
            LocalDate lastDate = expenseMap
                    .keySet()
                    .stream()
                    .max(LocalDate::compareTo)
                    .get();
            expenseMap.remove(lastDate);
        }
    }

    public void viewExpenses(){

    }

}
