package com.mamacgroup.hamtest.HaamMerge;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
//import com.crashlytics.android.Crashlytics;
import com.danikula.videocache.HttpProxyCacheServer;
//import com.facebook.FacebookSdk;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
//import com.google.android.gms.analytics.GoogleAnalytics;
//import com.google.android.gms.analytics.Tracker;
//import com.onesignal.OneSignal;

import org.json.JSONArray;
import org.json.JSONObject;

//import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;

public class AppController extends MultiDexApplication {

//    private static final String TAG = ApplicationSingleton.class.getSimpleName();

    public static final String TAG = AppController.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static AppController mInstance;
    public JSONArray rates;
    public ArrayList<String> selected_channels;
    public ArrayList<String> selected_categories;
    public ArrayList<String> news_viewed;
    public JSONObject cat_images;
    public JSONObject cat_des;
   // private Tracker mTracker;

    @Override
    public void onCreate() {
        super.onCreate();
       // Fabric.with(this, new Crashlytics());
        mInstance = this;
        //FacebookSdk.sdkInitialize(this);
        //AppEventsLogger.activateApp(this);
        selected_channels = new ArrayList<>();
        selected_categories = new ArrayList<>();
        news_viewed = new ArrayList<>();

        //OneSignal.startInit(this)
             //   .setNotificationOpenedHandler(new ExampleNotificationOpenedHandler(this))
//                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
//                .unsubscribeWhenNotificationsAreDisabled(true)
              //  .init();

        cat_images = new JSONObject();
        cat_des = new JSONObject();


    }


//    synchronized public Tracker getDefaultTracker() {
//        Log.e("screen", "screen test");
//        if (mTracker == null) {
//            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
//            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
//            mTracker = analytics.newTracker("UA-107142897-1");
//        }
//        return mTracker;
//    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

        public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests() {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(null);
        }
    }
    public int getAppVersion() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    private HttpProxyCacheServer proxy;

    public static HttpProxyCacheServer getProxy(Context context) {
        AppController app = (AppController) context.getApplicationContext();
        return app.proxy == null ? (app.proxy = app.newProxy()) : app.proxy;
    }

    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer(this);
    }




}