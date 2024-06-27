package ro.fithubhome.bodystats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fithubhome.bodystats.model.Body;

    @Repository
    public interface BodyRepository extends JpaRepository<Body, Integer> {

}
