package com.project.chatconnect.applications.services.base;

import java.util.List;

/**
 * The interface Base multiple service.
 * Author: Huy Dang
 *
 * @param <Entity> the type parameter
 * @param <DTO>    the type parameter
 * @param <Type>   the type parameter
 */
public interface IBaseMultipleService<Entity, DTO, Type> {
    /**
     * Insert multiple list.
     *
     * @param dtos the dtos
     * @return the list
     */
    List<Entity> insertMultiple(List<DTO> dtos);

    /**
     * Update multiple list.
     *
     * @param dtos the dtos
     * @return the list
     */
    List<Entity> updateMultiple(List<DTO> dtos);

    /**
     * Delete multiple int.
     *
     * @param types the types
     * @return the int
     */
    int deleteMultiple(List<Type> types);
}
