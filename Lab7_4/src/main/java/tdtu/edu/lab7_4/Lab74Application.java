package tdtu.edu.lab7_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tdtu.edu.lab7_4.model.Student;
import tdtu.edu.lab7_4.service.StudentService;
import tdtu.edu.lab7_4.service.StudentServiceImpl;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class Lab74Application implements CommandLineRunner {
    @Autowired
    StudentServiceImpl studentService;

    public Lab74Application() {
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab74Application.class, args);
    }

    private void showStudents() {
        List<Student> list = (List)this.studentService.getAllStudent();
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Student student = (Student)var2.next();
            System.out.println(student.toString());
        }

    }

    private void showStudentList(List<Student> list) {
        Iterator var2 = list.iterator();

        while(var2.hasNext()) {
            Student i = (Student)var2.next();
            System.out.println(i.toString());
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
        List<Student> studentList = this.studentService.findStudentsWithAgeGreaterThanEqual(19);
        System.out.println("Student with age greater than or equal to 19");
        this.showStudentList(studentList);
        System.out.println("Number of student with 7.0 Ielts score is" + this.studentService.countStudentWithIeltsCore(7.0));
        studentList = this.studentService.searchStudentsByName("ar");
        System.out.println("Student are founds. Their information is ");
        this.showStudentList(studentList);
    }

}
