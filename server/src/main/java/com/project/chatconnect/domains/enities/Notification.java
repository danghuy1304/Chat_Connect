package com.project.chatconnect.domains.enities;

import com.project.chatconnect.domains.enities.base.AuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The type Notification.
 *
 * @author Huy Dang
 */
@Document(collection = "notifications")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notification extends AuditingEntity {
    @Id
    private String id;

    private String title;

    private String content;

    private String link;

    private String type;

    private Boolean isRead = Boolean.FALSE;

    @Field("userId")
    @DBRef
    private User user;
}
