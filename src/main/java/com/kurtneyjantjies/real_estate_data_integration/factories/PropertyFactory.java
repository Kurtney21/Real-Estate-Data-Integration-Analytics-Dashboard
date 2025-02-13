package com.kurtneyjantjies.real_estate_data_integration.factories;

import com.kurtneyjantjies.real_estate_data_integration.entities.Property;

public class PropertyFactory {
    /**
     * Creates a new Property instance with provided details.
     *
     * @param address The address of the property.
     * @param owner The owner of the property.
     * @param value The value of the property.
     * @param status The status of the property.
     * @return A new Property object.
     */
    public static Property createProperty(String address, String owner, Double value, String status) {
        Property property = new Property();
        property.setAddress(address);
        property.setOwner(owner);
        property.setValue(value);
        property.setStatus(status);
        return property;
    }

    /**
     * Creates a Property instance with predefined values for testing purposes.
     *
     * @return A new Property object with test data.
     */
    public static Property createTestProperty() {
        return createProperty("123 Main St", "John Smith", 250000.0, "Available");
    }

}
