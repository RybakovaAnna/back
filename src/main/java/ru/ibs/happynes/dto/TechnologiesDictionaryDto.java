package ru.ibs.happynes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class TechnologiesDictionaryDto {

    private List<String> technologiesDictionary;
}
