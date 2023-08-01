package demo.circuitbreaker.domain;

import demo.circuitbreaker.data.TrafficResponse;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoadTraffic {

    @Id
    private Long id;
    private String exDivCode;
    private String exDivName;
    private String tcsType;
    private String tcsName;
    private String tmType;
    private String tmName;
    private String carType;
    private String trafficAmount;
    private String sumTm;
    private LocalDateTime createdDateTime;

}
