package tdtu.edu.lab7_4.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tdtu.edu.lab7_4.model.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByAgeGreaterThanEqual(Integer age);

    List<Student> findByIeltsScore(Double score);

    List<Student> findByNameContaining(String key);
}
