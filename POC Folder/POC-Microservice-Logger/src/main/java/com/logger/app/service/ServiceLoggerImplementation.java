package com.logger.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.logger.app.model.LoggerProduct;
import com.logger.app.repository.LoggerRepository;

@Service
public class ServiceLoggerImplementation implements ServiceLogger{
	@Autowired
	LoggerRepository loggerRepository;
	
	
	@Override
	@KafkaListener(topics = "Products", groupId = "loggerId")
	public void consumes(String data) {
		LoggerProduct entity = new LoggerProduct();
		entity.setData(data);
		loggerRepository.save(entity);
	}
}
