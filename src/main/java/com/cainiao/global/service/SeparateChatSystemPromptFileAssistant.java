package com.cainiao.global.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  13:36
 * @Describe: 基础的提示词,从文件中读取，限定用户的角色
 */
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "qwenChatModel", chatMemoryProvider = "chatMemoryProvider")
public interface SeparateChatSystemPromptFileAssistant {

    @SystemMessage(fromResource = "system_message.txt")
    String chat(@MemoryId int memoryId,@UserMessage String userMessage);
}
