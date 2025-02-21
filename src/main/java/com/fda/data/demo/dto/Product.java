
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
    "product_number",
    "reference_drug",
    "brand_name",
    "active_ingredients",
    "reference_standard",
    "dosage_form",
    "route",
    "marketing_status"
})
@Generated("jsonschema2pojo")
public class Product {

    @JsonProperty("product_number")
    private String productNumber;
    @JsonProperty("reference_drug")
    private String referenceDrug;
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("active_ingredients")
    private List<ActiveIngredient> activeIngredients = new ArrayList<ActiveIngredient>();
    @JsonProperty("reference_standard")
    private String referenceStandard;
    @JsonProperty("dosage_form")
    private String dosageForm;
    @JsonProperty("route")
    private String route;
    @JsonProperty("marketing_status")
    private String marketingStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("product_number")
    public String getProductNumber() {
        return productNumber;
    }

    @JsonProperty("product_number")
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public Product withProductNumber(String productNumber) {
        this.productNumber = productNumber;
        return this;
    }

    @JsonProperty("reference_drug")
    public String getReferenceDrug() {
        return referenceDrug;
    }

    @JsonProperty("reference_drug")
    public void setReferenceDrug(String referenceDrug) {
        this.referenceDrug = referenceDrug;
    }

    public Product withReferenceDrug(String referenceDrug) {
        this.referenceDrug = referenceDrug;
        return this;
    }

    @JsonProperty("brand_name")
    public String getBrandName() {
        return brandName;
    }

    @JsonProperty("brand_name")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Product withBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    @JsonProperty("active_ingredients")
    public List<ActiveIngredient> getActiveIngredients() {
        return activeIngredients;
    }

    @JsonProperty("active_ingredients")
    public void setActiveIngredients(List<ActiveIngredient> activeIngredients) {
        this.activeIngredients = activeIngredients;
    }

    public Product withActiveIngredients(List<ActiveIngredient> activeIngredients) {
        this.activeIngredients = activeIngredients;
        return this;
    }

    @JsonProperty("reference_standard")
    public String getReferenceStandard() {
        return referenceStandard;
    }

    @JsonProperty("reference_standard")
    public void setReferenceStandard(String referenceStandard) {
        this.referenceStandard = referenceStandard;
    }

    public Product withReferenceStandard(String referenceStandard) {
        this.referenceStandard = referenceStandard;
        return this;
    }

    @JsonProperty("dosage_form")
    public String getDosageForm() {
        return dosageForm;
    }

    @JsonProperty("dosage_form")
    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public Product withDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
        return this;
    }

    @JsonProperty("route")
    public String getRoute() {
        return route;
    }

    @JsonProperty("route")
    public void setRoute(String route) {
        this.route = route;
    }

    public Product withRoute(String route) {
        this.route = route;
        return this;
    }

    @JsonProperty("marketing_status")
    public String getMarketingStatus() {
        return marketingStatus;
    }

    @JsonProperty("marketing_status")
    public void setMarketingStatus(String marketingStatus) {
        this.marketingStatus = marketingStatus;
    }

    public Product withMarketingStatus(String marketingStatus) {
        this.marketingStatus = marketingStatus;
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

    public Product withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Product.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productNumber");
        sb.append('=');
        sb.append(((this.productNumber == null)?"<null>":this.productNumber));
        sb.append(',');
        sb.append("referenceDrug");
        sb.append('=');
        sb.append(((this.referenceDrug == null)?"<null>":this.referenceDrug));
        sb.append(',');
        sb.append("brandName");
        sb.append('=');
        sb.append(((this.brandName == null)?"<null>":this.brandName));
        sb.append(',');
        sb.append("activeIngredients");
        sb.append('=');
        sb.append(((this.activeIngredients == null)?"<null>":this.activeIngredients));
        sb.append(',');
        sb.append("referenceStandard");
        sb.append('=');
        sb.append(((this.referenceStandard == null)?"<null>":this.referenceStandard));
        sb.append(',');
        sb.append("dosageForm");
        sb.append('=');
        sb.append(((this.dosageForm == null)?"<null>":this.dosageForm));
        sb.append(',');
        sb.append("route");
        sb.append('=');
        sb.append(((this.route == null)?"<null>":this.route));
        sb.append(',');
        sb.append("marketingStatus");
        sb.append('=');
        sb.append(((this.marketingStatus == null)?"<null>":this.marketingStatus));
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
        result = ((result* 31)+((this.brandName == null)? 0 :this.brandName.hashCode()));
        result = ((result* 31)+((this.route == null)? 0 :this.route.hashCode()));
        result = ((result* 31)+((this.activeIngredients == null)? 0 :this.activeIngredients.hashCode()));
        result = ((result* 31)+((this.referenceStandard == null)? 0 :this.referenceStandard.hashCode()));
        result = ((result* 31)+((this.dosageForm == null)? 0 :this.dosageForm.hashCode()));
        result = ((result* 31)+((this.productNumber == null)? 0 :this.productNumber.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.referenceDrug == null)? 0 :this.referenceDrug.hashCode()));
        result = ((result* 31)+((this.marketingStatus == null)? 0 :this.marketingStatus.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Product) == false) {
            return false;
        }
        Product rhs = ((Product) other);
        return ((((((((((this.brandName == rhs.brandName)||((this.brandName!= null)&&this.brandName.equals(rhs.brandName)))&&((this.route == rhs.route)||((this.route!= null)&&this.route.equals(rhs.route))))&&((this.activeIngredients == rhs.activeIngredients)||((this.activeIngredients!= null)&&this.activeIngredients.equals(rhs.activeIngredients))))&&((this.referenceStandard == rhs.referenceStandard)||((this.referenceStandard!= null)&&this.referenceStandard.equals(rhs.referenceStandard))))&&((this.dosageForm == rhs.dosageForm)||((this.dosageForm!= null)&&this.dosageForm.equals(rhs.dosageForm))))&&((this.productNumber == rhs.productNumber)||((this.productNumber!= null)&&this.productNumber.equals(rhs.productNumber))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.referenceDrug == rhs.referenceDrug)||((this.referenceDrug!= null)&&this.referenceDrug.equals(rhs.referenceDrug))))&&((this.marketingStatus == rhs.marketingStatus)||((this.marketingStatus!= null)&&this.marketingStatus.equals(rhs.marketingStatus))));
    }

}
