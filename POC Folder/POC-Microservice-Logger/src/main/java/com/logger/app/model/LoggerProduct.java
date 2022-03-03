package com.logger.app.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "logger")

public class LoggerProduct {
	
	@Id
	private String loggerId;
	private String data;
	@CreatedDate
	private Date date;
	
	
	public String getLoggerId() {
		return loggerId;
	}
	public void setLoggerId(String loggerId) {
		this.loggerId = loggerId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
