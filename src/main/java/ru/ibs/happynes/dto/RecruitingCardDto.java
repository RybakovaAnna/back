package ru.ibs.happynes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecruitingCardDto {

    private String fullName;

    private String phoneNumber;

    private String email;

    private List<EmployeeAListDto> employeeAListDtoList;

    private List<EmployeeDListDto> employeeDListDtoList;
}
