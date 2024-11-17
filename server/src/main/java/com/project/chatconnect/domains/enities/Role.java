package com.project.chatconnect.domains.enities;

import com.project.chatconnect.constants.type.HTypeRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Role entity.
 *
 * @author Huy Dang
 */
@Document(collection = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    private HTypeRole roleCode;

    private String roleName;
}
