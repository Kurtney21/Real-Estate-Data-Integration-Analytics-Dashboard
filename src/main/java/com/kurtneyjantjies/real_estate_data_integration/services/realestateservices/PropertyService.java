package com.kurtneyjantjies.real_estate_data_integration.services.realestateservices;

import com.kurtneyjantjies.real_estate_data_integration.entities.Property;
import com.kurtneyjantjies.real_estate_data_integration.repositories.PropertyRepository;
import com.kurtneyjantjies.real_estate_data_integration.services.Services;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for Property entity.
 * Implements CRUD operations using PropertyRepository.
 */
@Service
public class PropertyService implements Services<Property> {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    @Override
    public Optional<Property> getById(Long id) {
        return propertyRepository.findById(id);
    }

    @Override
    public Property create(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property update(Long id, Property property) {
        return propertyRepository.findById(id).map(prop ->{
            prop.setAddress(property.getAddress());
            prop.setOwner(property.getOwner());
            prop.setValue(property.getValue());
            prop.setStatus(property.getStatus());
            return propertyRepository.save(prop);
        }).orElseThrow(() -> new RuntimeException("Property not found!"));
    }

    @Override
    public void delete(Long id) {
        propertyRepository.deleteById(id);
    }
}
