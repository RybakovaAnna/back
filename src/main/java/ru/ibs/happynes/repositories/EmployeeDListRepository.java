package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.EmployeeD;

public interface EmployeeDListRepository extends JpaRepository<EmployeeD, Long> {
}
