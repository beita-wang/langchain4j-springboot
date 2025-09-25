package com.cainiao.global.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @Author: Beita_Wang
 * @Date: 2025/7/17  15:02
 * @Describe: 登记物品实体
 */
@Data
public class LostRegisterEntity {
    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户手机号
     */
    @Id
    private String phone;

    /**
     * 失物名称
     */
    private String lostName;

    /**
     * 失物特征
     */
    private String lostType;
}
