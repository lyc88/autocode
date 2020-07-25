package com.example.demo.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "person")
public class Person {

    @Id
    private Integer id;

    @Field(value = "name")
    private String userName;

    @Field
    private Integer age;
}