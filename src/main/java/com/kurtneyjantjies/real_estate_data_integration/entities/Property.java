package com.kurtneyjantjies.real_estate_data_integration.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a Property in the system.
 * A Property can have multiple Leases associated with it.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    /**
     * Unique identifier for the Property.
     * Automatically generated with identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The address of the Property.
     * Cannot be blank or null.
     */
    @NotBlank(message = "Address is required")
    private String address;

    /**
     * The owner of the Property.
     * Cannot be blank or null.
     */
    @NotBlank(message = "Owner is required")
    private String owner;

    /**
     * The value of the Property.
     * Must be a positive value.
     */
    @Positive(message = "Property value must be positive")
    private Double value;

    /**
     * The status of the Property (e.g., available, rented, under maintenance).
     * Cannot be null or blank.
     */
    @NotBlank(message = "Status is required")
    private String status;

    /**
     * The list of leases associated with this Property.
     * A Property can have multiple Leases.
     * Any operations on the Property entity will cascade to related Lease entities.
     */
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Lease> leases;

}
