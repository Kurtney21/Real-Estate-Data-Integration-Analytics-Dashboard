package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a Tenant in the system.
 * A Tenant can have multiple Leases associated with them.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {
    /**
     * Unique identifier for the Tenant.
     * Automatically generated with identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the Tenant.
     * Cannot be null or empty.
     */
    @NotBlank(message = "First name is required")
    private String firstname;

    /**
     * The last name of the Tenant.
     * Cannot be null or empty.
     */
    @NotBlank(message = "Last name is required")
    private String lastname;


    /**
     * The email address of the Tenant.
     * Must follow a valid email format.
     */
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    /**
     * The phone number of the Tenant.
     * Must be between 10 and 15 characters.
     */
    @Size(min = 10, max = 15, message = "Phone number should be between 10 and 15 characters")
    private String number;

    /**
     * The list of leases associated with the Tenant.
     * A Tenant can have multiple Leases.
     * Any operations on the Tenant entity will cascade to related Lease entities.
     */
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<Lease> leases;

}
