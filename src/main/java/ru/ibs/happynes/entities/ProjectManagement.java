package ru.ibs.happynes.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class ProjectManagement {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private Long id;

    private String officeLocation;

    private Boolean isOffice;

    private Boolean isTimeChange = false;

    private String dayStart;

    private String dayEnd;

    private String teamStartDate;

    private String overTime;

    private String description;

    private String tasks;

}
