package ro.bodystats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.bodystats.model.BodyStats;

import java.util.List;
import java.util.UUID;

public interface BodyStatsRepository extends JpaRepository<BodyStats, UUID> {
    List<BodyStats> findByProfileIdOrderByRegisterDayDesc(UUID profileId);
}
