package com.example.demo.test.entity;
import java.util.Date;
import com.example.demo.test.entity.User;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * Created by lyc on 2021/4/20
 */
@Data
public class TestUser {

    private User user;

    private String age;


    public static void main(String[] args) {
        TestUser testUser = new TestUser();
        User user1 = new User();
        user1.setId(0);
        user1.setName("aaaa");
        user1.setAge(0);
        user1.setCreateTime(new Date());


        testUser.setUser(user1);
        testUser.setAge("12");

        TestUser user = new TestUser();

        BeanUtils.copyProperties(testUser,user);
        user1.setName("123");

        System.out.println(user);
    }
}
