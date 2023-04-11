package tdtu.edu.lab8_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.lab8_2.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
