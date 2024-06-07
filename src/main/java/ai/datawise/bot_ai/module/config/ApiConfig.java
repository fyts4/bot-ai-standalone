package ai.datawise.bot_ai.module.config;

import ai.datawise.bot_ai.module.config.models.OllamaConfig;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class ApiConfig {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private OllamaConfig ollamaConfig;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public ChatClient chatClient() {
        return ollamaConfig.createChatClient();
    }

    @Bean
    public EmbeddingModel embeddingModel() {
        return ollamaConfig.createEmbeddingModel();
    }

}
