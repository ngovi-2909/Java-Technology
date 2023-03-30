package tdtu.edu.lab7_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tdtu.edu.lab7_6.model.Student;
import tdtu.edu.lab7_6.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class Lab76Application implements CommandLineRunner {
    @Autowired
    StudentServiceImpl studentService;

    public static void main(String[] args) {
        SpringApplication.run(Lab76Application.class, args);
    }
    private void showStudents() {
        List<Student> list = (List)this.studentService.getAllStudent();
        Iterator var2 = list.iterator();

        for(Student student: list)
        {
            System.out.println(student.toString());
        }

    }

    private void showStudentList(Collection<Student> list) {
        for(Student student: list)
        {
            System.out.println(student.toString());
        }

    }


    @Override
    public void run(String... args) throws Exception {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1L, "John", 18, "john@gmail.com", 6.5));
        studentList.add(new Student(2L, "Jack", 19, "jack@gmail.com", 7.0));
        studentList.add(new Student(3L, "Marry", 20, "marry@gmail.com", 7.5));
        studentList.add(new Student(4L, "Terry", 21, "terry@gmail.com", 8.5));
        studentList.add(new Student(5L, "Nick", 20, "nick@gmail.com", 8.0));
        studentList.add(new Student(6L, "Jonas", 18, "jonas@gmail.com", 6.0));
        studentList.add(new Student(7L, "Taylor", 19, "taylor@gmail.com", 7.0));
        studentList.add(new Student(8L, "Adam", 20, "adam@gmail.com", 8.5));
        studentList.add(new Student(9L, "Conan", 21, "conan@gmail.com", 6.5));
        studentList.add(new Student(10L, "Adele", 22, "adele@gmail.com", 9.0));

        for(Student student: studentList)
        {
            studentService.save(student);
        }

        System.out.println("Customized list of student: ");
        List<Student> customizedList = (List<Student>) studentService.getCustomizeStudentList();
        showStudentList(customizedList);
    }
}
