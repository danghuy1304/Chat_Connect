package com.project.chatconnect.applications.repositories;

import com.project.chatconnect.domains.enities.LogEntry;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Log entry repository.
 *
 * @author Huy Dang
 */
@Repository
@Primary
public interface LogEntryRepository extends MongoRepository<LogEntry, String> {
}
