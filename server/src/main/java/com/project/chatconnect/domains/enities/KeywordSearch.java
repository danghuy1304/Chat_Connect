package com.project.chatconnect.domains.enities;

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
 * The type Search keyword.
 *
 * @author Huy Dang
 */
@Document(collection = "searchKeywords")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KeywordSearch extends AuditingEntity {
    @Id
    private String id;

    private String keyword;

    private int count;

    @Field("userId")
    @DBRef
    private User user;
}
