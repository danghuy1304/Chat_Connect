package com.project.chatconnect.domains.enities.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class AuditingEntity {
    @Field("createdBy")
    @CreatedBy
    private String createdBy;

    @Field("updatedBy")
    @LastModifiedBy
    private String updatedBy;

    @Field("updatedAt")
    @CreatedDate
    private LocalDateTime updatedAt;

    @Field("createdAt")
    @LastModifiedDate
    private LocalDateTime createdAt;
}
