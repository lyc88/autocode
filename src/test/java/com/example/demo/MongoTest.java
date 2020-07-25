
package com.example.demo;


import com.example.demo.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

	@Autowired
	private MongoTemplate mongoTemplate;



	@Test
	public void testSave(){
		//System.out.println(mongoTemplate);
		for(int i=0;i<100;i++){
			Person person=new Person();
			person.setId(i);
			person.setUserName("瓜田李下"+i);
			person.setAge(i%10+16);

			mongoTemplate.save(person);
		}
	}


	@Test
	public void testFind(){
		//Query query = new Query().addCriteria(Criteria.where("id").is(0));

		Query query = new Query().addCriteria(Criteria.where("_id").is(0));
		Person person = mongoTemplate.findOne(query, Person.class);
		System.out.println(person);

	}
}





