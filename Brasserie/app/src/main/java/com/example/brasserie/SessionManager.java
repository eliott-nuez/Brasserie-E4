package com.example.brasserie;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private final static String PREFS_NAME = "app_prefs";
    private final static int PRIVATE_MODE = 0;
    private final static String IS_LOGGED = "isLogged";
    private final static String PSEUDO = "pseudo";
    private final static String RESTAURANT = "restaurant";
    private Context context;

    public SessionManager(Context context){
        this.context = context;
        prefs = context.getSharedPreferences(PREFS_NAME, PRIVATE_MODE);
        editor = prefs.edit();
    }

    public boolean isLogged(){
        return prefs.getBoolean(IS_LOGGED, false);
    }

    public String getPseudo(){
        return prefs.getString(PSEUDO, null);
    }

    public String getRestaurant(){
        return prefs.getString(RESTAURANT, null);
    }

    public void insertRestaurant(String restaurant){
        editor.putString(RESTAURANT, restaurant);
        editor.commit();
    }

    public void insertUser(String pseudo){
        editor.putBoolean(IS_LOGGED, true);
        editor.putString(PSEUDO, pseudo);
        editor.commit();
    }

    public void logout(){
        editor.clear().commit();
    }

    public void changerRestaurant(){
        editor.putString(RESTAURANT, null).commit();
    }
}
