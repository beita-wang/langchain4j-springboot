package com.cainiao.global;

import com.cainiao.global.service.SeparateChatAssistant;
import com.cainiao.global.service.SeparateChatToolsAssistant;
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
public class SeparateChatToolAssistantTest {
    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Autowired
    private SeparateChatToolsAssistant separateChatToolsAssistant;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void deleteAllData() {
        mongoTemplate.getDb().drop();
    }

    @Test
    public void testSeparateChatAssistant() {
        System.out.println(separateChatAssistant.chat(1, "1+1 和 6878797754242的平方根是多少"));
    }

    @Test
    public void testSeparateChatToolsAssistant() {
        System.out.println(separateChatToolsAssistant.chat(1, "1+1 和 6878797754242的平方根是多少"));
    }

}
