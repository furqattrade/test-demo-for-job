package uz.test.javatest.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.test.javatest.entity.Customers;
import uz.test.javatest.entity.SocialService;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqMonitoringReport {
    private Integer customer;
    private Integer service;
    private float usageOfResource;
    private long payment;

}
