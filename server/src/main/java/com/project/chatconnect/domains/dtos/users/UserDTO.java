package com.project.chatconnect.domains.dtos.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.chatconnect.domains.enums.Gender;
import com.project.chatconnect.domains.enums.RoleCode;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


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

    private Gender gender;

    private RoleCode roleCode;

    private String status;

    private String image;

    private Boolean deleted;
}
