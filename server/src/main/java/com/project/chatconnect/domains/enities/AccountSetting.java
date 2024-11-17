package com.project.chatconnect.domains.enities;

import com.project.chatconnect.constants.type.HTypeLanguage;
import com.project.chatconnect.constants.type.HTypeTheme;
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
 * The type Chat.
 *
 * @author Huy Dang
 */
@Document(collection = "accountSetting")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountSetting extends AuditingEntity {
    @Id
    @Field("userId")
    @DBRef
    private User user;

    @Field("language")
    private HTypeLanguage language = HTypeLanguage.VIETNAMESE;

    @Field("theme")
    private HTypeTheme theme;

    @Field("timezone")
    private String timezone;
}
