package com.project.chatconnect.domains.enities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.chatconnect.domains.enities.base.AuditingEntity;
import com.project.chatconnect.domains.enums.reaction.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The type Reaction.
 *
 * @author Huy Dang
 */
@Document(collection = "reactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reaction extends AuditingEntity {
    @Id
    private String id;

    @Field("postId")
    @DBRef
    @JsonBackReference
    private Post post;

    @Field("commentId")
    @DBRef
    @JsonBackReference
    private Comment comment;

    @Field("userId")
    @DBRef
    private User user;

    private ReactionType reactionType;
}
