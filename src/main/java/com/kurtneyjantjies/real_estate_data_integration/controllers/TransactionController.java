package com.kurtneyjantjies.real_estate_data_integration.controllers;

import com.kurtneyjantjies.real_estate_data_integration.entities.Transaction;
import com.kurtneyjantjies.real_estate_data_integration.services.realestateservices.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    // Constructor injection for the TransactionService dependency
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Get all transactions.
     *
     * @return List of Transaction objects.
     */
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAll();
    }

    /**
     * Get a transaction by its ID.
     *
     * @param id The ID of the Transaction.
     * @return The Transaction object if found, else 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionService.getById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create a new transaction.
     *
     * @param transaction The Transaction object to create.
     * @return The created Transaction object.
     */
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.create(transaction);
        return ResponseEntity.status(201).body(createdTransaction);
    }

    /**
     * Update an existing transaction.
     *
     * @param id The ID of the Transaction to update.
     * @param transaction The updated Transaction object.
     * @return The updated Transaction object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @Valid @RequestBody Transaction transaction) {
        Transaction updatedTransaction = transactionService.update(id, transaction);
        return ResponseEntity.ok(updatedTransaction);
    }

    /**
     * Delete a transaction by its ID.
     *
     * @param id The ID of the Transaction to delete.
     * @return Status 204 No Content if successful, else 404 Not Found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
