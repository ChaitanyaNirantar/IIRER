package org.example.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "DRSClosure")
public class DRSEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customer_id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate DRS_Closure_Date;

    private boolean subminimum_job;

    private boolean competitive_job;

    private Long hours_per_week;

    private Long hourly_wage;

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

    // Getter and Setter for DRS_Closure_Date
    public LocalDate getDRS_Closure_Date() {
        return DRS_Closure_Date;
    }

    public void setDRS_Closure_Date(LocalDate DRS_Closure_Date) {
        this.DRS_Closure_Date = DRS_Closure_Date;
    }

    // Getter and Setter for subminimum_job
    public boolean isSubminimum_job() {
        return subminimum_job;
    }

    public void setSubminimum_job(boolean subminimum_job) {
        this.subminimum_job = subminimum_job;
    }

    // Getter and Setter for competitive_job
    public boolean isCompetitive_job() {
        return competitive_job;
    }

    public void setCompetitive_job(boolean competitive_job) {
        this.competitive_job = competitive_job;
    }

    // Getter and Setter for hours_per_week
    public Long getHours_per_week() {
        return hours_per_week;
    }

    public void setHours_per_week(Long hours_per_week) {
        this.hours_per_week = hours_per_week;
    }

    // Getter and Setter for hourly_wage
    public Long getHourly_wage() {
        return hourly_wage;
    }

    public void setHourly_wage(Long hourly_wage) {
        this.hourly_wage = hourly_wage;
    }
}
