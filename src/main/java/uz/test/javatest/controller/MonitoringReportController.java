package uz.test.javatest.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.test.javatest.payload.ReqMonitoringReport;
import uz.test.javatest.payload.ResInfoAboutCurrentDebt;
import uz.test.javatest.payload.ResReport;
import uz.test.javatest.services.MonitoringReportService;

import java.util.List;


@RestController
@RequestMapping("/monitor")
public class MonitoringReportController {

    public MonitoringReportService monitoringReportService;
    @Autowired
    public MonitoringReportController(MonitoringReportService monitoringReportService) {
        this.monitoringReportService = monitoringReportService;
    }

    @PostMapping
    public HttpEntity<?> postReport(@RequestBody ReqMonitoringReport reqMonitoringReport) throws NotFoundException {
        ResInfoAboutCurrentDebt report = monitoringReportService.createReport(reqMonitoringReport);
        return ResponseEntity.status(201).body(report);
    }
    @GetMapping("/{userId}")
    public HttpEntity<?> getReport(@PathVariable Integer userId)  {
        List<ResReport> allReports = monitoringReportService.getAllReports(userId);
        return ResponseEntity.status(200).body(allReports);
    }



}
