package com.bodystats.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Types;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "bodystats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BodyStats {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;
    @JdbcTypeCode(Types.VARCHAR)
    private UUID profileId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerDay;
    private Double bmi;
    private Double weight;
    private Double muscleMass;
    private Double fatPercentage;
    private Double waist;
    private Double chest;
    private Double leftArm;
    private Double rightArm;
    private Double leftThigh;
    private Double rightThigh;
    private Double leftCalf;
    private Double rightCalf;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
