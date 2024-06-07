package ai.datawise.bot_ai.module.api.application.ports.out;

import ai.datawise.bot_ai.module.api.domain.LlmResponse;

public interface MessageAdapter {
    LlmResponse ask(String prompt);
}
