package com.project.chatconnect.domains.enities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * The type Log entry entity.
 *
 * @author Huy Dang
 */
@Document(collection = "logEntries")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogEntry {
    @Id
    private String id;

    private String type;

    private String api;

    private String ipAddress;

    private String userId;

    private String userAgent;

    private LocalDateTime logTime = LocalDateTime.now();
}
