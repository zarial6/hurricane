package com.hurricane.mindmap.repository;

import com.hurricane.mindmap.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    User findByUsername(String username);
}
