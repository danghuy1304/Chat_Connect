package com.project.chatconnect.domains.dtos.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.chatconnect.annotation.validator.HVItems;
import com.project.chatconnect.constants.type.HTypeGender;
import com.project.chatconnect.constants.type.HTypeRole;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


/**
 * The type User dto.
 *
 * @author Huy Dang
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String id;

    private String userName;

    @JsonIgnore
    private String password;

    private String lastName;

    private String firstName;

    @NotNull(message = "Email cannot be null")
    private String email;

    private String phoneNumber;

    private Date dateOfBirth;

    @HVItems(target = HTypeGender.class)
    private HTypeGender gender;

    @HVItems(target = HTypeRole.class)
    private HTypeRole roleCode;

    private String status;

    private String image;

    private Boolean deleted;
}
