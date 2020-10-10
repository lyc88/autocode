package com.example.demo.test.controller;


import com.jctech.framework.boot.canal.annotation.CanalEventPoint;
import com.jctech.framework.boot.canal.annotation.CanalListener;
import com.jctech.framework.boot.canal.entity.Canal;
import com.jctech.framework.boot.canal.enums.EventTypeEnum;

/**
 * @author lyc
 * @date 2020/10/9 19:32
 * @describe
 */
@CanalListener(table = {"goods"})
public class CanalListener111 {

    @CanalEventPoint(eventType=EventTypeEnum.DELETE)
    public void delete(Canal canal){
        System.out.println(canal);
    }


    @CanalEventPoint(eventType=EventTypeEnum.UPDATE_AFTER)
    public void updateAfter(Canal canal){
        System.out.println(canal);
    }


    @CanalEventPoint(eventType=EventTypeEnum.UPDATE_BEFORE)
    public void updateBefore(Canal canal){
        System.out.println(canal);
    }

    @CanalEventPoint(eventType=EventTypeEnum.INSERT)
    public void insert(Canal canal){
        System.out.println(canal);
    }
}
