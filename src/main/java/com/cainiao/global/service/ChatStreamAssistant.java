package com.cainiao.global.service;

import com.cainiao.global.entity.IntentionOutput;
import com.cainiao.global.entity.LostPropertyOutput;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  13:36
 * @Describe: 工具类
 */
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT
        , chatModel = "qwenChatModel"
        , chatMemory = "chatMemory"
        , contentRetriever = "contentRetriever"
        , chatMemoryProvider = "chatMemoryProvider"
        , streamingChatModel = "qwenStreamingChatModel"
)
@SystemMessage(fromResource = "system_message.txt")
public interface ChatStreamAssistant {

    /**
     * 和ai对话,获取用户意图
     * @param memoryId
     * @param userMessage
     * @return
     */
    IntentionOutput getIntention(@MemoryId int memoryId, @UserMessage String userMessage);


    /**
     * 注册失物信息
     */
    LostPropertyOutput registerLost(@MemoryId int memoryId, @UserMessage String message);
}
