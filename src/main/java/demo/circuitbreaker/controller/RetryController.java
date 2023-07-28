package demo.circuitbreaker.controller;

import demo.circuitbreaker.domain.RetryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RetryController {

    private final RetryService retryService;

    @GetMapping("/retry-call")
    public String retryCall() {
        return retryService.callExternalApi();
    }
}
