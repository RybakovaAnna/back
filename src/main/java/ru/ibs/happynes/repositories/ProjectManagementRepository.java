package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.ProjectManagement;

public interface ProjectManagementRepository extends JpaRepository<ProjectManagement, Long> {
}
