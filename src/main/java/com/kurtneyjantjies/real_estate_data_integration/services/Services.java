package com.kurtneyjantjies.real_estate_data_integration.services;

import java.util.List;
import java.util.Optional;

/**
 * Generic service interface for CRUD operations.
 *
 * @param <T> The entity type.
 */
public interface Services <T>{
    /**
     * Retrieves all entities.
     *
     * @return List of all entities.
     */
    List<T> getAll();

    /**
     * Retrieves an entity by its ID.
     *
     * @param id The entity ID.
     * @return An Optional containing the entity if found.
     */
    Optional<T> getById(Long id);

    /**
     * Creates a new entity.
     *
     * @param entity The entity to create.
     * @return The saved entity.
     */
    T create(T entity);

    /**
     * Updates an existing entity.
     *
     * @param id The ID of the entity to update.
     * @param entityDetails The updated entity data.
     * @return The updated entity.
     */
    T update(Long id, T entityDetails);

    /**
     * Deletes an entity by its ID.
     *
     * @param id The ID of the entity to delete.
     */
    void delete(Long id);
}
