package ai.datawise.bot_ai.module.api.adapters.out;

import ai.datawise.bot_ai.module.api.application.ports.out.MessageAdapter;
import ai.datawise.bot_ai.module.api.domain.LlmResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class LlmMessageAdapter implements MessageAdapter {

    private final ChatClient chatClient;

    @Override
    public LlmResponse ask(String question) {
        return new LlmResponse(chatClient.prompt().user(question).call().content());
    }
}
