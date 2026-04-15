package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "VRServices")
public class VR_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customer_id;

    private String VR_Service;

    private String effectiveness;


    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }
    // Getter and Setter for id
    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id() {
        this.customer_id = customer_id;
    }

    // Getter and Setter for VR_Service
    public String getVR_Service() {
        return VR_Service;
    }

    public void setVR_Service(String VR_Service) {
        this.VR_Service = VR_Service;
    }

    // Getter and Setter for effectiveness
    public String getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(String effectiveness) {
        this.effectiveness = effectiveness;
    }
}