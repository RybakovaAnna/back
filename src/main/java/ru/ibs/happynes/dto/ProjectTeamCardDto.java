package ru.ibs.happynes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectTeamCardDto {

    private Boolean isProductDevelop = false;

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
}
