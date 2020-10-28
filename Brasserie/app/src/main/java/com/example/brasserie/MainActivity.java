package com.example.brasserie;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.brasserie.myrequest.MyRequest;

public class MainActivity extends AppCompatActivity {


    private Button btn_connexion;
    private TextInputLayout til_pseudo, til_password;
    private RequestQueue queue;
    private MyRequest request;
    private ProgressBar pb_loader;
    private Handler handler;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn_connexion = (Button) findViewById(R.id.btn_send);
        til_pseudo = (TextInputLayout) findViewById(R.id.til_pseudo);
        til_password = (TextInputLayout) findViewById(R.id.til_password);
        pb_loader = (ProgressBar) findViewById(R.id.pb_loader);

        queue = VolleySingleton.getInstance(this).getRequestQueue();
        request = new MyRequest(this, queue);
        handler = new Handler();
        sessionManager = new SessionManager(this);

        btn_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String pseudo = til_pseudo.getEditText().getText().toString().trim();
                final String password = til_password.getEditText().getText().toString().trim();
                pb_loader.setVisibility(View.VISIBLE);
                if(pseudo.length() > 0) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            request.connection(pseudo, password, new MyRequest.LoginCallBack() {
                                @Override
                                public void onSuccess(String pseudo) {
                                    pb_loader.setVisibility(View.GONE);
                                    sessionManager.insertUser(pseudo);
                                    Intent intent1 = new Intent(getApplicationContext(), ChoixDuRestaurant.class);
                                    startActivity(intent1);
                                    finish();
                                }

                                @Override
                                public void onError(String message) {
                                    pb_loader.setVisibility(View.GONE);
                                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                                }
                            });
                        }
                    },1000);


                }else{
                    pb_loader.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
