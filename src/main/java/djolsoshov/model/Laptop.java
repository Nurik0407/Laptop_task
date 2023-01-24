package djolsoshov.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "laptop_id_generated")
    @SequenceGenerator(name = "laptop_id_generated",
    sequenceName = "laptop_id",
    allocationSize = 1)
    private Long id;
    private String brand;
    @Column(name = "operating_system")
    @Enumerated(EnumType.STRING)
    private OperatingSystem operatingSystem;
    private double memory;
    private int price;
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    public Laptop(String brand, OperatingSystem operatingSystem, double memory, int price, LocalDate dateOfIssue) {
        this.brand = brand;
        this.operatingSystem = operatingSystem;
        this.memory = memory;
        this.price = price;
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public String toString() {
        return "\nLaptop{" +
                "\nid=" + id +
                "\nbrand='" + brand +
                "\noperatingSystem=" + operatingSystem +
                "\nmemory=" + memory +
                "\nprice=" + price +
                "\ndateOfIssue=" + dateOfIssue +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}
