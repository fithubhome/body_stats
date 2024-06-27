package ro.fithubhome.bodystats.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "bodystats")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Body  {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @JdbcTypeCode(Types.VARCHAR)

    private UUID id;
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