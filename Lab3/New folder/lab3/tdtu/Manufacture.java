package lab3.tdtu;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="Manufacture")
@NoArgsConstructor
@Setter @Getter
public class Manufacture {
    @Id
    private String ID;
    @Column(nullable = false)
    private String Name;
    @Column
    private String Location;
    @Column
    private int Employee;
    @OneToMany(cascade=CascadeType.ALL,targetEntity = Phone.class)
    @JoinColumn(name="phones_id")
    private Set<Phone> phones;
    public Manufacture(String ID, String name, String location, int employee) {
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
