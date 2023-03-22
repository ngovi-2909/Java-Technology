package tdtu.edu;

import org.springframework.context.annotation.Bean;

public class ApplicationConfiguration {
    @Bean
    public TextWriter plainTextWriter()
    {
        return new PlainTextWriter();
    }

    @Bean
    public PdfTextWriter pdfTextWriter()
    {
        return new PdfTextWriter();
    }

    @Bean
    public TextEditor textEditor()
    {
        return new TextEditor();
    }
}
