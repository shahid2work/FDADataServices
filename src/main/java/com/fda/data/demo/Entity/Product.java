package com.fda.data.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fda.data.demo.dto.ActiveIngredient;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private String productNumber;
    private String referenceDrug;
    private String brandName;
    private List<ActiveIngredient> activeIngredients = new ArrayList<ActiveIngredient>();
    private String referenceStandard;
    private String dosageForm;
    private String route;
    private String marketingStatus;

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getReferenceDrug() {
        return referenceDrug;
    }

    public void setReferenceDrug(String referenceDrug) {
        this.referenceDrug = referenceDrug;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<ActiveIngredient> getActiveIngredients() {
        return activeIngredients;
    }

    public void setActiveIngredients(List<ActiveIngredient> activeIngredients) {
        this.activeIngredients = activeIngredients;
    }

    public String getReferenceStandard() {
        return referenceStandard;
    }

    public void setReferenceStandard(String referenceStandard) {
        this.referenceStandard = referenceStandard;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getMarketingStatus() {
        return marketingStatus;
    }

    public void setMarketingStatus(String marketingStatus) {
        this.marketingStatus = marketingStatus;
    }
}
