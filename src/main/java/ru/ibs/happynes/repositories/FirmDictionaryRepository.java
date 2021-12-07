package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.FirmDictionary;

public interface FirmDictionaryRepository extends JpaRepository<FirmDictionary, String> {
}
