package com.project.chatconnect.domains.enities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.chatconnect.constants.type.HTypeUserImage;
import com.project.chatconnect.constants.type.HTypeUserStatusImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The type User image entity.
 *
 * @author Huy Dang
 */
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserImage {
    @Id
    @Field("id")
    private String id;

    @Field("userId")
    @DBRef
    @JsonBackReference
    private User user;

    private String image;

    private HTypeUserImage imageType;

    private HTypeUserStatusImage status;
}
