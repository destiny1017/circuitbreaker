package demo.circuitbreaker.controller;

import demo.circuitbreaker.domain.CircuitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CircuitController {

    private final CircuitService circuitService;

    @GetMapping("/circuit-call")
    public String circuit() {
        return circuitService.callExternalApi();
    }

    @GetMapping("/circuit-long-call")
    public String longCircuit() {
        return circuitService.callLongLatencyExternalApi();
    }
}
