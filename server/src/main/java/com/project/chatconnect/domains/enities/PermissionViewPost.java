package com.project.chatconnect.domains.enities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The type Permission view post.
 *
 * @author Huy Dang
 */
@Document(collection = "accessModifiers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PermissionViewPost {
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
