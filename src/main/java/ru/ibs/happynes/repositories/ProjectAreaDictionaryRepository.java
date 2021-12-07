package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.ProjectAreaDictionary;

public interface ProjectAreaDictionaryRepository extends JpaRepository<ProjectAreaDictionary, String> {
}
