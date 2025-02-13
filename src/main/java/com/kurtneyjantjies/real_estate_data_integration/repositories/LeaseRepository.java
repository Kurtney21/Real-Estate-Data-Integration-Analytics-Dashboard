package com.kurtneyjantjies.real_estate_data_integration.repositories;

import com.kurtneyjantjies.real_estate_data_integration.entities.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {
}
