package com.cainiao.global;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Beita_Wang
 * @Date: 2025/6/16  18:43
 * @Describe:
 */
@SpringBootTest(classes = Main.class)
public class MainTest {
    @Autowired
    private QwenChatModel qwenChatModel;

    /**
     * 测试链接Qwen大模型
     * https://docs.langchain4j.dev/integrations/language-models/dashscope
     */
    @Test
    public void testQwen() {
        String aiMsg = qwenChatModel.chat("你好");
        System.out.println(aiMsg);
    }


    @Test
    public void testQwenImage() {
        WanxImageModel wanxImageModel = WanxImageModel.builder().modelName("wanx2.1-t2i-turbo").apiKey(System.getenv("AI_KEY")).build();
        Response<Image> generate = wanxImageModel.generate("你好,请帮我生成一张图片，水墨仙子」\n" +
                "造型：淡青色齐胸襦裙，外搭烟粉色薄纱披帛，袖口绣银线云纹；\n" +
                "发型：高耸堕马髻，插一支碧玉步摇与珍珠花钿，鬓边垂落红色流苏；\n" +
                "动作：侧身执团扇掩面轻笑，左手拈一枝盛开的荷花，衣袂随风微扬；\n" +
                "场景：立于水墨风格的石桥上，背景是朦胧远山与涟漪水波，夕阳余晖洒落。");
        System.out.println(generate.content().url().toString());
    }
}
