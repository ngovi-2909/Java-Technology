package tdtu.edu.lab7_5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.lab7_5.model.Student;
import tdtu.edu.lab7_5.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

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

    @Override
    public Collection<Student> findStudentsWithAgeGreaterThanEqual(int i) {
        return studentRepository.searchByAge(i);
    }

    @Override
    public String countStudentWithIeltsCore(double v) {
        return studentRepository.searchByIeltsScore(v).toString();
    }

    @Override
    public Collection<Student> searchStudentsByName(String ar) {
        return studentRepository.searchByName(ar);
    }
}
