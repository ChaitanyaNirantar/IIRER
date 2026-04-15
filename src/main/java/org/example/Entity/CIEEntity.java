package org.example.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CIETable")
public class CIEEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customer_id;

    private boolean CIEEmployment;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate Employment_Start_Date;

    private String JobTitle;

    private String Job_Description;

    private Long hours_per_week;

    private Long pay_per_hour;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for customer_id
    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    // Getter and Setter for CIEEmployment
    public boolean isCIEEmployment() {
        return CIEEmployment;
    }

    public void setCIEEmployment(boolean CIEEmployment) {
        this.CIEEmployment = CIEEmployment;
    }

    // Getter and Setter for Employment_Start_Date
    public LocalDate getEmployment_Start_Date() {
        return Employment_Start_Date;
    }

    public void setEmployment_Start_Date(LocalDate employment_Start_Date) {
        Employment_Start_Date = employment_Start_Date;
    }

    // Getter and Setter for JobTitle
    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    // Getter and Setter for Job_Description
    public String getJob_Description() {
        return Job_Description;
    }

    public void setJob_Description(String job_Description) {
        Job_Description = job_Description;
    }

    // Getter and Setter for hours_per_week
    public Long getHours_per_week() {
        return hours_per_week;
    }

    public void setHours_per_week(Long hours_per_week) {
        this.hours_per_week = hours_per_week;
    }

    // Getter and Setter for pay_per_hour
    public Long getPay_per_hour() {
        return pay_per_hour;
    }

    public void setPay_per_hour(Long pay_per_hour) {
        this.pay_per_hour = pay_per_hour;
    }

}
