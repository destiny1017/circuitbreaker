package demo.circuitbreaker.domain;

import demo.circuitbreaker.config.Resilience4jCode;
import demo.circuitbreaker.data.TrafficAllVo;
import demo.circuitbreaker.data.TrafficResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoadTrafficService {

    private final WebClient webClient;
    private final RoadTrafficRepository roadTrafficRepository;

    @CircuitBreaker(name = Resilience4jCode.CIRCUIT_API_CALL_300, fallbackMethod = "getTrafficInfoDb")
    public List<TrafficResponse> getTrafficInfo() {
        log.info("getTrafficInfo()");
        TrafficAllVo trafficAll = webClient.get()
                .uri("/getRoadTraffic")
                .retrieve()
                .bodyToMono(TrafficAllVo.class)
                .block();
        return trafficAll.getTrafficAll().stream().map(TrafficResponse::new)
                .collect(Collectors.toList());
    }

    public List<TrafficResponse> getTrafficInfoDb(Throwable t) {
        t.printStackTrace();
        log.info("getTrafficInfoDb()");
        List<RoadTraffic> trafficAll = roadTrafficRepository.findAllByExDivCodeAndTcsTypeOrderByCreatedDateTimeDesc("00", "1");
        return trafficAll.stream().map(TrafficResponse::new)
                .collect(Collectors.toList());
    }
}
