package demo.circuitbreaker.data;

import demo.circuitbreaker.domain.RoadTraffic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrafficAllVo implements Serializable {
    private String code;
    private String message;
    private Long count;
    private List<RoadTraffic> trafficAll = new ArrayList<>();
}