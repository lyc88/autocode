package com.example.demo;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
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
        //query.addCriteria(Criteria.where("_id").is(0).and("name").is("瓜田李下1"));
       //query.addCriteria(Criteria.where("name").is("瓜田李下1"));
        query.addCriteria(Criteria.where("_id").is(0).orOperator(Criteria.where("name").regex("瓜田李下1"),Criteria.where("name").regex("瓜田李下")));
        /*Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("name").regex("瓜田李下1"),Criteria.where("name").regex("瓜田李下"));
        query.addCriteria(criteria);
        query.addCriteria(Criteria.where("_id").is(0));*/

        List<Map> maps = mongoTemplate.find(query, Map.class, "person");
        System.out.println(maps);

        // 分组 根据 年龄分组 统计 年龄多少人 并且知道是那些人
       // Fields.
        Aggregation aggregation = Aggregation.newAggregation(
                //Aggregation.match(Criteria.where("id").is(0)),
                //Aggregation.project("id"),
                //Aggregation.group(fields),
                //Aggregation.sort(sort),
                //Aggregation.skip(elementsToSkip),
                //Aggregation.limit(maxElements),
                Aggregation.group("age").count().as("count")
                        .addToSet("name").as("name")
                        .first("age").as("age")
        );
        //aggregation.withOptions(Sort.by("age"));
        AggregationResults<Map> ans = mongoTemplate.aggregate(aggregation, "person", Map.class);
        System.out.println("query: " + aggregation + " | groupQuery " + ans.getMappedResults());
    }
}
