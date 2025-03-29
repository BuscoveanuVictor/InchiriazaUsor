package org.example.inchiriazausor.repository;

import org.example.inchiriazausor.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
} 