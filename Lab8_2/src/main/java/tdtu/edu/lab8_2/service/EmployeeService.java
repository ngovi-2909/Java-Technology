package tdtu.edu.lab8_2.service;

import org.springframework.data.domain.Page;
import tdtu.edu.lab8_2.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    void removeEmployeeById(long id);
    Optional<Employee> getEmployeeById(long id);
    Page<Employee> findPage(int page, int pageSize);
}
