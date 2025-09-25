package com.cainiao.global;

import com.cainiao.global.service.RagAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.Result;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Beita_Wang
 * @Date: 2025/7/18  16:11
 * @Describe:
 */
@SpringBootTest(classes = Main.class)
public class RagTest {

    @Resource
    private RagAssistant ragAssistant;


    @Test
    public void testRag() {
        Result<String> result = ragAssistant.chatRag("帮我列一份ai学习路线，并且是谁建议的？");
        String content = result.content();
        List<Content> sources = result.sources();
        System.out.println(content);
        System.out.println(sources);
    }
}