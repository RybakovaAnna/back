package ru.ibs.happynes.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ImportantTableDto {

    private Long id;

    private String projectName;

    private String creatorName;

    private String projectStage;

    private String functionalDirection;

    private String firm;

    private String status;

    private Date cardCreateDate;
}
