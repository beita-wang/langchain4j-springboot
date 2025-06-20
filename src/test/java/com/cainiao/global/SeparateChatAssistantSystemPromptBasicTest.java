package com.cainiao.global;

import com.cainiao.global.service.SeparateChatSystemPromptBasicAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  13:42
 * @Describe: 基础提示词
 */
@SpringBootTest(classes = Main.class)
public class SeparateChatAssistantSystemPromptBasicTest {
    @Autowired
    private SeparateChatSystemPromptBasicAssistant separateChatAssistant;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void deleteAllData() {
        mongoTemplate.getDb().drop();
    }

    @Test
    public void testSeparateChatAssistant() {
        System.out.println(separateChatAssistant.chat(1, "你好,你是谁呀"));
    }

}
