package com.kurtneyjantjies.real_estate_data_integration.services.realestateservices;

import com.kurtneyjantjies.real_estate_data_integration.entities.Transaction;
import com.kurtneyjantjies.real_estate_data_integration.repositories.TransactionRepository;
import com.kurtneyjantjies.real_estate_data_integration.services.Services;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements Services<Transaction> {

    private final TransactionRepository transactionRepository;

    // Constructor injection for the TransactionRepository dependency
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Fetches all Transaction records from the repository.
     *
     * @return List of Transaction objects.
     */
    @Override
    public List<Transaction> getAll() {
        try {
            return transactionRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching transactions: " + e.getMessage());
        }
    }

    /**
     * Fetches a Transaction by its ID.
     *
     * @param id The ID of the Transaction to retrieve.
     * @return An Optional containing the Transaction if found, empty if not.
     */
    @Override
    public Optional<Transaction> getById(Long id) {
        try {
            return transactionRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching transaction with ID " + id + ": " + e.getMessage());
        }
    }

    /**
     * Creates a new Transaction record.
     *
     * @param transaction The Transaction object to create.
     * @return The created Transaction object.
     */
    @Override
    public Transaction create(Transaction transaction) {
        try {
            return transactionRepository.save(transaction);
        } catch (Exception e) {
            throw new RuntimeException("Error creating transaction: " + e.getMessage());
        }
    }

    /**
     * Updates an existing Transaction record.
     *
     * @param id The ID of the Transaction to update.
     * @param transaction The updated Transaction object.
     * @return The updated Transaction object.
     */
    @Override
    public Transaction update(Long id, Transaction transaction) {
        try {
            // Fetch the Transaction object by ID and update if found
            return transactionRepository.findById(id).map(updatedTransaction -> {
                updatedTransaction.setLease(transaction.getLease());
                updatedTransaction.setAmount(transaction.getAmount());
                updatedTransaction.setDate(transaction.getDate());
                return transactionRepository.save(updatedTransaction);
            }).orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error updating transaction with ID " + id + ": " + e.getMessage());
        }
    }

    /**
     * Deletes a Transaction by its ID.
     *
     * @param id The ID of the Transaction to delete.
     */
    @Override
    public void delete(Long id) {
        try {
            transactionRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting transaction with ID " + id + ": " + e.getMessage());
        }
    }
}
