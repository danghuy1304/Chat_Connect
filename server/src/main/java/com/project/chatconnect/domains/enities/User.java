package com.project.chatconnect.domains.enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.chatconnect.domains.enities.base.AuditingEntity;
import com.project.chatconnect.domains.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends AuditingEntity {
    @Id
    @Field("id")
    private String id;

    @Field("userName")
    @Indexed(unique = true)
    private String userName;

    @Field("password")
    @JsonIgnore
    private String password;

    @Field("lastName")
    private String lastName;

    @Field("firstName")
    private String firstName;

    @Field("email")
    @Indexed(unique = true)
    private String email;

    @Field("phoneNumber")
    private String phoneNumber;

    @Field("dateOfBirth")
    private Date dateOfBirth;

    @Field("gender")
    private Gender gender;

    @Field("role")
    @DBRef
    private Role role;

    @Field("status")
    private String status;

    @Field("image")
    private String image;

    @Field("deleted")
    private Boolean deleted = Boolean.FALSE;
}
