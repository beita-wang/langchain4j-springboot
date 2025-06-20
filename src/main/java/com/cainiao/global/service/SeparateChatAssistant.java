package com.cainiao.global.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  13:36
 * @Describe: 会话隔离
 */
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "qwenChatModel", chatMemoryProvider = "chatMemoryProvider")
public interface SeparateChatAssistant {

    String chat(@MemoryId int memoryId,@UserMessage String userMessage);
}
