package com.kurtneyjantjies.real_estate_data_integration.controllers;

import com.kurtneyjantjies.real_estate_data_integration.entities.Property;
import com.kurtneyjantjies.real_estate_data_integration.services.realestateservices.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    // Constructor injection for the PropertyService dependency
    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    /**
     * Get all properties.
     *
     * @return List of Property objects.
     */
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAll();
    }

    /**
     * Get a property by its ID.
     *
     * @param id The ID of the Property.
     * @return The Property object if found, else 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Optional<Property> property = propertyService.getById(id);
        return property.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create a new property.
     *
     * @param property The Property object to create.
     * @return The created Property object.
     */
    @PostMapping
    public ResponseEntity<Property> createProperty(@Valid @RequestBody Property property) {
        Property createdProperty = propertyService.create(property);
        return ResponseEntity.status(201).body(createdProperty);
    }

    /**
     * Update an existing property.
     *
     * @param id     The ID of the Property to update.
     * @param property The updated Property object.
     * @return The updated Property object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @Valid @RequestBody Property property) {
        Property updatedProperty = propertyService.update(id, property);
        return ResponseEntity.ok(updatedProperty);
    }

    /**
     * Delete a property by its ID.
     *
     * @param id The ID of the Property to delete.
     * @return Status 204 No Content if successful, else 404 Not Found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
