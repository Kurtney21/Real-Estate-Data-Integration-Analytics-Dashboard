package com.kurtneyjantjies.real_estate_data_integration.factories;

import com.kurtneyjantjies.real_estate_data_integration.entities.Lease;
import com.kurtneyjantjies.real_estate_data_integration.entities.Transaction;

import java.util.Date;

public class TransactionFactory {
    /**
     * Creates a new Transaction instance with provided details.
     *
     * @param lease The lease associated with the transaction.
     * @param amount The amount of the transaction.
     * @param date The date of the transaction.
     * @return A new Transaction object.
     */
    public static Transaction createTransaction(Lease lease, Double amount, Date date) {
        Transaction transaction = new Transaction();
        transaction.setLease(lease);
        transaction.setAmount(amount);
        transaction.setDate(date);
        return transaction;
    }

    /**
     * Creates a Transaction instance with predefined values for testing purposes.
     *
     * @param lease The lease associated with the transaction.
     * @return A new Transaction object with test data.
     */
    public static Transaction createTestTransaction(Lease lease) {
        return createTransaction(lease, 1000.0, new Date());
    }
}
