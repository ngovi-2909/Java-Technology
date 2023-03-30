package tdtu.edu.lab7_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.lab7_6.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
