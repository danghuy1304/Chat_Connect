package com.project.chatconnect.configs.mongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.project.chatconnect.applications.repositories")
public class MongoConfig {
}
