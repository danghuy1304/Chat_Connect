package com.project.chatconnect.applications.services.base;

import java.util.List;

public interface IBaseMultipleService<Entity, DTO, Type> {
    List<Entity> insertMultiple(List<DTO> dtos);

    List<Entity> updateMultiple(List<DTO> dtos);

    int deleteMultiple(List<Type> types);
}
