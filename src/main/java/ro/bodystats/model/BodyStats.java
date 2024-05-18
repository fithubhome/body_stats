package ro.bodystats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BodyStats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID profileId;
    private Date registerDay;
    private Double bmi;
    private Double weight;
    private Double muscleMass;
    private Double fatPercentage;
    private Double calf;
    private Double waist;
    private Double chest;
    private Double leftArm;
    private Double rightArm;
    private Double leftTight;
    private Double rightTight;
    private Double leftCalf;
    private Double rightCalf;
}
