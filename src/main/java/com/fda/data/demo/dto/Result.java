
package com.fda.data.demo.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "application_number",
    "sponsor_name",
    "products"
})
@Generated("jsonschema2pojo")
public class Result {

    @JsonProperty("application_number")
    private String applicationNumber;
    @JsonProperty("sponsor_name")
    private String sponsorName;
    @JsonProperty("products")
    private List<Product> products = new ArrayList<Product>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("application_number")
    public String getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("application_number")
    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public Result withApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    @JsonProperty("sponsor_name")
    public String getSponsorName() {
        return sponsorName;
    }

    @JsonProperty("sponsor_name")
    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public Result withSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
        return this;
    }

    @JsonProperty("products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Result withProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Result withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Result.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("applicationNumber");
        sb.append('=');
        sb.append(((this.applicationNumber == null)?"<null>":this.applicationNumber));
        sb.append(',');
        sb.append("sponsorName");
        sb.append('=');
        sb.append(((this.sponsorName == null)?"<null>":this.sponsorName));
        sb.append(',');
        sb.append("products");
        sb.append('=');
        sb.append(((this.products == null)?"<null>":this.products));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.sponsorName == null)? 0 :this.sponsorName.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.applicationNumber == null)? 0 :this.applicationNumber.hashCode()));
        result = ((result* 31)+((this.products == null)? 0 :this.products.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return (((((this.sponsorName == rhs.sponsorName)||((this.sponsorName!= null)&&this.sponsorName.equals(rhs.sponsorName)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.applicationNumber == rhs.applicationNumber)||((this.applicationNumber!= null)&&this.applicationNumber.equals(rhs.applicationNumber))))&&((this.products == rhs.products)||((this.products!= null)&&this.products.equals(rhs.products))));
    }

}
