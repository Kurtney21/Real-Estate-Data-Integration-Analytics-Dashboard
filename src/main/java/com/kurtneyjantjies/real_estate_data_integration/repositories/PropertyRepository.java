package com.kurtneyjantjies.real_estate_data_integration.repositories;

import com.kurtneyjantjies.real_estate_data_integration.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Propertya entity.
 * Provides basic CRUD operations.
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
