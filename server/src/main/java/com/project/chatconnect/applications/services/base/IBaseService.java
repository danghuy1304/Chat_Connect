package com.project.chatconnect.applications.services.base;

public interface IBaseService<Entity, DTO, Type> extends IBaseReadOnlyService<Entity, Type> {

    Entity insert(DTO dto);

    Entity update(Type id, DTO dto);

    void delete(Type id);
}
