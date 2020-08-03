package uz.test.javatest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
public class MonitoringReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    private Customers customer;
    @OneToOne(fetch = FetchType.LAZY)
    private SocialService service;
    private float usageOfResource;
    private Date reportCreatedDate;
    private long paymentOfCustomer;
    private float debt;

    public MonitoringReport(Customers customer, SocialService service, float usageOfResource, Date reportCreatedDate, long paymentOfCustomer,float debt) {
        this.customer = customer;
        this.service = service;
        this.usageOfResource = usageOfResource;
        this.reportCreatedDate = reportCreatedDate;
        this.paymentOfCustomer = paymentOfCustomer;
        this.debt=debt;
    }
}
