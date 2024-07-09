package com.project.chatconnect.domains.enities;

import com.project.chatconnect.domains.enities.base.AuditingEntity;
import com.project.chatconnect.domains.enums.search.KeywordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The type Search keyword.
 *
 * @author Huy Dang
 */
@Document(collection = "searchKeywords")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchKeyword extends AuditingEntity {
    @Id
    private String id;

    private String keyword;

    private KeywordType type;

    @Field("userId")
    @DBRef
    private User user;
}
