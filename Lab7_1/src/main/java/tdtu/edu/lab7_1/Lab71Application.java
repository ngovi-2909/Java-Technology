package tdtu.edu.lab7_1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab71Application implements CommandLineRunner {
	public Lab71Application() {
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab71Application.class, args);
	}

	public void run(String... args) {
		System.out.println("Welcome");
	}
}
