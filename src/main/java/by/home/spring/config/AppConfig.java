package by.home.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataConfig.class, WebConfig.class})
public class AppConfig {
}
