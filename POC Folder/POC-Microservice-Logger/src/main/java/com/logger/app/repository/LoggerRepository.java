package com.logger.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.logger.app.model.LoggerProduct;

@Repository
public interface LoggerRepository extends MongoRepository<LoggerProduct, String> {

}
