package com.cainiao.global.entity;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

/**
 * @Author: Beita_Wang
 * @Date: 2025/7/17  15:09
 * @Describe: ai返回的回答映射的实体
 */
@Data
public class IntentionOutput {

    @Description("意图（1：丢失信息登记;2：找到失物登记3：失物查询4：其他）")
    private Integer intention;

    @Description("大模型对用户的输出")
    private String output;

}


