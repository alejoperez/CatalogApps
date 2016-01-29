package com.catalog.app.interactors;

import android.content.Context;

import com.activeandroid.query.Select;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.catalog.app.model.client.App;
import com.catalog.app.model.client.Image;
import com.catalog.app.model.client.Category;
import com.catalog.app.model.server.AppImage;
import com.catalog.app.model.server.AppServer;
import com.catalog.app.model.server.AppStore;
import com.catalog.app.presenters.ICatalogPresenter;
import com.catalog.app.volley.VolleySingleton;
import com.catalog.app.BuildConfig;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CatalogInteractor implements ICatalogInteractor{

    public static final int NOT_FOUND = -1;

    @Override
    public void loadCatalog(Context context,ICatalogPresenter catalogPresenter){

        if(isCatalogInLocalStorage()){
            catalogPresenter.onLoadCatalogSuccess(getCatalogFromLocalStorage());
        }else {
            loadCatalogFromServer(context,catalogPresenter);
        }
    }

    @Override
    public boolean isCatalogInLocalStorage() {
        List<Category> categoryList = new Select().from(Category.class).execute();
        return categoryList != null && !categoryList.isEmpty();
    }

    @Override
    public List<Category> getCatalogFromLocalStorage() {
        return new Select().from(Category.class).execute();
    }

    @Override
    public void loadCatalogFromServer(Context context, final ICatalogPresenter catalogPresenter){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, BuildConfig.APP_STORE_URL,new JSONObject(),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            AppStore appStore = new Gson().fromJson(response.toString(),AppStore.class);
                            processServerResponse(appStore);
                            catalogPresenter.onLoadCatalogSuccess(getCatalogFromLocalStorage());
                        }catch (Exception e){
                            catalogPresenter.onLoadCatalogFail();
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        catalogPresenter.onLoadCatalogFail();
                    }
                }
        );

        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    private void processServerResponse(AppStore appStore) {
        List<AppServer> appServerList = appStore.getAppStoreContent().getAppServerList();
        List<Category> categoryList = new ArrayList<>();
        for(AppServer appServer: appServerList){
            int categoryIndex = getCategoryIndex(appServer,categoryList);
            if(categoryIndex == NOT_FOUND){
                createNewCategory(categoryList, appServer);
            }else{
                addAppToExistingCategory(categoryList, appServer, categoryIndex);
            }
        }
    }

    private int getCategoryIndex(AppServer appServer, List<Category> categoryList) {
        int categoryIndex = NOT_FOUND;
        String appCategoryName = appServer.getCategory().getCategoryAttributes().getLabel();
        for(int i=0;i<categoryList.size();i++){
            String currentCategory = categoryList.get(i).getName();
            if(currentCategory.equals(appCategoryName)){
                categoryIndex = i;
                break;
            }
        }
        return categoryIndex;
    }

    private void createNewCategory(List<Category> categoryList, AppServer appServer) {
        String categoryName = appServer.getCategory().getCategoryAttributes().getLabel();
        Category category = new Category(categoryName);
        category.save();
        categoryList.add(category);
        saveApp(appServer, category);
    }

    private void addAppToExistingCategory(List<Category> categoryList, AppServer appServer, int categoryIndex) {
        Category category = categoryList.get(categoryIndex);
        saveApp(appServer, category);
    }

    private void saveApp(AppServer appServer, Category category) {
        App app = new App(
                appServer.getAppName().getLabel(),
                appServer.getSummary().getSummary(),
                appServer.getAppArtist().getName(),
                appServer.getAppPrice().getPriceAttributes().getCurrency() + " " + appServer.getAppPrice().getPriceAttributes().getPrice(),
                appServer.getAppReleaseDate().getAppReleaseDateAttributes().getLabel(),
                category
        );
        app.save();

        saveAppImages(appServer, app);
    }

    private void saveAppImages(AppServer appServer, App app) {
        for (AppImage appImage : appServer.getAppImageList()) {
            Image image = new Image(appImage.getImageUrl(), app);
            image.save();
        }
    }
}
