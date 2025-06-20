package com.cainiao.global;

import com.cainiao.global.service.SeparateChatSystemPromptFileAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  13:42
 * @Describe: 系统提示词-读取文件
 */
@SpringBootTest(classes = Main.class)
public class SeparateChatAssistantSystemPromptFileTest {
    @Autowired
    private SeparateChatSystemPromptFileAssistant separateChatAssistant;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void deleteAllData() {
        mongoTemplate.getDb().drop();
    }

    @Test
    public void testSeparateChatAssistant() {
        System.out.println(separateChatAssistant.chat(1, "你好,你是谁呀"));
        System.out.println(separateChatAssistant.chat(1, "你可以给我推荐一个好用的电脑吗"));
        System.out.println(separateChatAssistant.chat(1, "我电脑丢了"));
    }

}
