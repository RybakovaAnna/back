package ru.ibs.happynes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProjectManagementDto {

    private String officeLocation;

    private Boolean isTimeChange;

    private Boolean isOffice;

    private String dayStart;

    private String dayEnd;

    private String teamStartDate;

    private String overTime;

    private String description;

    private String tasks;

    private String comment;
}
