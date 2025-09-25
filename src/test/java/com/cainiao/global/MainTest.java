package com.cainiao.global;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
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
                "场景：立于水墨风格的石桥上，背景是朦胧远山与涟漪水波，夕阳余晖洒落。要求现代人，不要动漫");
        System.out.println(generate.content().url().toString());
    }


    @Test
    void test_image_recognize(){
        QwenChatModel chatModel = QwenChatModel.builder()
                .apiKey(System.getenv("AI_KEY"))
                .modelName("qwen2.5-vl-32b-instruct")
                .build();
        UserMessage userMessage = UserMessage.from(
                TextContent.from("这个照片上面描述了什么？"),
                ImageContent.from("https://dashscope-result-wlcb-acdr-1.oss-cn-wulanchabu-acdr-1.aliyuncs.com/1d/9d/20250719/5070f64c/fa2ed31c-7e08-425f-b353-a7ed7846ab42148165117.png?Expires=1752993579&OSSAccessKeyId=LTAI5tKPD3TMqf2Lna1fASuh&Signature=e4YCLn8dwUP7ZqGFTrKGc%2FB6QbY%3D")
        );
        ChatResponse chatResponse = chatModel.chat(userMessage);
        System.out.println(chatResponse.aiMessage().toString());
    }

}
