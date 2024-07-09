package com.project.chatconnect.domains.enities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
 * The type Comment.
 *
 * @author Huy Dang
 */
@Document(collection = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Comment extends AuditingEntity {
    @Id
    private String id;

    private String content;

    @Field("userId")
    @DBRef
    private User user;

    @Field("postId")
    @DBRef
    private Post post;

    @DBRef
    @JsonManagedReference
    private List<Reaction> reactions;

    @DBRef
    @JsonManagedReference
    private List<PostFile> postFiles;
}
