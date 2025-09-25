package com.cainiao.global.tools;

import com.cainiao.global.store.LostRegisterRepository;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Beita_Wang
 * @Date: 2025/7/17  16:09
 * @Describe:
 */
@Component
@Slf4j
public class LostTools {

    @Resource
    private LostRegisterRepository lostRegisterRepository;

//    @Tool("根据物品及物品特征查询物品登记信息")
//    public List<String> queryLostProperty(@P(value = "物品名称和特征") String lostProperty) {
//        log.info("根据物品及物品特征查询物品登记信息,物品名称和特征: {}", lostProperty);
////        List<String> list = contentRetriever.retrieve(new Query(lostProperty))
////                .stream()
////                .map(x -> x.textSegment().text())
////                .toList();
////        lostRegisterRepository.
////        log.info("根据物品及物品特征查询物品登记信息,查询结果: {}", list);
////        return list;
//    }

}
