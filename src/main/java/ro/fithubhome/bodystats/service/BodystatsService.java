package ro.fithubhome.bodystats.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fithubhome.bodystats.exception.EntityNotFoundException;
import ro.fithubhome.bodystats.model.Bodystats;
import ro.fithubhome.bodystats.repository.BodystatsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BodystatsService {
    @Autowired
    private BodystatsRepository bodystatsRepository;

    public void createBodyStats(Bodystats bodystats)  {
        bodystatsRepository.save(bodystats);
    }

    public List<Bodystats> getAllBodyStats() {
        return bodystatsRepository.findAll();
    }

    public Optional<Bodystats> getBodyStatsById(UUID id) throws EntityNotFoundException {
        Optional<Bodystats> body = bodystatsRepository.findById(id);
        if (body.isEmpty()) {
            throw new EntityNotFoundException("Bodystats stats not found for ID: " + id);
        }
        return body;
    }

    public Bodystats updateBodyStats(Bodystats bodystats) throws EntityNotFoundException {
        if (!bodystatsRepository.existsById(bodystats.getId())) {
            throw new EntityNotFoundException("Bodystats stats not found for ID: " + bodystats.getId());
        }
        return bodystatsRepository.save(bodystats);
    }

    public void deleteBodyStatsById(UUID id) throws EntityNotFoundException {
        if (!bodystatsRepository.existsById(id)) {
            throw new EntityNotFoundException("Bodystats stats not found for ID: " + id);
        }
        bodystatsRepository.deleteById(id);
    }

}
