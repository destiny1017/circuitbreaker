package demo.circuitbreaker.domain;

import demo.circuitbreaker.data.TrafficResponse;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoadTraffic {
    private String exDivCode;
    private String exDivName;
    private String tcsType;
    private String tcsName;
    private String tmType;
    private String tmName;
    private String carType;
    private String trafficAmout;
    private String sumTm;
    private LocalDateTime createdDateTime;

}
