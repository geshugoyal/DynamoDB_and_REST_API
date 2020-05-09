package com.example.dynamoproject.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.dynamoproject.model.Customer;
import com.example.dynamoproject.repository.CustomerRepository;
 
@RestController
public class WebController {
	
final static Logger logger = LoggerFactory.getLogger(WebController.class);
 
  @Autowired
  CustomerRepository repository;
 
  @DeleteMapping("/delete")
  public String delete() {
	  logger.info("delete method from controller");
    repository.deleteAll();
    return "Done";
  }
 
  @PostMapping("/save")
  public String save() {
    // save a single Customer
    repository.save(new Customer("5", "Chetna", "Nager"));
    logger.info("single user saved from controller from controller");
 
    // save a list of Customers
    repository.save(Arrays.asList(new Customer("1", "Anirudh", "Joseph"), new Customer("2", "Yash", "Goyal"),
        new Customer("3", "Rahul", "Dravid"), new Customer("4", "Priyanka", "Chhillar")));
 
    logger.info("user list saved method from controller");
    return "Done";
  }
 
  @GetMapping("/find")
  public String findAll() {
    String result = "";
    Iterable<Customer> customers = repository.findAll();
 
    for (Customer cust : customers) {
      result += cust.toString() + "<br>";
    }
 
    logger.info("All users list found method from controller");
    return result;
  }
 
  @GetMapping("/find/{id}")
  public String findById(@PathVariable String id) {
    String result = "";
    result = repository.findOne(id).toString();
    logger.info("the user with given id found method from controller");
    return result;
  }
 
  @GetMapping("/findbylastname")
  public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
    String result = "";
 
    for (Customer cust : repository.findByLastName(lastName)) {
      result += cust.toString() + "<br>";
    }
    logger.info("find by last name method from controller");
    return result;
  }
}