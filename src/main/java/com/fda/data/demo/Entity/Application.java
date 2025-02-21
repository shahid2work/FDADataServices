package com.fda.data.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fda.data.demo.dto.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    private String applicationNumber;
    private String sponsorName;

    @Column(columnDefinition = "JSON")
    private String applicationJson;

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getApplicationJson() {
        return applicationJson;
    }

    public void setApplicationJson(String applicationJson) {
        this.applicationJson = applicationJson;
    }
}


