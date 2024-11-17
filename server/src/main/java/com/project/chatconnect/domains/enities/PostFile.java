package com.project.chatconnect.domains.enities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.chatconnect.constants.type.HTypePostFile;
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
 * The type Post image.
 *
 * @author Huy Dang
 */
@Document(collection = "postImages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostFile extends AuditingEntity {
    @Id
    private String id;

    private String index;

    private String url;

    private HTypePostFile fileType;

    @Field("commentId")
    @DBRef
    @JsonBackReference
    private Comment comment;

    @Field("postId")
    @DBRef
    @JsonBackReference
    private Post post;
}
