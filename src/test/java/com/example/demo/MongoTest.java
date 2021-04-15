package com.example.demo;



import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    /*@Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test(){
        Query query = new Query();
        //query.addCriteria(Criteria.where("_id").is(0).and("name").is("瓜田李下1"));
       //query.addCriteria(Criteria.where("name").is("瓜田李下1"));
        query.addCriteria(Criteria.where("_id").is(0).orOperator(Criteria.where("name").regex("瓜田李下1"),Criteria.where("name").regex("瓜田李下")));
        *//*Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("name").regex("瓜田李下1"),Criteria.where("name").regex("瓜田李下"));
        query.addCriteria(criteria);
        query.addCriteria(Criteria.where("_id").is(0));*//*

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

    @Test
    public void testMap(){
        Map map = new HashMap();
        map.put("aa","bb");
        map.put("aa","cc");

        System.out.println(map.get("aa"));

    }


    @Test
    public void test01() throws ParseException {
        JSONArray jsonArray = JSON.parseArray("[{\"beginTime\":\"16:34\",\"endTime\":\"20:34\",\"needNum\":\"1\",\"timeSalaryRule\":\"10\",\"id\":\"\",\"groupId\":\"\"}]");
        List<Map> maps = jsonArray.toJavaList(Map.class);
        //totalTimes(maps,1.0);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Long beginTime = format.parse("16:34").getTime();
        Long endTime = format.parse("20:34").getTime();
        System.out.println((endTime-beginTime)/1000/3600);
    }


    private long totalTimes(List<Map> groupList, double time) throws ParseException {
        long total = 0;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        ArrayList<Long> single = new ArrayList<>();
        for (Map map : groupList) {
            Long beginTime = format.parse("16:34").getTime();
            Long endTime = format.parse("20:34").getTime();
            total += endTime - beginTime;
            single.add(endTime - beginTime);
        }
        Object[] temp = single.toArray();
        Arrays.sort(temp);
        if(time  * 1000 * 3600 < (long)temp[0]) {
            throw new RuntimeException("");
        }
        return total;
    }*/
}
