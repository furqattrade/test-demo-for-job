package uz.test.javatest.services;

import javassist.NotFoundException;
import uz.test.javatest.entity.MonitoringReport;
import uz.test.javatest.payload.ReqMonitoringReport;
import uz.test.javatest.payload.ResInfoAboutCurrentDebt;
import uz.test.javatest.payload.ResReport;

import java.util.List;

public interface MonitoringReportService {
    ResInfoAboutCurrentDebt createReport(ReqMonitoringReport reqMonitoringReport) throws NotFoundException;
    List<ResReport> getAllReports(Integer cusID);

}
