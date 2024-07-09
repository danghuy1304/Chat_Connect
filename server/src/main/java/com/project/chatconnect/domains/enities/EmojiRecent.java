package com.project.chatconnect.domains.enities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * The type Emoji recent.
 *
 * @author Huy Dang
 */
@Document(collection = "emojiRecent")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmojiRecent {
    @Id
    private String id;

    @Field("userId")
    @DBRef
    private User user;

    @Field("emojiId")
    @DBRef
    private List<Emoji> emojis;
}
