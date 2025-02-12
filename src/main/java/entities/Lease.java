package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Represents a Lease in the system.
 * A Lease associates a Tenant with a Property and includes financial and timing details.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lease {
    /**
     * Unique identifier for the Lease.
     * Automatically generated with identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Property associated with the Lease.
     * The Lease must be linked to an existing Property.
     */
    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    @NotNull(message = "Property is required")
    private Property property;

    /**
     * The Tenant associated with the Lease.
     * The Lease must be linked to an existing Tenant.
     */
    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    @NotNull(message = "Tenant is required")
    private Tenant tenant;

    /**
     * The start date of the Lease.
     * It must not be in the future if you want to validate that the lease starts in the present or past.
     */
    @PastOrPresent(message = "Start date must be in the past or present")
    private Date startDate;


    /**
     * The end date of the Lease.
     * It must be after the start date.
     */
    @FutureOrPresent(message = "End date must be in the future or present")
    private Date endDate;

    /**
     * The rent amount for the Lease.
     * Must be a positive value.
     */
    @Positive(message = "Rent amount must be positive")
    private Double rentAmount;

    /**
     * The list of transactions related to this Lease.
     * A Lease can have multiple Transactions associated with it.
     * Any operations on the Lease entity will cascade to related Transaction entities.
     */
    @OneToMany(mappedBy = "lease", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

}
