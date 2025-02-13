package com.kurtneyjantjies.real_estate_data_integration.factories;

import com.kurtneyjantjies.real_estate_data_integration.entities.Lease;
import com.kurtneyjantjies.real_estate_data_integration.entities.Property;
import com.kurtneyjantjies.real_estate_data_integration.entities.Tenant;

import java.util.Date;

public class LeaseFactory {
    /**
     * Creates a new Lease instance with provided details.
     *
     * @param property The property associated with the lease.
     * @param tenant The tenant associated with the lease.
     * @param startDate The start date of the lease.
     * @param endDate The end date of the lease.
     * @param rentAmount The rent amount for the lease.
     * @return A new Lease object.
     */
    public static Lease createLease(Property property, Tenant tenant, Date startDate, Date endDate, Double rentAmount) {
        Lease lease = new Lease();
        lease.setProperty(property);
        lease.setTenant(tenant);
        lease.setStartDate(startDate);
        lease.setEndDate(endDate);
        lease.setRentAmount(rentAmount);
        return lease;
    }

    /**
     * Creates a Lease instance with predefined values for testing purposes.
     *
     * @param property The property associated with the lease.
     * @param tenant The tenant associated with the lease.
     * @return A new Lease object with test data.
     */
//    public static Lease createTestLease(Property property, Tenant tenant) {
//        return createLease(property, tenant, new Date(), new Date(System.currentTimeMillis() + 1000000000), 1500.0);
//    }
}
