package uz.test.javatest.controller;


import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.junit4.SpringRunner;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uz.test.javatest.payload.ReqMonitoringReport;
import uz.test.javatest.payload.ResInfoAboutCurrentDebt;
import uz.test.javatest.payload.ResReport;
import uz.test.javatest.services.MonitoringReportService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = MonitoringReportController.class)
class MonitoringReportControllerTest {

    @Autowired
    private MockMvc webMvc;
    @MockBean
    MonitoringReportService monitoringReportService;
    @Autowired
    ObjectMapper mapper;

        @Test
    void postReport() throws Exception {
        ReqMonitoringReport monitoringReport= new ReqMonitoringReport(1,1,20,100);
        ResInfoAboutCurrentDebt resInfoAboutCurrentDebt= new ResInfoAboutCurrentDebt("furqat",1,111,"gas");
        Mockito.when(monitoringReportService.createReport(Mockito.any(ReqMonitoringReport.class))).thenReturn(resInfoAboutCurrentDebt);
         RequestBuilder request= MockMvcRequestBuilders
                 .post("/monitor")
                 .accept(MediaType.APPLICATION_JSON)
                 .content(mapper.writeValueAsString(monitoringReport))
                 .contentType(MediaType.APPLICATION_JSON);
            MvcResult result = webMvc.perform(request).andReturn();
            MockHttpServletResponse response=result.getResponse();
            Assert.assertEquals(HttpStatus.CREATED.value(),response.getStatus());
            Assert.assertEquals(mapper.writeValueAsString(resInfoAboutCurrentDebt),response.getContentAsString());
            JSONAssert.assertEquals(mapper.writeValueAsString(resInfoAboutCurrentDebt),response.getContentAsString(),true);
    }

    @Test
    void getReport()throws Exception  {
      ResReport report= new ResReport(1,"ofru","gas","cube meter",11,Calendar.getInstance().getTime(),11,11);
        List<ResReport> resReportList = new ArrayList<>();
        resReportList.add(report);
        Mockito.when(monitoringReportService.getAllReports(Mockito.anyInt())).thenReturn(resReportList);
        RequestBuilder requestBuilder=MockMvcRequestBuilders
                .get("/monitor/1");
        MvcResult result=webMvc.perform(requestBuilder)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        MockHttpServletResponse response=result.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
        Assert.assertEquals(1,resReportList.size());
        JSONAssert.assertEquals(mapper.writeValueAsString(resReportList),response.getContentAsString(),true);
    }

}