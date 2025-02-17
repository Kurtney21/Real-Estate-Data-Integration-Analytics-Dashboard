package com.kurtneyjantjies.real_estate_data_integration.controllers;

import com.kurtneyjantjies.real_estate_data_integration.entities.Tenant;
import com.kurtneyjantjies.real_estate_data_integration.services.realestateservices.TenantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    private final TenantService tenantService;

    // Constructor injection for the TenantService dependency
    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    /**
     * Get all tenants.
     *
     * @return List of Tenant objects.
     */
    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenantService.getAll();
    }

    /**
     * Get a tenant by its ID.
     *
     * @param id The ID of the Tenant.
     * @return The Tenant object if found, else 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {
        Optional<Tenant> tenant = tenantService.getById(id);
        return tenant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create a new tenant.
     *
     * @param tenant The Tenant object to create.
     * @return The created Tenant object.
     */
    @PostMapping
    public ResponseEntity<Tenant> createTenant(@Valid @RequestBody Tenant tenant) {
        Tenant createdTenant = tenantService.create(tenant);
        return ResponseEntity.status(201).body(createdTenant);
    }

    /**
     * Update an existing tenant.
     *
     * @param id     The ID of the Tenant to update.
     * @param tenant The updated Tenant object.
     * @return The updated Tenant object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Tenant> updateTenant(@PathVariable Long id, @Valid @RequestBody Tenant tenant) {
        Tenant updatedTenant = tenantService.update(id, tenant);
        return ResponseEntity.ok(updatedTenant);
    }

    /**
     * Delete a tenant by its ID.
     *
     * @param id The ID of the Tenant to delete.
     * @return Status 204 No Content if successful, else 404 Not Found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTenant(@PathVariable Long id) {
        tenantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
