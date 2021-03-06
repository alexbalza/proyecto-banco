package com.project.bank.ProjectBank.Service;

import com.project.bank.ProjectBank.Entity.Customer;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
  Flux<Customer> findAll();
  Mono<Customer> findById(ObjectId customerId);
  Flux<Customer> saveCustomer(Flux<Customer> customer);
  Mono<Customer> updateCustomer(Customer customer);
  Mono<Void> deleteCustomer(ObjectId customerId);
  Flux<Customer> getCustomersByCustomerType(ObjectId customerTypeId);
}
