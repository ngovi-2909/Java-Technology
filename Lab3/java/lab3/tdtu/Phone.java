package lab3.tdtu;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Data
@Entity
@Table(name="Phone")
@NoArgsConstructor
@Setter @Getter
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
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
    public Phone(Long ID, String name, Double price, String color, String country, Integer quantity) {
        this.ID = ID;
        Name = name;
        Price = price;
        Color = color;
        Country = country;
        Quantity = quantity;
    }
    public String convertDecimalFormat(Double nums)
    {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(20);
        return df.format(nums);
    }
    @Override
    public String toString() {
        return "Phone{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + convertDecimalFormat(Price) +
                ", Color='" + Color + '\'' +
                ", Country='" + Country + '\'' +
                ", Quantity=" + Quantity +
                '}';
    }
}
