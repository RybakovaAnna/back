package ru.ibs.happynes.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class ProjectCard {

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    private String creatorName;

    private String firm;

    private String finishingDate;

    private String projectStage;

    private Boolean isDocumentRequired = false;

    private Date cardCreateDate;

    private String functionalDirection;

    private String projectArea;

    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private ProjectManagement projectManagement;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private ProjectTeam projectTeam;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private RecruitingCard recruitingCard;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_card_id")
    private List<ProjectType> projectType;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_card_id")
    private List<ProjectTechnologies> projectTechnologies;

}
