package com.kurtneyjantjies.real_estate_data_integration.repositories;

import com.kurtneyjantjies.real_estate_data_integration.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Tenant entity.
 * Provides basic CRUD operations.
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
