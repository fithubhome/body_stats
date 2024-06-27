package com.bodystats.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bodystats.api.model.BodyStats;

import java.util.List;
import java.util.UUID;

public interface BodyStatsRepository extends JpaRepository<BodyStats, UUID> {
    List<BodyStats> findByProfileIdOrderByRegisterDayDesc(UUID profileId);
}
