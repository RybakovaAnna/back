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

    private String firm;

    private String projectArea;

    private String status;

    private String projectStage;

    private Date cardCreateDate;
}
