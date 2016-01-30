package com.catalog.app.model.server;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Server class representing app summary in JSON server response
 */
public class AppSummary implements Serializable{

    private static final String SUMMARY = "label";

    @SerializedName(SUMMARY)
    private String summary;

    public AppSummary() {
    }

    public AppSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
