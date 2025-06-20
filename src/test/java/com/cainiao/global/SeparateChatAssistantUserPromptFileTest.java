package com.cainiao.global;

import com.cainiao.global.service.SeparateChatSystemPromptFileAssistant;
import com.cainiao.global.service.SeparateChatUserPromptFileAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  13:42
 * @Describe: 用户提示词-读取文件
 */
@SpringBootTest(classes = Main.class)
public class SeparateChatAssistantUserPromptFileTest {
    @Autowired
    private SeparateChatUserPromptFileAssistant separateChatAssistant;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void deleteAllData() {
        mongoTemplate.getDb().drop();
    }

    @Test
    public void testSeparateChatAssistant() {
        System.out.println(separateChatAssistant.chat(1, "我是谁，我多大","王贝塔", 18));
    }

}
