package com.project.chatconnect.domains.enities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The entity About.
 *
 * @author Huy Dang
 */
@Document(collection = "About")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class About {
    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("about")
    private String about;
}
