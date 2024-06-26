package ro.fithubhome.bodystats.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "bodystats")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Body  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Missing data")
    @Size(min = 1, max = 10, message = "Expected between 1 and 10 numbers")
    private Integer id;

    private UUID profileId;
    @NotNull
    @Column(name = "starting_weight", nullable = false)
    private int startingWeight;

    @NotNull
    @Column(name = "register_day", nullable = false)
    private int registerDay;

    @NotNull
    @Column(name = "bmi", nullable = false)
    private int bmi;

    @NotNull
    @Column(name = "muscle_mass", nullable = false)
    private int muscleMass;

    @NotNull
    @Column(name = "fat_percentage", nullable = false)
    private int fatPercentage;

    @NotNull
    @Column(name = "waist", nullable = false)
    private int waist;

    @NotNull
    @Column(name = "buttocks", nullable = false)
    private int buttocks;

    @NotNull
    @Column(name = "chest", nullable = false)
    private int chest;

    @NotNull
    @Column(name = "left_arm", nullable = false)
    private int leftArm;

    @NotNull
    @Column(name = "right_arm", nullable = false)
    private int rightArm;

    @NotNull
    @Column(name = "left_thigh", nullable = false)
    private int leftThigh;

    @NotNull
    @Column(name = "right_thigh", nullable = false)
    private int rightThigh;

    @NotNull
    @Column(name = "left_calf", nullable = false)
    private int leftCalf;

    @NotNull
    @Column(name = "right_calf", nullable = false)
    private int rightCalf;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

}

/*
@Entity
@Table(name = "bodystats")
public class BodyStatsDTO {
    @NotBlank(message = "Missing data")
    @Size(min = 1, max = 10, message = "Expected between 1 and 10 numbers")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
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

}*/
