package ru.otus.flightsearch.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@ConfigurationProperties(prefix = "bot")
@PropertySource("application.yml")
public class BotConfig {
    String name;
    String token;
}
