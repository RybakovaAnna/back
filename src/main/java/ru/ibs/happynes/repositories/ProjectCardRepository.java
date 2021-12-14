package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.ProjectCard;

public interface ProjectCardRepository extends JpaRepository<ProjectCard, Long> {
    ProjectCard findProjectCardById(Long id);

}
