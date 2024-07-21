package com.project.chatconnect.domains.enities;

import com.project.chatconnect.domains.enities.base.AuditingEntity;
import com.project.chatconnect.domains.enums.chat.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

/**
 * The type Messages.
 *
 * @author Huy Dang
 */
@Document(collection = "messages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Messages extends AuditingEntity {
    @Id
    private String id;

    private String content;

    @DBRef
    private User sender;

    @DBRef
    private Set<User> reader;

    private MessageType type;

    @Field("chatId")
    @DBRef
    private Chat chat;
}
