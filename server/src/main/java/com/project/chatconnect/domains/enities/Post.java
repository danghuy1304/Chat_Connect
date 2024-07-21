package com.project.chatconnect.domains.enities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.chatconnect.domains.enities.base.AuditingEntity;
import com.project.chatconnect.domains.enums.post.AccessModifier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * The type Post.
 *
 * @author Huy Dang
 */
@Document(collection = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post extends AuditingEntity {
    @Id
    private String id;

    private AccessModifier accessModifier;

    private String content;

    private String background;

    private String color;

    @Field("userId")
    @DBRef
    private User user;

    @DBRef
    @JsonManagedReference
    private List<PostFile> postFiles;

    @DBRef
    @JsonManagedReference
    private List<Comment> comments;

    @DBRef
    @JsonManagedReference
    private List<Reaction> reactions;

    @DBRef
    @JsonManagedReference
    private List<SharePost> sharePosts;

    @DBRef
    @JsonManagedReference
    private List<PermissionViewPost> permissionViewPosts;

    @Field("groupId")
    @DBRef
    private Group group;

    @Indexed
    private List<String> hashtag;

    @Indexed
    private List<String> keyword;
}
