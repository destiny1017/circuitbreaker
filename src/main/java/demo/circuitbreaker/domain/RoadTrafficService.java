package demo.circuitbreaker.domain;

import demo.circuitbreaker.config.Resilience4jCode;
import demo.circuitbreaker.data.TrafficAllVo;
import demo.circuitbreaker.data.TrafficResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoadTrafficService {

    private final WebClient webClient;
    private final RoadTrafficRepository roadTrafficRepository;

    @CircuitBreaker(name = Resilience4jCode.CIRCUIT_API_CALL_3000, fallbackMethod = "getTrafficInfoDb")
    public List<TrafficResponse> getTrafficInfo() {
        TrafficAllVo trafficAll = webClient.get()
                .uri("/openapi/trafficapi/trafficAll?key=test&type=json&exDivCode=00&tcsType=1&tmType=1")
                .retrieve()
                .bodyToMono(TrafficAllVo.class)
                .block();
        return trafficAll.getTrafficAll().stream().map(TrafficResponse::new)
                .collect(Collectors.toList());
    }

    public List<TrafficResponse> getTrafficInfoDb() {
        List<RoadTraffic> trafficAll = roadTrafficRepository.findAllByExDivCodeAndTcsTypeOrderByCreateDateTimeDesc("00", "1");
        return trafficAll.stream().map(TrafficResponse::new)
                .collect(Collectors.toList());
    }
}
