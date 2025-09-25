package com.cainiao.global.store;

import com.cainiao.global.entity.LostRegisterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.awt.geom.PathIterator;
import java.util.List;

/**
 * @Author: Beita_Wang
 * @Date: 2025/7/17  15:27
 * @Describe:
 */
@Component
public class LostRegisterRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(LostRegisterEntity entity) {
        mongoTemplate.save(entity);
    }

    public List<LostRegisterEntity> findByPhone(String lostProperty) {
        return mongoTemplate.find(new Query(Criteria.where("lostProperty").is(lostProperty)), LostRegisterEntity.class);
    }

}
