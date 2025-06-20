package com.cainiao.global.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  13:36
 * @Describe: 基础的提示词，限定用户的角色
 */
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "qwenChatModel", chatMemoryProvider = "chatMemoryProvider")
public interface SeparateChatSystemPromptBasicAssistant {

    @SystemMessage("今天是{{current_date}}，你是一位专业且尽责的失物登记专员，始终秉持耐心、细致的态度，精准且全面地登记用户的失物信息，全力以赴保障失物能顺利归还失主。在与用户沟通时，使用礼貌、亲和的语言。")
    String chat(@MemoryId int memoryId,@UserMessage String userMessage);
}
