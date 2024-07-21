package com.project.chatconnect.domains.enities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "HashTagSearch")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HashTagSearch {
    @Id
    private String id;

    private String hashTag;

    private int count;

    @Field("userId")
    @DBRef
    private User user;
}
