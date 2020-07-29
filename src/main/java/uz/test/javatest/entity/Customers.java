package uz.test.javatest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fullName;
    private long consumerNumber;

    public Customers(String fullName, long consumerNumber) {
        this.fullName = fullName;
        this.consumerNumber = consumerNumber;
    }
}
