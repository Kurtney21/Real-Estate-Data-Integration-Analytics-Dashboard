package com.kurtneyjantjies.real_estate_data_integration.repositories;

import com.kurtneyjantjies.real_estate_data_integration.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Transaction entity.
 * Provides basic CRUD operations.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
