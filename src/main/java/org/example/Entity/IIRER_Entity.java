package org.example.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "User")
public class IIRER_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private Double salary;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate DOB;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFormSigned;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate drsApplicationDate;

    private Boolean workedSubminimumWage;

    private Boolean currentlyEmployedCompetitiveEmployment;

    private Boolean previousSubminimum;

    private Boolean receiveSsiSsdi;

    public IIRER_Entity() {}

    public IIRER_Entity(String name, String email, Double salary, LocalDate DOB,
                        LocalDate dateFormSigned, LocalDate drsApplicationDate,
                        Boolean workedSubminimumWage,
                        Boolean currentlyEmployedCompetitiveEmployment,
                        Boolean previousSubminimum,
                        Boolean receiveSsiSsdi) {

        this.name = name;
        this.email = email;
        this.salary = salary;
        this.DOB = DOB;
        this.dateFormSigned = dateFormSigned;
        this.drsApplicationDate = drsApplicationDate;
        this.workedSubminimumWage = workedSubminimumWage;
        this.currentlyEmployedCompetitiveEmployment = currentlyEmployedCompetitiveEmployment;
        this.previousSubminimum = previousSubminimum;
        this.receiveSsiSsdi = receiveSsiSsdi;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public LocalDate getDateFormSigned() {
        return dateFormSigned;
    }

    public void setDateFormSigned(LocalDate dateFormSigned) {
        this.dateFormSigned = dateFormSigned;
    }

    public LocalDate getDrsApplicationDate() {
        return drsApplicationDate;
    }

    public void setDrsApplicationDate(LocalDate drsApplicationDate) {
        this.drsApplicationDate = drsApplicationDate;
    }

    public Boolean getWorkedSubminimumWage() {
        return workedSubminimumWage;
    }

    public void setWorkedSubminimumWage(Boolean workedSubminimumWage) {
        this.workedSubminimumWage = workedSubminimumWage;
    }

    public Boolean getCurrentlyEmployedCompetitiveEmployment() {
        return currentlyEmployedCompetitiveEmployment;
    }

    public void setCurrentlyEmployedCompetitiveEmployment(Boolean currentlyEmployedCompetitiveEmployment) {
        this.currentlyEmployedCompetitiveEmployment = currentlyEmployedCompetitiveEmployment;
    }

    public Boolean getPreviousSubminimum() {
        return previousSubminimum;
    }

    public void setPreviousSubminimum(Boolean previousSubminimum) {
        this.previousSubminimum = previousSubminimum;
    }

    public Boolean getReceiveSsiSsdi() {
        return receiveSsiSsdi;
    }

    public void setReceiveSsiSsdi(Boolean receiveSsiSsdi) {
        this.receiveSsiSsdi = receiveSsiSsdi;
    }
}