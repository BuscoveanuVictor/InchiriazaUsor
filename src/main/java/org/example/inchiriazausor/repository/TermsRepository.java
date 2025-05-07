package org.example.inchiriazausor.repository;

import org.example.inchiriazausor.model.Terms;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TermsRepository extends MongoRepository<Terms, String> {
}