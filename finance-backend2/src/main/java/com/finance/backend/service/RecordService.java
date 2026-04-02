package com.finance.backend.service;

import com.finance.backend.model.FinancialRecord;
import com.finance.backend.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository repo;

    public FinancialRecord add(FinancialRecord record) {
        record.setDate(LocalDate.now());
        return repo.save(record);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}