package ro.fithubhome.bodystats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fithubhome.bodystats.model.BodyStats;

import java.util.UUID;

public interface BodyStatsRepository extends JpaRepository<BodyStats, UUID> {
    boolean existsById(UUID id);
}
