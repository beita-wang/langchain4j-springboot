package com.cainiao.global;

import com.cainiao.global.service.SeparateChatAssistant;
import com.mongodb.client.MongoClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  13:42
 * @Describe:
 */
@SpringBootTest(classes = Main.class)
public class SeparateChatAssistantTest {
    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void deleteAllData() {
        mongoTemplate.getDb().drop();
    }

    @Test
    public void testSeparateChatAssistant() {
        System.out.println(separateChatAssistant.chat(1, "你好,我是王贝塔"));
        System.out.println(separateChatAssistant.chat(1, "我是谁"));
        System.out.println(separateChatAssistant.chat(2, "我是谁"));
    }

}
