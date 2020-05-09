package com.example.dynamoproject.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.dynamoproject.model.Customer;

@ComponentScan
@EnableScan



public interface CustomerRepository extends CrudRepository<Customer, String> {
 
  List<Customer> findByLastName(String lastName);

  void save(List<Customer> asList);

  Object findOne(String id);
}
