package com.catalog.app.model.client;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;
import java.util.List;

@Table(name = App.TABLE_NAME)
public class App extends Model implements Serializable{

    public static final String TABLE_NAME = "App";
    public static final String CATEGORY = "category";

    @Column
    private String appName;

    @Column
    private String summary;

    @Column
    private String artistName;

    @Column
    private String price;

    @Column
    private String releaseDate;

    @Column(name = CATEGORY)
    private Category category;

    public App() {}

    public App(String appName, String summary, String artistName, String price, String releaseDate, Category category) {
        this.appName = appName;
        this.summary = summary;
        this.artistName = artistName;
        this.price = price;
        this.releaseDate = releaseDate;
        this.category = category;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Image> getImageList() {
        return getMany(Image.class, Image.APP);
    }
}
