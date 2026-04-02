package com.finance.backend.controller;

import com.finance.backend.model.FinancialRecord;
import com.finance.backend.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService service;

    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAll();
    }

    @PostMapping
    public String add(@RequestBody FinancialRecord record,
                      @RequestHeader String role) {

        if (!role.equals("ADMIN")) {
            return "Only ADMIN can add";
        }

        service.add(record);
        return "Record Added";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id,
                         @RequestHeader String role) {

        if (!role.equals("ADMIN")) {
            return "Only ADMIN can delete";
        }

        service.delete(id);
        return "Deleted";
    }
}