package com.kurtneyjantjies.real_estate_data_integration.services.realestateservices;

import com.kurtneyjantjies.real_estate_data_integration.entities.Lease;
import com.kurtneyjantjies.real_estate_data_integration.repositories.LeaseRepository;
import com.kurtneyjantjies.real_estate_data_integration.services.Services;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaseService implements Services<Lease> {

    private final LeaseRepository leaseRepository;

    // Constructor injection for the LeaseRepository dependency
    public LeaseService(LeaseRepository leaseRepository) {
        this.leaseRepository = leaseRepository;
    }

    /**
     * Fetches all Lease records from the repository.
     *
     * @return List of Lease objects.
     */
    @Override
    public List<Lease> getAll() {
        try {
            return leaseRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching leases: " + e.getMessage());
        }
    }

    /**
     * Fetches a Lease by its ID.
     *
     * @param id The ID of the Lease to retrieve.
     * @return An Optional containing the Lease if found, empty if not.
     */
    @Override
    public Optional<Lease> getById(Long id) {
        try {
            return leaseRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching lease with ID " + id + ": " + e.getMessage());
        }
    }

    /**
     * Creates a new Lease record.
     *
     * @param lease The Lease object to create.
     * @return The created Lease object.
     */
    @Override
    public Lease create(Lease lease) {
        try {
            return leaseRepository.save(lease);
        } catch (Exception e) {
            throw new RuntimeException("Error creating lease: " + e.getMessage());
        }
    }

    /**
     * Updates an existing Lease record.
     *
     * @param id The ID of the Lease to update.
     * @param lease The updated Lease object.
     * @return The updated Lease object.
     */
    @Override
    public Lease update(Long id, Lease lease) {
        try {
            // Fetch the Lease object by ID and update if found
            return leaseRepository.findById(id).map(updatedLease -> {
                updatedLease.setTenant(lease.getTenant());
                updatedLease.setProperty(lease.getProperty());
                updatedLease.setStartDate(lease.getStartDate());
                updatedLease.setEndDate(lease.getEndDate());
                updatedLease.setRentAmount(lease.getRentAmount());
                return leaseRepository.save(updatedLease);
            }).orElseThrow(() -> new RuntimeException("Lease not found with ID: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error updating lease with ID " + id + ": " + e.getMessage());
        }
    }

    /**
     * Deletes a Lease by its ID.
     *
     * @param id The ID of the Lease to delete.
     */
    @Override
    public void delete(Long id) {
        try {
            leaseRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting lease with ID " + id + ": " + e.getMessage());
        }
    }
}
