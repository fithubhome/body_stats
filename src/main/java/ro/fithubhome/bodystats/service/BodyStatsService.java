package ro.fithubhome.bodystats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fithubhome.bodystats.exception.EntityNotFoundException;
import ro.fithubhome.bodystats.model.BodyStats;
import ro.fithubhome.bodystats.repository.BodyStatsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BodyStatsService {
    private static final Logger logger = LoggerFactory.getLogger(BodyStatsService.class);

    @Autowired
    private BodyStatsRepository bodystatsRepository;

    public void createBodyStats(BodyStats bodystats)  {
        logger.info("Creating BodyStats with profileId: {}", bodystats.getProfileId());
        bodystatsRepository.save(bodystats);
    }

    public List<BodyStats> getAllBodyStats() {
        logger.info("Fetching all BodyStats records");
        return bodystatsRepository.findAll();
    }

    public Optional<BodyStats> getBodyStatsById(UUID id) throws EntityNotFoundException {
        logger.info("Fetching BodyStats for id: {}", id);
        Optional<BodyStats> body = bodystatsRepository.findById(id);
        if (body.isEmpty()) {
            logger.error("BodyStats not found for id: {}", id);
            throw new EntityNotFoundException("BodyStats stats not found for ID: " + id);
        }
        return body;
    }

    public BodyStats updateBodyStats(BodyStats bodystats) throws EntityNotFoundException {
        logger.info("Updating BodyStats with id: {}", bodystats.getId());
        if (!bodystatsRepository.existsById(bodystats.getId())) {
            logger.error("BodyStats not found for id: {}", bodystats.getId());
            throw new EntityNotFoundException("BodyStats stats not found for ID: " + bodystats.getId());
        }
        return bodystatsRepository.save(bodystats);
    }

    public void deleteBodyStatsById(UUID id) throws EntityNotFoundException {
        logger.info("Deleting BodyStats with id: {}", id);
        if (!bodystatsRepository.existsById(id)) {
            logger.error("BodyStats not found for id: {}", id);
            throw new EntityNotFoundException("BodyStats stats not found for ID: " + id);
        }
        bodystatsRepository.deleteById(id);
    }
}
