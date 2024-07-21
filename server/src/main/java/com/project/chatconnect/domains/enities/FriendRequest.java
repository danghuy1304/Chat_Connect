package com.project.chatconnect.domains.enities;

import com.project.chatconnect.domains.enities.base.AuditingEntity;
import com.project.chatconnect.domains.enums.friend.FriendRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The type Friend request.
 *
 * @author Huy Dang
 */
@Document(collection = "friendRequest")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FriendRequest extends AuditingEntity {
    @Id
    private String id;

    private FriendRequestStatus status;

    @Field("userId")
    @DBRef
    private User user;

    @Field("friendId")
    @DBRef
    private User friend;
}
