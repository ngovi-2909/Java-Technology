package tdtu.edu.lab7_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.lab7_2.model.Student;
import tdtu.edu.lab7_2.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl() {
    }

    public Iterable<Student> getAllStudent() {
        return this.studentRepository.findAll();
    }

    public Student getStudent(Long id) throws Exception {
        return (Student)this.studentRepository.findById(id).orElseThrow(() -> {
            return new Exception("Student not found");
        });
    }

    public void deleteStudent(Long id) {
        this.studentRepository.deleteById(id);
    }

    public Student save(Student student) {
        return (Student)this.studentRepository.save(student);
    }
}
