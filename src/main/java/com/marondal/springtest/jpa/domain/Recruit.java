package com.marondal.springtest.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="`recruit`")
@Entity
public class Recruit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int companyId;
    private LocalDateTime deadline;
    private String position;
    private String responsibilities;
    private String qualification;
    private String type;
    private String region;
    private int salary;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
