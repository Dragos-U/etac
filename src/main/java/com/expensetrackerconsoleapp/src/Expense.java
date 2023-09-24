package com.expensetrackerconsoleapp.src;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Expense {

    private ExpenseCategory expenseCategory;
    private int amount;
    private String description;
}
