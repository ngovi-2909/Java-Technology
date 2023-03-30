package tdtu.edu.lab7_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tdtu.edu.lab7_2.model.Student;
import tdtu.edu.lab7_2.service.StudentServiceImpl;

import java.util.Iterator;
import java.util.List;

@ComponentScan({"tdtu.edu.lab7_2.model", "tdtu.edu.lab7_2.repository", "tdtu.edu.lab7_2.service"})
@SpringBootApplication
public class Lab72Application implements CommandLineRunner {
    @Autowired
    StudentServiceImpl studentService;

    public Lab72Application() {
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab72Application.class, args);
    }

    private void showStudents() {
        List<Student> list = (List)this.studentService.getAllStudent();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Student student = (Student)var2.next();
            System.out.println(student.toString());
        }

    }

    public void run(String... args) throws Exception {
        Student student1 = new Student(1L, "John", 18, "john@gmail.com", 6.5);
        Student student2 = new Student(2L, "Jack", 20, "jack@gmail.com", 7.0);
        Student student3 = new Student(3L, "Marry", 19, "marry@gmail.com", 7.5);
        this.studentService.save(student1);
        this.studentService.save(student2);
        this.studentService.save(student3);
        this.showStudents();
        System.out.println("After update student 1");
        student1.setIeltsScore(8.5);
        this.studentService.save(student1);
        this.showStudents();
        System.out.println("After deleted student 2");
        this.studentService.deleteStudent(2L);
        this.showStudents();
    }
}
