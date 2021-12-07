package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.ProjectTechnologies;

public interface ProjectTechnologiesRepository extends JpaRepository<ProjectTechnologies, Long> {
}
