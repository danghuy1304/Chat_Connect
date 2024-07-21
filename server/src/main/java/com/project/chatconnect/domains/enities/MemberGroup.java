package com.project.chatconnect.domains.enities;

import com.project.chatconnect.domains.enities.base.AuditingEntity;
import com.project.chatconnect.domains.enums.group.PermissionMemberGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The type Member group.
 *
 * @author Huy Dang
 */
@Document(collection = "memberGroups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberGroup extends AuditingEntity {
    @Id
    private String id;

    private PermissionMemberGroup permission;

    private String status;

    @Field("groupId")
    @DBRef
    private Group group;

    @Field("userId")
    @DBRef
    private User user;
}
