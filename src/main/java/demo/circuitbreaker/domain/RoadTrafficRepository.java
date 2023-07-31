package demo.circuitbreaker.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoadTrafficRepository extends JpaRepository<RoadTraffic, Long> {

    List<RoadTraffic> findAllByExDivCodeAndTcsTypeOrderByCreateDateTimeDesc(
            @Param("exDivCode") String exDivCode,
            @Param("TcsType") String TcsType
    );
}
