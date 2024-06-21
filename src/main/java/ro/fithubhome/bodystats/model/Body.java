package ro.fithubhome.bodystats.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "bodystats")
@AllArgsConstructor
@Setter
@Getter
public class Body  {
    @Id
    private Integer id;

    private UUID profileId;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

}

