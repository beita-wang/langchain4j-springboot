package com.cainiao.global;

import com.cainiao.global.service.Assistant;
import com.cainiao.global.service.AssistantAnno;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  9:59
 * @Describe: https://docs.langchain4j.dev/tutorials/ai-services/
 */
@SpringBootTest(classes = Main.class)
public class AiServiceTest {

    @Autowired
    private QwenChatModel model;

    @Autowired
    private AssistantAnno assistantAnno;
    @Test
    public void testAiService() {
        Assistant assistant = AiServices.create(Assistant.class, model);
        String aiMsg = assistant.chat("你好");
        System.out.println(aiMsg);
    }


    @Test
    public void testAiServiceByAnno() {
        String aiMsg = assistantAnno.chat("你好");
        System.out.println(aiMsg);
    }

}
