package com.cainiao.global.config;

import com.cainiao.global.store.MongoChatMemoryStore;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.splitter.DocumentByParagraphSplitter;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Author: Beita_Wang
 * @Date: 2025/7/17  14:32
 * @Describe:
 */
@Configuration
public class LangChainConfig {


    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;

    @Resource
    private EmbeddingModel qwenEmbeddingModel;

    @Resource
    private EmbeddingStore<TextSegment> embeddingStore;

    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.withMaxMessages(10);
    }


    @Bean
    public ContentRetriever contentRetriever() {
        //1. 读取文档
        List<Document> documents = FileSystemDocumentLoader.loadDocuments("src/main/resources/file");

        //2. 文档切割：将每个文档按每段进行分割，最大500字符，每次最多重叠100个字符
        DocumentByParagraphSplitter paragraphSplitter = new DocumentByParagraphSplitter(500, 100);

        //3.自定义文档加载器
        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
                .documentSplitter(paragraphSplitter)
                //提高搜索质量，为每个段落添加文档名称
                .textSegmentTransformer(textSegment -> TextSegment.from(
                        textSegment.metadata().getString("file_name") + "\n" + textSegment.text(),
                        textSegment.metadata()
                ))
                //使用指定的向量模型
                .embeddingStore(embeddingStore)
                .embeddingModel(qwenEmbeddingModel)
                .build();

        //4. 加载文档
        ingestor.ingest(documents);

        //5. 自定义内容查询器
        return EmbeddingStoreContentRetriever.builder()
                .embeddingModel(qwenEmbeddingModel)
                .embeddingStore(embeddingStore)
                .maxResults(5) //最多5个检索结果
                .minScore(0.75) //过滤掉分数小于0.75的结果
                .build();
    }


    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        return new ChatMemoryProvider() {

            @Override
            public ChatMemory get(Object memoryId) {
                return MessageWindowChatMemory.builder()
                        .id(memoryId)
                        .maxMessages(10)
                        .chatMemoryStore(mongoChatMemoryStore)
                        //.chatMemoryStore(new InMemoryChatMemoryStore()) //切换读取存储方式
                        .build();
            }
        };
    }
}
