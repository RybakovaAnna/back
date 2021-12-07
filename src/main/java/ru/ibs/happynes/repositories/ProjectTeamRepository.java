package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.ProjectTeam;

public interface ProjectTeamRepository extends JpaRepository<ProjectTeam, Long> {
}
