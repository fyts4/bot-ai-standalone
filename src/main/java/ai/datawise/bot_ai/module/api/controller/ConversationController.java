package ai.datawise.bot_ai.module.api.controller;

import ai.datawise.bot_ai.module.api.domain.CreateConversationRequest;
import ai.datawise.bot_ai.module.api.application.service.ConversationService;
import ai.datawise.bot_ai.module.api.domain.LlmResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/ai")
public class ConversationController {
    private final ConversationService conversationService;

    @PostMapping(path = "/conversation",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createConversation(@RequestBody CreateConversationRequest request) {
        LlmResponse response = conversationService.createNewConversation(request);
        return ResponseEntity.ok(response.getMessage());
    }

}
