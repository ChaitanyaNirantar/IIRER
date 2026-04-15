package org.example.Entity;

public class VRServiceDTO {
    private String email;
    private Long id;
    private Long customer_id;
    private String VR_Service;
    private String effectiveness;

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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