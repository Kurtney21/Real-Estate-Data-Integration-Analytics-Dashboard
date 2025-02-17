package com.kurtneyjantjies.real_estate_data_integration.services.realestateservices;

import com.kurtneyjantjies.real_estate_data_integration.entities.Tenant;
import com.kurtneyjantjies.real_estate_data_integration.repositories.TenantRepository;
import com.kurtneyjantjies.real_estate_data_integration.services.Services;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantService implements Services<Tenant> {

    private final TenantRepository tenantRepository;

    // Constructor injection for the TenantRepository dependency
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    /**
     * Fetches all Tenant records from the repository.
     *
     * @return List of Tenant objects.
     */
    @Override
    public List<Tenant> getAll() {
        try {
            return tenantRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching tenants: " + e.getMessage());
        }
    }

    /**
     * Fetches a Tenant by its ID.
     *
     * @param id The ID of the Tenant to retrieve.
     * @return An Optional containing the Tenant if found, empty if not.
     */
    @Override
    public Optional<Tenant> getById(Long id) {
        try {
            return tenantRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching tenant with ID " + id + ": " + e.getMessage());
        }
    }

    /**
     * Creates a new Tenant record.
     *
     * @param tenant The Tenant object to create.
     * @return The created Tenant object.
     */
    @Override
    public Tenant create(Tenant tenant) {
        try {
            return tenantRepository.save(tenant);
        } catch (Exception e) {
            throw new RuntimeException("Error creating tenant: " + e.getMessage());
        }
    }

    /**
     * Updates an existing Tenant record.
     *
     * @param id The ID of the Tenant to update.
     * @param tenant The updated Tenant object.
     * @return The updated Tenant object.
     */
    @Override
    public Tenant update(Long id, Tenant tenant) {
        try {
            return tenantRepository.findById(id).map(updatedTenant -> {
                updatedTenant.setFirstname(tenant.getFirstname());
                updatedTenant.setLastname(tenant.getLastname());
                updatedTenant.setEmail(tenant.getEmail());
                updatedTenant.setLeases(tenant.getLeases());
                return tenantRepository.save(updatedTenant);
            }).orElseThrow(() -> new RuntimeException("Tenant not found with ID: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error updating tenant with ID " + id + ": " + e.getMessage());
        }
    }

    /**
     * Deletes a Tenant by its ID.
     *
     * @param id The ID of the Tenant to delete.
     */
    @Override
    public void delete(Long id) {
        try {
            tenantRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting tenant with ID " + id + ": " + e.getMessage());
        }
    }
}
