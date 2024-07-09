package com.project.chatconnect.domains.enities.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * The type Auditing entity.
 *
 * @author Huy Dang
 * CreatedDate: 06/07/2024
 * ModifiedDate: 06/07/2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class AuditingEntity {
    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime createdAt;

    @LastModifiedBy
    private String updatedBy;

    @CreatedDate
    private LocalDateTime updatedAt;
}
