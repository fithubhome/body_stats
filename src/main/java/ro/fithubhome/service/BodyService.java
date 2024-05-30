package ro.fithubhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fithubhome.exception.EntityAlreadyExistsException;
import ro.fithubhome.exception.EntityNotFoundException;
import ro.fithubhome.model.Body;
import ro.fithubhome.repository.BodyRepository;

import java.util.List;

@Service
public class BodyService {
    @Autowired
    private BodyRepository bodyRepository;

    public Body createBodyStats(Body body) throws EntityAlreadyExistsException {
        return bodyRepository.createBodyStats(body);
    }
    public Body requestBodyStats(String data) throws EntityNotFoundException {
        return bodyRepository.requestBodyStats(data);
    }

    public List<Body> requestsBodyStats() {
        return bodyRepository.requestsBodyStats();
    }


   public Body updateBodyStats(Body body) throws EntityNotFoundException {
        return bodyRepository.updateBodyStats(body);
    }
    public Body deleteBodyStats(String data) throws EntityNotFoundException {
        return bodyRepository.deleteBodyStats(data);
    }

}
