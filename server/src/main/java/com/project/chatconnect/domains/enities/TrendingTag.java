package com.project.chatconnect.domains.enities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trendingTag")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrendingTag {
    @Id
    private String id;

    private String hashTag;

    private int count;

    private int index;
}
