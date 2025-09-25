package com.cainiao.global.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  13:36
 * @Describe: 工具类
 */
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "qwenChatModel", chatMemory = "chatMemory", contentRetriever = "contentRetriever")
public interface RagAssistant {
    Result<String> chatRag(String userMessage);
}
