package ro.fithubhome.bodystats.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BodyStatsDTO {
    @NotBlank(message = "Missing data")
    @Size(min = 1, max = 10, message = "Expected between 1 and 10 numbers")
    private String profileId;
}
