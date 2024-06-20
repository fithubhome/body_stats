package ro.fithubhome.bodystats.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bodystats")
@AllArgsConstructor
@Setter
@Getter
public class Body  {
    @Id
    private Integer id;
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

}

