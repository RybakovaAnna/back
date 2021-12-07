package ru.ibs.happynes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class FilterSearchDto {

    private String projectStage;

    private String firm;

    private String creatorName;

    private Date dateBefore;

    private Date dateAfter;

}
