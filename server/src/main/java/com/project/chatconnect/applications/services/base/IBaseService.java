package com.project.chatconnect.applications.services.base;

/**
 * The interface Base service.
 * Author: Huy Dang
 *
 * @param <Entity> the type parameter
 * @param <DTO>    the type parameter
 * @param <Type>   the type parameter
 */
public interface IBaseService<Entity, DTO, Type> extends IBaseReadOnlyService<Entity, Type> {

    /**
     * Insert entity.
     *
     * @param dto the dto
     * @return the entity
     */
    Entity insert(DTO dto);

    /**
     * Update entity.
     *
     * @param id  the id
     * @param dto the dto
     * @return the entity
     */
    Entity update(Type id, DTO dto);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(Type id);
}
