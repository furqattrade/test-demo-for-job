package uz.test.javatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.test.javatest.entity.SocialService;
import uz.test.javatest.repository.MonitoringReportRepository;
import uz.test.javatest.util.InitConfig;

import java.util.List;

@SpringBootApplication
public class JavatestApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavatestApplication.class, args);
    }

}
