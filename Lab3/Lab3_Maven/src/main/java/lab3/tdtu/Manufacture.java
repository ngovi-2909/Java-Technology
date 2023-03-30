package lab3.tdtu;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="Manufacture")
@NoArgsConstructor
@Setter @Getter
public class Manufacture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(nullable = false)
    private String Name;
    @Column
    private String Location;
    @Column
    private Integer Employee;
    @OneToMany(mappedBy = "manufacture")
    private List<Phone> phones;
    public Manufacture(Long ID, String name, String location, Integer employee) {
        this.ID = ID;
        Name = name;
        Location = location;
        Employee = employee;
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Location='" + Location + '\'' +
                ", Employee=" + Employee +
                '}';
    }
}
