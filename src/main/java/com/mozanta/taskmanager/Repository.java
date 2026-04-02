package com.mozanta.taskmanager;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface Repository extends MongoRepository<Tasks,String> {


}