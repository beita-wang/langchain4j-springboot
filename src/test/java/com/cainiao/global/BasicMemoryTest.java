package com.cainiao.global;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  11:09
 * @Describe:
 */
@SpringBootTest(classes = Main.class)
public class BasicMemoryTest {

    @Autowired
    private QwenChatModel qwenChatModel;

    /**
     * 演示无记忆
     */
    @Test
    public void testErrorBasicMemory() {
        UserMessage userMessage = UserMessage.userMessage("你好，我是王贝塔");
        ChatResponse chat = qwenChatModel.chat(userMessage);
        AiMessage aiMessage = chat.aiMessage();

        System.out.println(aiMessage.text());


        UserMessage userMessage2 = UserMessage.userMessage("我是谁？");
        ChatResponse chat2 = qwenChatModel.chat(userMessage2);
        AiMessage aiMessage2 = chat2.aiMessage();

        System.out.println(aiMessage2.text());
    }


    /**
     * 演示有记忆，基础
     */
    @Test
    public void testBasicMemory() {
        UserMessage userMessage = UserMessage.userMessage("你好，我是王贝塔");
        ChatResponse chat = qwenChatModel.chat(userMessage);
        AiMessage aiMessage = chat.aiMessage();

        System.out.println(aiMessage.text());


        UserMessage userMessage2 = UserMessage.userMessage("我是谁？");
        ChatResponse chat2 = qwenChatModel.chat(List.of(userMessage,aiMessage,userMessage2));
        AiMessage aiMessage2 = chat2.aiMessage();

        System.out.println(aiMessage2.text());
    }
}
