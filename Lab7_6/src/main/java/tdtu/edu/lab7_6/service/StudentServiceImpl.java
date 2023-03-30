package tdtu.edu.lab7_6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tdtu.edu.lab7_6.model.Student;
import tdtu.edu.lab7_6.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Iterable<Student> getAllStudent() {
        return studentRepository.findAll(Sort.by("age").descending().and(Sort.by("ieltsScore")));
    }

    @Override
    public Iterable<Student> getCustomizeStudentList() {
        Pageable sortByAgeIeltsScore =
                PageRequest.of(0, 10, Sort.by("age").descending().and(Sort.by("ieltsScore")));
        Page<Student> studentPage = studentRepository.findAll(sortByAgeIeltsScore);
        return studentPage.getContent().subList(4,7);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
