package com.catalog.app.model.server;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AppPriceAttributes implements Serializable{

    private static final String PRICE = "amount";

    @SerializedName(PRICE)
    private String price;

    private String currency;

    public AppPriceAttributes() {
    }

    public AppPriceAttributes(String price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
