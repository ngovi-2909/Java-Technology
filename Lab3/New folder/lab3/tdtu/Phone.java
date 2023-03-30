package lab3.tdtu;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name="Phone")
@NoArgsConstructor
@Setter @Getter
public class Phone {
    @Id
    private String ID;
    @Column(nullable = false)
    private String Name;
    @Column(nullable = false)
    private Double Price;
    @Column(nullable = false)
    private String Color;
    @Column
    private String Country;
    @Column
    private Integer Quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacture_id")
    private Manufacture manufacture;
    public Phone(String ID, String name, Double price, String color, String country, Integer quantity) {
        this.ID = ID;
        Name = name;
        Price = price;
        Color = color;
        Country = country;
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Color='" + Color + '\'' +
                ", Country='" + Country + '\'' +
                ", Quantity=" + Quantity +
                '}';
    }
}
