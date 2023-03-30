package tdtu.edu.lab7_5.service;

import tdtu.edu.lab7_5.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    Iterable<Student> getAllStudent();

    Student getStudent(Long id) throws Exception;

    void deleteStudent(Long id);

    Student save(Student student);

    Collection<Student> findStudentsWithAgeGreaterThanEqual(int i);

    String countStudentWithIeltsCore(double v);

    Collection<Student> searchStudentsByName(String ar);
}
