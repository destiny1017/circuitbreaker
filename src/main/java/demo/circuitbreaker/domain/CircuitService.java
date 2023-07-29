package demo.circuitbreaker.domain;

import demo.circuitbreaker.config.Resilience4jCode;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class CircuitService {

    @CircuitBreaker(name = Resilience4jCode.CIRCUIT_TEST_70000, fallbackMethod = "callExternalApiFallBack")
    public String callExternalApi() {
        log.info("execute CircuitService.callExternalApi()..");
        return WebClient.create("http://localhost:8082")
                .get()
                .uri("/external-api")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @CircuitBreaker(name = Resilience4jCode.CIRCUIT_API_CALL_3000, fallbackMethod = "callExternalApiFallBack")
    public String callLongLatencyExternalApi() {
        log.info("execute CircuitService.callLongLatencyExternalApi()..");
        return WebClient.create("http://localhost:8082")
                .get()
                .uri("/long-external-api")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String callExternalApiFallBack(Throwable t) {
        log.info("throwable = ", t.getLocalizedMessage());
        return "circuit fallback call";
    }
}
