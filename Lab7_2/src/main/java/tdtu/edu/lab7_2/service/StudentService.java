package tdtu.edu.lab7_2.service;

import tdtu.edu.lab7_2.model.Student;

public interface StudentService {
    Iterable<Student> getAllStudent();

    Student getStudent(Long id) throws Exception;

    void deleteStudent(Long id);

    Student save(Student student);
}
