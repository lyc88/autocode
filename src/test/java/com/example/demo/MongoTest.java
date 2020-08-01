package com.example.demo;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test(){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(0).and("name").is("瓜田李下1"));
       //query.addCriteria(Criteria.where("name").is("瓜田李下1"));

        List<Map> maps = mongoTemplate.find(query, Map.class, "person");
        System.out.println(maps);
    }
}
