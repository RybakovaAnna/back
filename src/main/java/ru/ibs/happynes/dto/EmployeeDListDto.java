package ru.ibs.happynes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDListDto {

    private String fullName;

    private String phoneNumber;

    private String email;
}