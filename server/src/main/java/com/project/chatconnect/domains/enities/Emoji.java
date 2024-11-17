package com.project.chatconnect.domains.enities;

import com.project.chatconnect.constants.type.HTypeEmoji;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Emoji.
 *
 * @author Huy Dang
 */
@Document(collection = "emojis")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Emoji {
    @Id
    private String id;

    private String name;

    private String unicode;

    private HTypeEmoji emojiType;
}
