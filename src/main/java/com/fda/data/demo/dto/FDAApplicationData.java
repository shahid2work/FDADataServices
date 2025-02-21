package com.fda.data.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "application_number",
        "sponsor_name",
        "products"
})
public class FDAApplicationData {

    @JsonProperty("application_number")
    private String applicationNumber;

    @JsonProperty("sponsor_name")
    private String sponsorName;

    @JsonProperty("products")
    private List<Product> products = new ArrayList<Product>();

    @JsonProperty("application_number")
    public String getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("application_number")
    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    @JsonProperty("sponsor_name")
    public String getSponsorName() {
        return sponsorName;
    }

    @JsonProperty("sponsor_name")
    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    @JsonProperty("products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
