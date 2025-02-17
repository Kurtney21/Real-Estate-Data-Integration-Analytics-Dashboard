package com.kurtneyjantjies.real_estate_data_integration.services.realestateservices;

import com.kurtneyjantjies.real_estate_data_integration.entities.Property;
import com.kurtneyjantjies.real_estate_data_integration.repositories.PropertyRepository;
import com.kurtneyjantjies.real_estate_data_integration.services.Services;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService implements Services<Property> {

    private final PropertyRepository propertyRepository;

    // Constructor injection for the PropertyRepository dependency
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    /**
     * Fetches all Property records from the repository.
     *
     * @return List of Property objects.
     */
    @Override
    public List<Property> getAll() {
        try {
            return propertyRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching properties: " + e.getMessage());
        }
    }

    /**
     * Fetches a Property by its ID.
     *
     * @param id The ID of the Property to retrieve.
     * @return An Optional containing the Property if found, empty if not.
     */
    @Override
    public Optional<Property> getById(Long id) {
        try {
            return propertyRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching property with ID " + id + ": " + e.getMessage());
        }
    }

    /**
     * Creates a new Property record.
     *
     * @param property The Property object to create.
     * @return The created Property object.
     */
    @Override
    public Property create(Property property) {
        try {
            return propertyRepository.save(property);
        } catch (Exception e) {
            throw new RuntimeException("Error creating property: " + e.getMessage());
        }
    }

    /**
     * Updates an existing Property record.
     *
     * @param id The ID of the Property to update.
     * @param property The updated Property object.
     * @return The updated Property object.
     */
    @Override
    public Property update(Long id, Property property) {
        try {
            // Fetch the Property object by ID and update if found
            return propertyRepository.findById(id).map(updatedProperty -> {
                updatedProperty.setAddress(property.getAddress());
                updatedProperty.setOwner(property.getOwner());
                updatedProperty.setValue(property.getValue());
                updatedProperty.setStatus(property.getStatus());
                return propertyRepository.save(updatedProperty);
            }).orElseThrow(() -> new RuntimeException("Property not found with ID: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error updating property with ID " + id + ": " + e.getMessage());
        }
    }

    /**
     * Deletes a Property by its ID.
     *
     * @param id The ID of the Property to delete.
     */
    @Override
    public void delete(Long id) {
        try {
            propertyRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting property with ID " + id + ": " + e.getMessage());
        }
    }
}
