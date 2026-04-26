package org.example.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CIETable")
public class CIEEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private boolean cieEmployment;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate employmentStartDate;

    private String vrService;

    private String jobDescription;

    private Long hoursPerWeek;

    private Long payPerHour;

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    @JsonProperty("customer_id")
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public boolean isCieEmployment() {
        return cieEmployment;
    }

    @JsonProperty("CIEEmployment")
    public void setCieEmployment(boolean cieEmployment) {
        this.cieEmployment = cieEmployment;
    }

    public LocalDate getEmploymentStartDate() {
        return employmentStartDate;
    }

    @JsonProperty("Employment_Start_Date")
    public void setEmploymentStartDate(LocalDate employmentStartDate) {
        this.employmentStartDate = employmentStartDate;
    }

    public String getVrService() {
        return vrService;
    }

    @JsonProperty("VR_Service")
    public void setVrService(String vrService) {
        this.vrService = vrService;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    @JsonProperty("Job_Description")
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Long getHoursPerWeek() {
        return hoursPerWeek;
    }

    @JsonProperty("hours_per_week")
    public void setHoursPerWeek(Long hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public Long getPayPerHour() {
        return payPerHour;
    }

    @JsonProperty("pay_per_hour")
    public void setPayPerHour(Long payPerHour) {
        this.payPerHour = payPerHour;
    }
}