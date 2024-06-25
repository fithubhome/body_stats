package ro.fithubhome.bodystats.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fithubhome.bodystats.exception.EntityAlreadyExistsException;
import ro.fithubhome.bodystats.model.Body;
import ro.fithubhome.bodystats.repository.BodyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BodyService {
    @Autowired
    private BodyRepository bodyRepository;

    public Body createBodyStats(Body body) throws EntityAlreadyExistsException {
        return bodyRepository.save(body);
    }

    public List<Body> getAllBodyStats() {
        return bodyRepository.findAll();
    }
/*
   public Body requestBodyStats(String data) throws EntityNotFoundException {
       return bodyRepository.requestBodyStats(data);
   }
*/
    public Optional<Body> getBodyStatsById(Integer id) throws EntityNotFoundException {
        return bodyRepository.findById(id);
    }
/*
    public List<Body> requestsBodyStats() {
        return bodyRepository.requestsBodyStats();
    }
*/
    public Body updateBodyStats(Body body) throws EntityNotFoundException {
        return bodyRepository.save(body);
    }
/*
   public Body updateBodyStats(Body body) throws EntityNotFoundException {
        return bodyRepository.updateBodyStats(body);
    }
*/

    public Body deleteBodyStatsById(Integer id) throws EntityNotFoundException {
        bodyRepository.deleteById(id);
        return null;
    }
/*
    public Body deleteBodyStats(String data) throws EntityNotFoundException {
        return bodyRepository.deleteBodyStats(data);
    }
*/
}
