package ro.fithubhome.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Body {
    private String profileId;
    private int startingWeight;
    private int registerDay;
    private int bmi;
    private int muscleMass;
    private int fatPercentage;
    private int waist;
    private int buttocks;
    private int chest;
    private int leftArm;
    private int rightArm;
    private int leftThigh;
    private int rightThigh;
    private int leftCalf;
    private int rightCalf;

    public String getProfileId() {
        return profileId;
    }
}
