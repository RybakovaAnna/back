package ru.ibs.happynes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class MainCardDto {

    private Long id;

    private ProjectCardDto projectCardDto;

    private ProjectTeamCardDto projectTeamCardDto;

    private ProjectManagementDto projectManagementDto;

    private RecruitingCardDto recruitingCardDto;

    private List<String> projectTypeDto;

    private List<String> technologies;

}
