package ru.ibs.happynes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecruitingCardDto {

    private String fullName;

    private String contacts;

    private List<EmployeeListDto> employeeListDtoList;
}
