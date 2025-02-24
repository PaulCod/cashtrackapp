package cashtrack.cashtrackapi.service;

import cashtrack.cashtrackapi.model.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> findByUser_Id(Long userId);
}
