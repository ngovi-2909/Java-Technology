package tdtu.edu;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class PdfTextWriter implements TextWriter {
    public void write(String fileName, String text) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));
        printWriter.println("Printing in pdf format ");
        printWriter.print(text);
        printWriter.close();
    }
}
