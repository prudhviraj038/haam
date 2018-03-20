package com.mamacgroup.hamtest.HaamMerge;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by yellowsoft on 4/5/17.
 */
public class Category implements Serializable {
    String id,title,title_ar,image,no_items,all_viewed,last_id="0",des;
    ArrayList<News> newses;
    Category(JSONObject jsonObject){
        newses=new ArrayList<>();
        try {
            id=jsonObject.getString("id");
            title=jsonObject.getString("title");
            title_ar=jsonObject.getString("title_ar");
            des=jsonObject.getString("about");
            image=jsonObject.getString("image");
            ArrayList<News> newses_old=new ArrayList<>();
            for(int i=0;i<jsonObject.getJSONArray("news").length();i++) {
                News news = new News(jsonObject.getJSONArray("news").getJSONObject(i));
                if(AppController.getInstance().news_viewed.contains(news.id)){
//                    Log.e("news_old_viewed", AppController.getInstance().news_viewed.get(i).toString());
                    newses_old.add(news);
//                    Log.e("news_old1", newses_old.get(i).id);
                }else{
                    newses.add(news);
//                    Log.e("news_old2", newses.get(i).id);
                    last_id=news.id;
                }

            }
            if(newses.size()==0){
                all_viewed="1";
                for(int i=0;i<newses_old.size();i++) {
//                Log.e("news_old","newses_old");
                    newses.add(newses_old.get(i));
                }
            }else {
                all_viewed="0";
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
//    public String getTitle(Context context) {
//        if(Settings.get_user_language(context).equals("ar"))
//            return title_ar;
//        else
//            return  title;
//    }
}
