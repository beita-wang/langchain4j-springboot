package com.cainiao.global.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/17  13:53
 * @Describe:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("chat_messages")
public class ChatMessages {

    /**
     * 唯一标识，映射到MongoDB的_id字段
     */
    @Id
    private ObjectId messageId;

    /** 聊天记录所属memoryId */
    private String memoryId;

    /** 聊天记录内容json字符串 */
    private String content;
}
