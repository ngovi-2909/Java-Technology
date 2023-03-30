package tdtu.edu.lab7_5.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tdtu.edu.lab7_5.model.Student;

import java.util.Collection;

public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    public Collection<Student> searchByAge(@Param("age") Integer age);
    @Query("SELECT s FROM Student s WHERE s.ieltsScore = :score")
    public Collection<Student> searchByIeltsScore(@Param("score") Double score);
    @Query("SELECT s FROM Student s WHERE s.name like %:key%")
    public Collection<Student> searchByName(@Param("key") String key);
}
