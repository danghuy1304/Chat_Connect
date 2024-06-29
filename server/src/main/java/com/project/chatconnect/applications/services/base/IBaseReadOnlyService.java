package com.project.chatconnect.applications.services.base;

public interface IBaseReadOnlyService<Entity, Type> {
    Entity getAll();

    Entity findById(Type id);

    Entity getById(Type id);
}
