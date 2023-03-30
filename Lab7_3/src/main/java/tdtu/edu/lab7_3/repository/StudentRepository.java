package tdtu.edu.lab7_3.repository;

import org.springframework.data.repository.CrudRepository;
import tdtu.edu.lab7_3.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
