package demo.circuitbreaker.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoadTrafficRepository extends JpaRepository<RoadTraffic, Long> {

    List<RoadTraffic> findAllByExDivCodeAndTcsTypeOrderByCreatedDateTimeDesc(String exDivCode, String TcsType);
}
