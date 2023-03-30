package tdtu.edu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {
    @Value("${id}")
    private String id;
    @Value("${name}")
    private String name;
    @Value("${price}")
    private String price;
    @Value("${description}")
    private String description;

    @Bean
    @Scope("prototype")
    public Product product1()
    {
        Product product = new Product(
                Long.valueOf(this.id),
                String.valueOf(this.name),
                Double.valueOf(this.price),
                String.valueOf(this.description)
        );
        return product;
    }

    @Bean
    @Scope("prototype")
    public Product product2()
    {
        return new Product(product1());
    }

    @Bean
    @Scope("singleton")
    public Product product3()
    {
        return new Product(2L, "PS5", 20000.0, "Intesting");
    }

}
