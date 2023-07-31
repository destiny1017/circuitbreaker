package demo.circuitbreaker.controller;

import demo.circuitbreaker.data.TrafficResponse;
import demo.circuitbreaker.domain.RoadTraffic;
import demo.circuitbreaker.domain.RoadTrafficService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoadTrafficController {

    private final RoadTrafficService roadTrafficService;

    @GetMapping("/traffics")
    public List<TrafficResponse> getTrafficInfo() {
        return roadTrafficService.getTrafficInfo();
    }
}
