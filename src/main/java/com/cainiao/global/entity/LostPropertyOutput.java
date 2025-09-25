package com.cainiao.global.entity;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

/**
 * @Author: Beita_Wang
 * @Date: 2025/7/19  15:05
 * @Describe: 丢失物品的映射
 */
@Data
public class LostPropertyOutput {

    @Description("大模型对用户的输出")
    private String output;

    @Description("用户姓名")
    private String username;

    @Description("用户手机号")
    private String phone;

    @Description("失物名称")
    private String lostName;

    @Description("失物特征")
    private String lostType;

    @Description("是否完成登记")
    private Boolean completed;

}

