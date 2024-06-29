package com.project.chatconnect.applications.repositories;

import com.project.chatconnect.domains.enities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'$or':[{'username': ?0}, {'email': ?0}, {'phoneNumber': ?0}]}")
    Optional<User> findByUsername(String username);
}
