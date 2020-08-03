package uz.test.javatest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class SocialService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String measurementUnit;
    private float costPerUnit;
    private Date costForThisDate;
    private boolean isActive;

    public SocialService(String name, String measurementUnit, float costPerUnit, Date costForThisDate,boolean isActive) {
        this.name = name;
        this.measurementUnit = measurementUnit;
        this.costPerUnit = costPerUnit;
        this.costForThisDate = costForThisDate;
        this.isActive=isActive;
    }
}
