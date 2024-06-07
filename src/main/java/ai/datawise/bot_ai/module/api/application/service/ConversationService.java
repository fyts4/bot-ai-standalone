package ai.datawise.bot_ai.module.api.application.service;

import ai.datawise.bot_ai.module.api.application.ports.out.MessageAdapter;
import ai.datawise.bot_ai.module.api.domain.CreateConversationRequest;
import ai.datawise.bot_ai.module.api.domain.LlmResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConversationService {
    private final MessageAdapter messageAdapter;

    public LlmResponse createNewConversation(CreateConversationRequest request) {
        log.info("Received message to start conversation : {}", request.getMessage());
        return messageAdapter.ask(request.getMessage());
    }

}
