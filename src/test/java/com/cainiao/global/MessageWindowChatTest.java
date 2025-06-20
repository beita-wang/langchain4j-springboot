package com.cainiao.global;

import com.cainiao.global.service.Assistant;
import com.cainiao.global.service.MemoryChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  11:17
 * @Describe:
 */
@SpringBootTest(classes = Main.class)
public class MessageWindowChatTest {

    @Autowired
    private QwenChatModel qwenChatModel;

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testMessageWindowChat() {
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        Assistant assistant = AiServices.builder(Assistant.class).chatLanguageModel(qwenChatModel).chatMemory(chatMemory).build();
        String aiMsg = assistant.chat("你好,我是王贝塔");
        System.out.println(aiMsg);
        String aiMsg2 = assistant.chat("我是谁？");
        System.out.println(aiMsg2);
    }


    @Test
    public void testMessageWindowChatConfig() {
        System.out.println(memoryChatAssistant.chat("你好,我是王贝塔"));
        System.out.println(memoryChatAssistant.chat("我是谁"));
    }
}
