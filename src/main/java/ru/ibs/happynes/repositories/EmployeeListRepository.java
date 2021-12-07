package ru.ibs.happynes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.happynes.entities.Employee;

public interface EmployeeListRepository extends JpaRepository<Employee, Long> {
}
