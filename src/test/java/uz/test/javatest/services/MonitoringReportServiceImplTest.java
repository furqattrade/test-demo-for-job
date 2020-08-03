package uz.test.javatest.services;

import javassist.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import uz.test.javatest.entity.Customers;
import uz.test.javatest.entity.MonitoringReport;
import uz.test.javatest.entity.SocialService;
import uz.test.javatest.payload.ReqMonitoringReport;
import uz.test.javatest.payload.ResInfoAboutCurrentDebt;
import uz.test.javatest.payload.ResReport;
import uz.test.javatest.repository.CustomerRepository;
import uz.test.javatest.repository.MonitoringReportRepository;
import uz.test.javatest.repository.SocialServiceRepository;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
class MonitoringReportServiceImplTest {

    @Mock
    MonitoringReportRepository monitoringReportRepository;
    @Mock
    SocialServiceRepository socialServiceRepository;
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    MonitoringReportServiceImpl monitoringReportService;



    List<MonitoringReport> monitoringReportList;


    @Before
    public void init(){
        Customers customers = new Customers(1, "orfu", 11);
        SocialService socialService=new SocialService("gas", "cub", 10, Calendar.getInstance().getTime(), true);
        monitoringReportList.add(new MonitoringReport(customers, socialService, 10, Calendar.getInstance().getTime(), 100, 100));
    }


    @Test
    void getAllReports() {
       ResReport resReport=new ResReport(11,"orfu","gas","cub",11, Calendar.getInstance().getTime(),11,11);
       Mockito.when(monitoringReportRepository.findAllByCustomer_Id(Mockito.anyInt())).thenReturn(monitoringReportList);
       List<ResReport> allReports = monitoringReportService.getAllReports(Mockito.anyInt());
       Assert.assertNotNull(allReports);
       Assert.assertEquals(allReports.get(0).getCustomerID(),resReport.getCustomerID());
       Assert.assertEquals(allReports.get(0).getCustomerName(),resReport.getCustomerName());

    }

    public ResReport mapper(MonitoringReport report){
        return new ResReport(report.getId(),report.getCustomer().getFullName(),report.getService().getName(),report.getService().getMeasurementUnit(),report.getService().getCostPerUnit(),report.getReportCreatedDate(),report.getPaymentOfCustomer(),report.getDebt());
    }
}