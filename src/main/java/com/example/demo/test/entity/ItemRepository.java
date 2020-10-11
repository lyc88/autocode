package com.example.demo.test.entity;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 定义特定于域类的存储库接口。接口必须扩展Repository并键入域类和ID类型
 */
@Component
public interface ItemRepository extends ElasticsearchRepository<Item, Long> {
    /**
     * 根据 title 来检索
     * @param title
     * @return
     */
    List<Item> findByTitleLike(String title);

    /**
     * 根据 价格 区间检索
     * @param lower
     * @param upper
     * @return
     */
    List<Item> findByPriceBetween(Double lower, Double upper);




}
