package com.cainiao.global.service;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  10:34
 * @Describe:
 */
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT,chatModel = "qwenChatModel")
public interface AssistantAnno {
    String chat(String userMsg);
}
