package ro.fithubhome.bodystats.service;

//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fithubhome.bodystats.exception.EntityAlreadyExistsException;
import ro.fithubhome.bodystats.exception.EntityNotFoundException;
import ro.fithubhome.bodystats.model.Body;
import ro.fithubhome.bodystats.repository.BodyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BodyService {
    @Autowired
    private BodyRepository bodyRepository;

    @Transactional
    public Body createBodyStats(Body body) throws EntityAlreadyExistsException {
        if (bodyRepository.existsById(body.getId())) {
            throw new EntityAlreadyExistsException("Body stats with this ID already exists.");
        }
        return bodyRepository.save(body);
    }
    @Transactional(readOnly = true)

    public List<Body> getAllBodyStats() {

        return bodyRepository.findAll();
    }

    @Transactional(readOnly = true)

    public Optional<Body> getBodyStatsById(Integer id) throws EntityNotFoundException {
        Optional<Body> body = bodyRepository.findById(id);
        if (body.isEmpty()) {
            throw new EntityNotFoundException("Body stats not found for ID: " + id);
        }
        return body;
    }

    @Transactional

    public Body updateBodyStats(Body body) throws EntityNotFoundException {
        if (!bodyRepository.existsById(body.getId())) {
            throw new EntityNotFoundException("Body stats not found for ID: " + body.getId());
        }
        return bodyRepository.save(body);
    }

@Transactional

    public Body deleteBodyStatsById(Integer id) throws EntityNotFoundException {
        if (!bodyRepository.existsById(id)) {
            throw new EntityNotFoundException("Body stats not found for ID: " + id);
        }
        bodyRepository.deleteById(id);
        return null;
    }
/*
    public Body deleteBodyStats(String data) throws EntityNotFoundException {
        return bodyRepository.deleteBodyStats(data);
    }
*/
}
