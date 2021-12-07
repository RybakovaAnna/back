package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.ProjectType;

public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {
}
