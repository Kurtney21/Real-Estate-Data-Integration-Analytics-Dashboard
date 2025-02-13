package com.kurtneyjantjies.real_estate_data_integration.factories;

import com.kurtneyjantjies.real_estate_data_integration.entities.Tenant;

public class TenantFactory {
    /**
     * Creates a new Tenant instance with provided details.
     *
     * @param firstname The first name of the tenant.
     * @param lastname The last name of the tenant.
     * @param email The email address of the tenant.
     * @param number The phone number of the tenant.
     * @return A new Tenant object.
     */
    public static Tenant createTenant(String firstname, String lastname, String email, String number){
        Tenant tenant = new Tenant();
        tenant.setFirstname(firstname);
        tenant.setLastname(lastname);
        tenant.setEmail(email);
        tenant.setNumber(number);
        return tenant;
    }

    /**
     * Creates a Tenant instance with predefined values for testing purposes.
     *
     * @return A new Tenant object with test data.
     */
    public static Tenant createTestTenant() {
        return createTenant("John", "Doe", "john.doe@example.com", "1234567890");
    }
}
