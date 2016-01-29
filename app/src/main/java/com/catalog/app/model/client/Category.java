package com.catalog.app.model.client;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;
import java.util.List;

@Table(name = Category.TABLE_NAME)
public class Category extends Model implements Serializable{

    public static final String TABLE_NAME = "Category";

    @Column
    private String name;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<App> getAppList() {
        return getMany(App.class, App.CATEGORY);
    }
}
