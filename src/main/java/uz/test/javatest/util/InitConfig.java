package uz.test.javatest.util;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import uz.test.javatest.repository.MonitoringReportRepository;

import javax.swing.*;
import java.util.List;
import java.util.Properties;

public class InitConfig {


    @Autowired
    MonitoringReportRepository monitoringReportRepository;

    public void init(){
        Properties props = new Properties();
            if(props.getProperty("spring.jpa.hibernate.ddl-auto").equals("create-drop")){
                List<Float> lastDebt = monitoringReportRepository.getLastDebt(1, 1);
                System.out.println("toto  "+ lastDebt.get(0));

            }

    }


}
