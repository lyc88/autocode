package com.example.demo.racketmq.consumer;

import com.alibaba.fastjson.JSON;

/**
 * @author lyc
 * @date 2020/10/26 16:24
 * @describe
 */
public class Test {

    public static void main(String[] args) {
        Object o = null;
        String s = JSON.toJSONString(o);
        System.out.println(s);
        int test = test(o);
        System.out.println(test);
       // System.out.println(o.getClass());

    }

    private static int test(Object o){
        try {
            System.out.println(o.getClass());
            return 1;
        }catch (Exception e){
            return 2;
        }
    }
}
