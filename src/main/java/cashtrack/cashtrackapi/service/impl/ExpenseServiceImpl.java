package cashtrack.cashtrackapi.service.impl;

import cashtrack.cashtrackapi.model.Expense;
import cashtrack.cashtrackapi.repository.ExpenseRepository;
import cashtrack.cashtrackapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.expenseRepository = repository;
    }

    @Override
    public List<Expense> findByUser_Id(Long userId) {
        List<Expense> expenses = expenseRepository.findByUser_Id(userId);

        return expenses;
    }
}
