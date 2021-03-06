package com.project.bank.ProjectBank.Entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "CustomerType")
@Getter
@Setter
public class CustomerType {
    @Id
    private ObjectId customerTypeId;
    private String customerTypeDescription;
    private List<String> customerIdList;
    private List<Customer> customerList;
}