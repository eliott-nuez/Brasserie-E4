package com.example.brasserie.myrequest;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyRequest {

    private Context context;
    private RequestQueue queue;

    public MyRequest(Context context, RequestQueue queue) {
        this.context = context;
        this.queue = queue;
    }

    public void register(final String pseudo, final String email, final String password, final String password2){

        String url = "http://192.168.1.135/borabora/include/connexionStaffAndroid.php";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("APP", response);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("APP", "ERROR = " + error);

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<>();
                map.put("pseudo", pseudo);
                map.put("email", email);
                map.put("password", password);
                map.put("password2", password2);

                return map;
            }
        };

        queue.add(request);

    }

    public void connection(final String pseudo, final String password, final LoginCallBack callback){

        String url = "http://192.168.1.135/borabora/include/connexionStaffAndroid.php";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("APP", response);

                try {
                    JSONObject  json = new JSONObject(response);
                    Boolean error = json.getBoolean("error");

                    if(!error){
                        String pseudo = json.getString("pseudo");
                        callback.onSuccess(pseudo);
                    }else{
                        callback.onError(json.getString("message"));
                    }
                } catch (JSONException e) {
                    callback.onError("Une erreur s'est produite");
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("APP", "ERROR = " + error);

                if(error instanceof NetworkError){

                    callback.onError("Impossible de se connecter");

                }else if(error instanceof VolleyError){

                    callback.onError("Une erreur s'est produite");

                }

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<>();
                map.put("pseudo", pseudo);
                map.put("password", password);

                return map;
            }
        };

    }

    public interface LoginCallBack{
        void onSuccess(String pseudo);
        void onError(String message);
    }
}
