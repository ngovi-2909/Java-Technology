package tdtu.edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfiguration {
    @Bean
    @Scope("prototype")
    public Product product1()
    {
        Product product = new Product(1L, "Iphone", 1000.0, "A greate Iphone");
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
        Product product = new Product(2L, "PS5", 2500.0, "Interesting!");
        return product;
    }
}
