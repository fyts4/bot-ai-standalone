package ai.datawise.bot_ai.module.config.models;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OllamaConfig {
    private final BotAiConfig config;
    private OllamaApi ollamaApi;

    public ChatClient createChatClient() {
        OllamaOptions ollamaOptions = new OllamaOptions()
                .withModel(config.getModel());
        OllamaChatModel chatModel = new OllamaChatModel(getOllamaApi(), ollamaOptions);
        return ChatClient.create(chatModel);
    }

    public EmbeddingModel createEmbeddingModel() {
        return new OllamaEmbeddingModel(getOllamaApi());
    }

    private OllamaApi getOllamaApi() {
        if (this.ollamaApi == null) ollamaApi = new OllamaApi(config.getBaseUrl());
        return this.ollamaApi;
    }
}
