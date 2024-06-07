package ai.datawise.bot_ai.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class BotAiStandaloneApplication {
	public static void main(String[] args) {
		SpringApplication.run(BotAiStandaloneApplication.class, args);
	}

}
