package tdtu.edu.lab7_6.service;

import tdtu.edu.lab7_6.model.Student;

public interface StudentService {
    public Iterable<Student> getAllStudent();
    public Iterable<Student> getCustomizeStudentList();
    public Student save(Student student);
}
