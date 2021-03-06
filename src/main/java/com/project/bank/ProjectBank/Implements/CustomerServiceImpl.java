package com.project.bank.ProjectBank.Implements;

import com.project.bank.ProjectBank.Entity.Customer;
import com.project.bank.ProjectBank.Entity.CustomerType;
import com.project.bank.ProjectBank.Repository.CustomerRepository;
import com.project.bank.ProjectBank.Repository.CustomerTypeRepository;
import com.project.bank.ProjectBank.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> findById(ObjectId customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Flux<Customer> saveCustomer(Flux<Customer> customer) {
        return customerRepository.saveAll(customer);
    }

    @Override
    public Mono<Customer> updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Void> deleteCustomer(ObjectId customerId) {
        return customerRepository.deleteById(customerId);
    }

    private final CustomerTypeRepository customerTypeRepository;

    @Override
    public Flux<Customer> getCustomersByCustomerType(ObjectId customerTypeId) {
        CustomerType ct = new CustomerType();
        Mono<CustomerType> customerType = customerTypeRepository.findById(customerTypeId).defaultIfEmpty(ct);
        Flux<Customer> allCustomers = customerType.thenMany(customerRepository.findAll());
        Flux<Customer> customersById = allCustomers.filter(customer -> customer.getCustomerTypeId().equals(customerTypeId));
        return customersById;
    }
}
