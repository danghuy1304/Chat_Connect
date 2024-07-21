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
 * The type Message group member.
 *
 * @author Huy Dang
 */
@Document(collection = "messageGroupMember")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageGroupMember extends AuditingEntity {
    @Id
    private String id;

    @Field("chatId")
    @DBRef
    private Chat chat;

    @Field("userId")
    @DBRef
    private User user;
}
