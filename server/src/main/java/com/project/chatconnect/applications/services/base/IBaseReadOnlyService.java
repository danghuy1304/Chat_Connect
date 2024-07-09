package com.project.chatconnect.applications.services.base;

/**
 * The interface Base read only service.
 *
 * @param <Entity> the type parameter
 * @param <Type>   the type parameter
 * @author Huy Dang
 */
public interface IBaseReadOnlyService<Entity, Type> {
    /**
     * Gets all.
     *
     * @return the all
     */
    Entity getAll();

    /**
     * Find by id entity.
     *
     * @param id the id
     * @return the entity
     */
    Entity findById(Type id);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Entity getById(Type id);
}
