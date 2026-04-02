package com.finance.backend.controller;

import com.finance.backend.model.FinancialRecord;
import com.finance.backend.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private RecordService service;

    @GetMapping
    public String summary(@RequestHeader String role) {

        if (role.equals("VIEWER")) {
            return "Access Denied";
        }

        List<FinancialRecord> records = service.getAll();

        double income = 0;
        double expense = 0;

        for (FinancialRecord r : records) {
            if ("INCOME".equals(r.getType())) {
                income += r.getAmount();
            } else {
                expense += r.getAmount();
            }
        }

        return "Income: " + income +
               ", Expense: " + expense +
               ", Balance: " + (income - expense);
    }
}