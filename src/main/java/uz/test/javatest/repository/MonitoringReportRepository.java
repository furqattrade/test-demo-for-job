package uz.test.javatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.test.javatest.entity.MonitoringReport;

import java.util.List;

public interface MonitoringReportRepository extends JpaRepository< MonitoringReport,Integer> {
@Query(value = "select debt from monitoring_report  where monitoring_report.customer_id=:customerId and monitoring_report.service_id=:serId order by monitoring_report.report_created_date DESC LIMIT 1",nativeQuery = true)
List<Float> getLastDebt(@Param("customerId") long customerId, @Param("serId") long serviceId);

List<MonitoringReport> findAllByCustomer_Id(Integer cusId);
}
