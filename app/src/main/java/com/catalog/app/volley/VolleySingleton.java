package com.catalog.app.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Volley singleton class responsible to perform HTTP requests
 */
public class VolleySingleton {
    private static VolleySingleton volleyInstance;
    private RequestQueue requestQueue;
    private static Context context;

    private VolleySingleton(Context context) {
        VolleySingleton.context = context;
        requestQueue = getRequestQueue();

    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (volleyInstance == null) {
            volleyInstance = new VolleySingleton(context);
        }
        return volleyInstance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
