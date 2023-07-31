package demo.circuitbreaker.data;

import demo.circuitbreaker.domain.RoadTraffic;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TrafficResponse {
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

    public TrafficResponse(RoadTraffic roadTraffic) {
        this.exDivCode = roadTraffic.getExDivCode();
        this.exDivName = roadTraffic.getExDivName();
        this.tcsType = roadTraffic.getTcsType();
        this.tcsName = roadTraffic.getTcsName();
        this.tmType = roadTraffic.getTmType();
        this.tmName = roadTraffic.getTmName();
        this.carType = roadTraffic.getCarType();
        this.trafficAmout = roadTraffic.getTrafficAmout();
        this.sumTm = roadTraffic.getSumTm();
        this.createdDateTime = roadTraffic.getCreatedDateTime();
    }
}
