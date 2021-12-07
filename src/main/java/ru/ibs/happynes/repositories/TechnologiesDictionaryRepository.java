package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.TechnologiesDictionary;

public interface TechnologiesDictionaryRepository extends JpaRepository<TechnologiesDictionary, String> {
}
