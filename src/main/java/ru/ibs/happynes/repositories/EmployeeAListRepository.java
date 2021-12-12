package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.EmployeeA;

public interface EmployeeAListRepository extends JpaRepository<EmployeeA, Long> {
}
