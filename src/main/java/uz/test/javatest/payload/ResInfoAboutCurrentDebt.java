package uz.test.javatest.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResInfoAboutCurrentDebt {
    private String customerName;
    private long customerID;
    private float currentBalance;
    private String serviceName;


}
