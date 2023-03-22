package tdtu.edu;

import lombok.*;
@NoArgsConstructor @Setter @Getter
 class Product {
    private Long id;
    private String name;
    private double price;
    private String decsiption;

    public Product(Product product) {
        this.id = product.id;
        this.name = product.name;
        this.price = product.price;
        this.decsiption = product.decsiption;
    }
}
