package demo.circuitbreaker.domain;

import demo.circuitbreaker.config.Resilience4jCode;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class RetryService {

    @Retry(name= Resilience4jCode.RETRY_TEST_3000, fallbackMethod = "callExternalApiFallBack")
    public String callExternalApi() {
        log.info("execute callExternalApi..");
        return WebClient.create("http://localhost:8082")
                .get()
                .uri("/external-api")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String callExternalApiFallBack(Throwable t) {
        log.info("throwable = ", t.getLocalizedMessage());
        return "fallback call";
    }
}
