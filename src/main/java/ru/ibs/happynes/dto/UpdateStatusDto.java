package ru.ibs.happynes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateStatusDto {

    private Long id;

    private String status;
}
