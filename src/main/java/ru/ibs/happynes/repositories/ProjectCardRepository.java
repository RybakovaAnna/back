package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.ProjectCard;

import java.util.Date;
import java.util.List;

public interface ProjectCardRepository extends JpaRepository<ProjectCard, Long> {
    ProjectCard findProjectCardById(Long id);

    List<ProjectCard> findAllByProjectName(String projectName);
    List<ProjectCard> findAllByCreatorName(String creatorName);
    List<ProjectCard> findAllByFirm(String firm);
    List<ProjectCard> findAllByCardCreateDate(Date date);
    List<ProjectCard> findAllByProjectStage(String projectStage);
    List<ProjectCard> findAllByProjectArea(String projectArea);

}
