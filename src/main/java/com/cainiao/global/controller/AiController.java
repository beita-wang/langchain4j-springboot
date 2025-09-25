package com.cainiao.global.controller;

import com.cainiao.global.entity.IntentionOutput;
import com.cainiao.global.entity.LostPropertyOutput;
import com.cainiao.global.entity.LostRegisterEntity;
import com.cainiao.global.service.ChatStreamAssistant;
import com.cainiao.global.store.LostRegisterRepository;
import dev.langchain4j.community.model.dashscope.QwenStreamingChatModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @Author: Beita_Wang
 * @Date: 2025/7/17  13:01
 * @Describe:
 */
@RestController
@RequestMapping("/ai")
@Slf4j
public class AiController {

    @Resource
    private ChatStreamAssistant chatStreamAssistant;

    @Resource
    private LostRegisterRepository lostRegisterRepository;


    @GetMapping("/chat")
    public Flux<String> chat(int memoryId,String message) {
        // 判断用户的意图
        IntentionOutput intention = chatStreamAssistant.getIntention(memoryId, message);
        log.info("ai返回的结果:{}", intention);
        String output = intention.getOutput();
        switch (intention.getIntention()) {
            case 1:
                // 丢失信息登记
                output = registerLost(memoryId, message);
                break;
            case 2:
                // 找到失物登记
                break;
            case 3:
                // 失物查询
                break;
            default:
                // 其他
                return Flux.just(output);
        }
        return Flux.just(output);


//        return chatStreamAssistant.chatStream(memoryId,message)
//                .map(chunk -> ServerSentEvent.<String>builder().data(chunk).build());
    }

    private String registerLost(int userId, String message) {
        LostPropertyOutput lostPropertyOutput = chatStreamAssistant.registerLost(userId, message);
        log.info("lostPropertyOutput:{}", lostPropertyOutput);
        if (lostPropertyOutput.getCompleted()){
            LostRegisterEntity lostRegisterEntity = new LostRegisterEntity();
            BeanUtils.copyProperties(lostPropertyOutput, lostRegisterEntity);
            lostRegisterRepository.save(lostRegisterEntity);
        }
        return lostPropertyOutput.getOutput();
    }
}
