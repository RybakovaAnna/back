package ru.ibs.happynes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ProjectTeam {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private Long id;

    private Boolean isProductDevelop;

    private String methodology;

    private String analytics;

    private String developers;

    private String testers;

    private String techWriters;

    private String stakeHoldersCount;

    private String developerRequirements;

    private String analyticsRequirements;

    private String devOps;

    private String designers;

    private Boolean isTeamFormed;

    private String teamCount;
}
