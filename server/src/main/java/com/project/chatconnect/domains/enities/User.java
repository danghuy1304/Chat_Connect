package com.project.chatconnect.domains.enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.chatconnect.constants.type.HTypeGender;
import com.project.chatconnect.constants.type.HTypeAccessModifier;
import com.project.chatconnect.constants.type.HTypeUserStatus;
import com.project.chatconnect.domains.enities.base.AuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * The type User entity.
 *
 * @author Huy Dang
 */
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends AuditingEntity {
    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;

    @JsonIgnore
    private String password;

    private String lastName;

    private String firstName;

    @Indexed(unique = true)
    private String email;

    private String phoneNumber;

    private Date dateOfBirth;

    private HTypeGender gender;

    @DBRef
    private Role role;

    private HTypeUserStatus status;

    private LocalDateTime lastOnline = LocalDateTime.now();

    private String ipAddress;

    private String location;

    private Integer loginFailCount = 0;

    @DBRef
    @JsonManagedReference
    private List<UserImage> images;

    private HTypeAccessModifier accessModifierDefault;
}
