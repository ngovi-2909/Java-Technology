package tdtu.edu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter @Getter
public class Product {
    private long id;
    private String name;
    private double price;
    private String description;

    public Product(Product product)
    {
        this.id = product.id;
        this.name = product.name;
        this.price = product.price;
        this.description = product.description;
    }

    public Product(long id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
