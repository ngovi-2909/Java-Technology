package tdtu.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Application {
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.input("Spring is coming");
        try
        {
            textEditor.save("spring.txt");
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
