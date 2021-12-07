package ru.ibs.happynes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProjectCardDto {

    private String projectName;

    private String creatorName;

    private String firm;

    private String finishingDate;

    private String projectStage;

    private Boolean isDocumentRequired = false;

    private String functionalDirection;

    private String projectArea;

    private Date cardCreateDate;

    private String status;
}
