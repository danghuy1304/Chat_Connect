package com.project.chatconnect.domains.enities;

import com.project.chatconnect.domains.enums.role.RoleCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Role entity.
 * Author: Huy Dang
 */
@Document(collection = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    private RoleCode roleCode;

    private String roleName;
}
