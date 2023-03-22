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

    public Product(Long id, String name, double price, String decsiption) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.decsiption = decsiption;
    }
}
