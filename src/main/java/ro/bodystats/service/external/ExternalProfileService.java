package ro.bodystats.service.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import ro.bodystats.dto.ProfileDTO;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ExternalProfileService {
    private static final Logger logger = LoggerFactory.getLogger(ExternalProfileService.class);
    @Autowired
    private RestTemplate restTemplate;

    public ProfileDTO getProfileById(UUID profileId) {
        String url = "http://localhost:8080/profile/" + profileId;
        logger.info("Fetching profile from URL: {}", url);
        try {
            return restTemplate.getForObject(url, ProfileDTO.class);
        } catch (HttpClientErrorException e) {
            logger.error("Error fetching profile from URL: {}", url, e);
            throw e;
        }
    }
}
