package ro.fithubhome.repository;

import org.springframework.stereotype.Repository;
import ro.fithubhome.exception.EntityAlreadyExistsException;
import ro.fithubhome.exception.EntityNotFoundException;
import ro.fithubhome.model.Body;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BodyRepository {
    private final List<Body> bodyStatsDatabase = new ArrayList<>() {{
        add(new Body("1", 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 14, 15));
        add(new Body("b", 20, 30, 40, 50, 60, 70, 80, 90, 100, 101, 102, 103, 104, 105));
    }};

    public Body createBodyStats(Body body) throws EntityAlreadyExistsException {
        Optional<Body> existingWeather = bodyStatsDatabase
                .stream()
                .filter(dbBodyStats -> dbBodyStats.getProfileId().equals(body.getProfileId()))
                .findFirst();
        if (existingWeather.isPresent()) {
            throw new EntityAlreadyExistsException(Body.class.getSimpleName());
        }
        bodyStatsDatabase.add(body);
        return body;

    }

    public Body requestBodyStats(String data) throws EntityNotFoundException {
        Optional<Body> existingBodyStats = bodyStatsDatabase
                .stream()
                .filter(dbBodyStats -> dbBodyStats.getProfileId().equals(data))
                .findFirst();
        if (existingBodyStats.isEmpty()) {
            throw new EntityNotFoundException(Body.class.getSimpleName());
        }
        return existingBodyStats.get();
    }
    public List<Body> requestsBodyStats() {
        return bodyStatsDatabase;
    }


    //UPDATE
    public Body updateBodyStats(Body body) throws EntityNotFoundException {
        Body bodyToUpdate = requestBodyStats(body.getProfileId());
        bodyStatsDatabase.remove(bodyToUpdate);
        bodyStatsDatabase.add(body);

        return body;
    }

    //DELETE
    public Body deleteBodyStats(String data) throws EntityNotFoundException {
        Body bodyToDelete = requestBodyStats(data);
        bodyStatsDatabase.remove(bodyToDelete);

        return bodyToDelete;
    }

}