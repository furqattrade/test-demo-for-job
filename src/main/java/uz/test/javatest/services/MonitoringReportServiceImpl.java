package uz.test.javatest.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.test.javatest.entity.Customers;
import uz.test.javatest.entity.MonitoringReport;
import uz.test.javatest.entity.SocialService;
import uz.test.javatest.payload.ReqMonitoringReport;
import uz.test.javatest.payload.ResInfoAboutCurrentDebt;
import uz.test.javatest.payload.ResReport;
import uz.test.javatest.repository.CustomerRepository;
import uz.test.javatest.repository.MonitoringReportRepository;
import uz.test.javatest.repository.SocialServiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonitoringReportServiceImpl  implements MonitoringReportService{
    @Autowired
    MonitoringReportRepository monitoringReportRepository;
    @Autowired
    SocialServiceRepository socialServiceRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public ResInfoAboutCurrentDebt createReport(ReqMonitoringReport reqMonitoringReport) throws NotFoundException {
        Customers customer = customerRepository.findById(reqMonitoringReport.getCustomer()).orElseThrow(() -> new NotFoundException("user with this name is not found"));
        SocialService service = socialServiceRepository.findById(reqMonitoringReport.getService()).orElseThrow(() -> new NotFoundException("service not found"));
        long millis=System.currentTimeMillis();
        java.sql.Date today=new java.sql.Date(millis);
        List<Float> lastDebt = monitoringReportRepository.getLastDebt(reqMonitoringReport.getCustomer(), reqMonitoringReport.getService());
       Float lastdebt=0f;
        if(lastDebt.size()!=0){
         lastdebt = lastDebt.get(0);
        }
        float currentDebt=lastdebt-((reqMonitoringReport.getUsageOfResource()*service.getCostPerUnit())-reqMonitoringReport.getPayment());
        MonitoringReport report= new MonitoringReport(customer,service,reqMonitoringReport.getUsageOfResource(),today,reqMonitoringReport.getPayment(),currentDebt);
        MonitoringReport lastReport = monitoringReportRepository.save(report);
        return new  ResInfoAboutCurrentDebt(customer.getFullName(),customer.getConsumerNumber(),lastReport.getDebt(),lastReport.getService().getName());
    }
    public ResReport mapper(MonitoringReport report){
        return new ResReport(report.getId(),report.getCustomer().getFullName(),report.getService().getName(),report.getService().getMeasurementUnit(),report.getService().getCostPerUnit(),report.getReportCreatedDate(),report.getPaymentOfCustomer(),report.getDebt());
    }


    @Override
    public List<ResReport> getAllReports(Integer cusID) {
        return monitoringReportRepository.findAllByCustomer_Id(cusID).stream().map(this::mapper).collect(Collectors.toList());
    }
}
