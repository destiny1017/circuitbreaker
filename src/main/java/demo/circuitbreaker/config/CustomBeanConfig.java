package demo.circuitbreaker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.format.DateTimeFormatter;

@Configuration
public class CustomBeanConfig {

    @Bean
    public WebClient trafficWebClient() {
        return WebClient.create("http://data.ex.co.kr");
    }

    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

}
