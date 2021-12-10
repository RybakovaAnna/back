package ru.ibs.happynes.services.intefaces;

import ru.ibs.happynes.dto.MainCardDto;
import ru.ibs.happynes.entities.ProjectCard;

import java.util.List;

public interface ProjectCardService {
    void deleteTable(Long id);
    void updateTable(MainCardDto dto);
    Long createTable(MainCardDto dto);
    List<ProjectCard> findAll();
    List<MainCardDto> findTable(Long id);

    List<String> findTechnologiesDictionary();

    List<String> findProjectAreaDictionary();

    List<String> findFirmDictionary();
}
