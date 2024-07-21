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

import java.util.List;

/**
 * The type Group.
 *
 * @author Huy Dang
 */
@Document(collection = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Group extends AuditingEntity {
    @Id
    private String id;

    private String name;

    private String cover;

    private boolean isPrivate;

    @Field("users")
    @DBRef
    private List<User> users;
}
