package com.catalog.app.model.server;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Server class representing application price in JSON server response
 */
public class AppPrice implements Serializable{

    private static final String PRICE_ATTRIBUTES = "attributes";

    @SerializedName(PRICE_ATTRIBUTES)
    private AppPriceAttributes priceAttributes;

    public AppPrice() {
    }

    public AppPrice(AppPriceAttributes priceAttributes) {
        this.priceAttributes = priceAttributes;
    }

    public AppPriceAttributes getPriceAttributes() {
        return priceAttributes;
    }

    public void setPriceAttributes(AppPriceAttributes priceAttributes) {
        this.priceAttributes = priceAttributes;
    }
}
