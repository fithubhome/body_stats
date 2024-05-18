package ro.bodystats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.bodystats.model.BodyStats;

import java.util.UUID;

public interface BodyStatsRepository extends JpaRepository<BodyStats, UUID> {
}
