/*
package ro.fithubhome.bodystats.model.dto;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.*;

import javax.validation.constraints.NotNull;



@Entity
@Table(name = "bodystats")
public class BodyStatsDTO {
    @NotBlank(message = "Missing data")
    @Size(min = 1, max = 10, message = "Expected between 1 and 10 numbers")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
*/
/*    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;*//*


    @NotNull
    @Column(name = "starting_weight")
    private int startingWeight;
    @NotNull
    @Column(name = "register_day")
    private int registerDay;
    @NotNull
    @Column(name = "bmi")
    private int bmi;
    @NotNull
    @Column(name = "muscle_mass")
    private int muscleMass;
    @NotNull
    @Column(name = "fat_percentage")
    private int fatPercentage;
    @NotNull
    @Column(name = "waist")
    private int waist;
    @NotNull
    @Column(name = "buttocks")
    private int buttocks;
    @NotNull
    @Column(name = "chest")
    private int chest;
    @NotNull
    @Column(name = "left_arm")
    private int leftArm;
    @NotNull
    @Column(name = "right_arm")
    private int rightArm;
    @NotNull
    @Column(name = "left_thigh")
    private int leftThigh;
    @NotNull
    @Column(name = "right_thigh")
    private int rightThigh;
    @NotNull
    @Column(name = "left_calf")
    private int leftCalf;
    @NotNull
    @Column(name = "right_calf")
    private int rightCalf;

}
*/
