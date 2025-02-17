package com.kurtneyjantjies.real_estate_data_integration.controllers;

import com.kurtneyjantjies.real_estate_data_integration.entities.Lease;
import com.kurtneyjantjies.real_estate_data_integration.services.realestateservices.LeaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leases")
public class LeaseController {

    private final LeaseService leaseService;

    // Constructor injection for the LeaseService dependency
    @Autowired
    public LeaseController(LeaseService leaseService) {
        this.leaseService = leaseService;
    }

    /**
     * Get all leases.
     *
     * @return List of Lease objects.
     */
    @GetMapping
    public List<Lease> getAllLeases() {
        return leaseService.getAll();
    }

    /**
     * Get a lease by its ID.
     *
     * @param id The ID of the Lease.
     * @return The Lease object if found, else 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Lease> getLeaseById(@PathVariable Long id) {
        Optional<Lease> lease = leaseService.getById(id);
        return lease.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create a new lease.
     *
     * @param lease The Lease object to create.
     * @return The created Lease object.
     */
    @PostMapping
    public ResponseEntity<Lease> createLease(@Valid @RequestBody Lease lease) {
        Lease createdLease = leaseService.create(lease);
        return ResponseEntity.status(201).body(createdLease);
    }

    /**
     * Update an existing lease.
     *
     * @param id   The ID of the Lease to update.
     * @param lease The updated Lease object.
     * @return The updated Lease object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Lease> updateLease(@PathVariable Long id, @Valid @RequestBody Lease lease) {
        Lease updatedLease = leaseService.update(id, lease);
        return ResponseEntity.ok(updatedLease);
    }

    /**
     * Delete a lease by its ID.
     *
     * @param id The ID of the Lease to delete.
     * @return Status 204 No Content if successful, else 404 Not Found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLease(@PathVariable Long id) {
        leaseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
