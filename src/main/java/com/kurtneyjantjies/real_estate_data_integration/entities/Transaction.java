package com.kurtneyjantjies.real_estate_data_integration.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * Represents a Transaction in the system.
 * A Transaction links a Lease with an amount paid and the date of payment.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    /**
     * Unique identifier for the Transaction.
     * Automatically generated with identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Lease associated with the Transaction.
     * Each Transaction is linked to a specific Lease.
     */
    @ManyToOne
    @JoinColumn(name = "lease_id", nullable = false)
    @NotNull(message = "Lease is required")
    private Lease lease;

    /**
     * The amount of money for this transaction.
     * Must be a positive value.
     */
    @Positive(message = "Amount must be positive")
    private Double amount;

    /**
     * The date when the Transaction was made.
     * It should be a valid date in the past or present.
     */
    @NotNull(message = "Transaction date is required")
    private Date date;

}
