package com.project.chatconnect.applications.repositories;

import com.project.chatconnect.domains.enities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface User repository.
 *
 * @author Huy Dang
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    /**
     * Find by username optional.
     *
     * @param username the username
     * @return the optional
     */
    @Query("{'$or':[{'username': ?0}, {'email': ?0}, {'phoneNumber': ?0}]}")
    Optional<User> findByUsername(String username);
}
