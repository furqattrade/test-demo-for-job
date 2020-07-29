package uz.test.javatest.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResReport {
    private long customerID;
    private String customerName;
    private String serviceName;
    private String measurementUnit;
    private float costPerUnit;
    private Date paymentDate;
    private long paymentAmount;
    private float debt;
}
