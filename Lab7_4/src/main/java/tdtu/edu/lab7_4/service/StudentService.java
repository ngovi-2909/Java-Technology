package tdtu.edu.lab7_4.service;

import tdtu.edu.lab7_4.model.Student;
import tdtu.edu.lab7_4.repository.StudentRepository;

import java.util.List;

public interface StudentService {
    Iterable<Student> getAllStudent();

    Student getStudent(Long id) throws Exception;

    void deleteStudent(Long id);

    Student save(Student student);

    List<Student> findStudentsWithAgeGreaterThanEqual(int i);

    String countStudentWithIeltsCore(double v);

    List<Student> searchStudentsByName(String ar);
}
