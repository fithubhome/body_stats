package ro.fithubhome.bodystats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fithubhome.bodystats.model.Bodystats;

import java.util.UUID;


    public interface BodystatsRepository extends JpaRepository<Bodystats, UUID> {
        boolean existsById(UUID id);
    }
