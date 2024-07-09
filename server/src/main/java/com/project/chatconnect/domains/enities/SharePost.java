package com.project.chatconnect.domains.enities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
 * The type Share post.
 *
 * @author Huy Dang
 */
@Document(collection = "sharePosts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SharePost extends AuditingEntity {
    @Id
    private String id;

    @Field("postId")
    @DBRef
    @JsonBackReference
    private Post post;

    @Field("userId")
    @DBRef
    private User user;
}
