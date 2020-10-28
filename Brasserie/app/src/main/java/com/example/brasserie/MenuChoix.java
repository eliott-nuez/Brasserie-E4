package com.example.brasserie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuChoix extends AppCompatActivity {

    private Button btn_commande, btn_suivi_commande, btn_choix_du_restaurant, btn_logout;
    private SessionManager sessionManager;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_choix);

        btn_commande = (Button) findViewById(R.id.btn_commande);
        btn_suivi_commande = (Button) findViewById(R.id.btn_suivi_commande);
        btn_choix_du_restaurant = (Button) findViewById(R.id.btn_choix_du_restaurant);
        btn_logout = (Button) findViewById(R.id.btn_logout);
        textView = (TextView) findViewById(R.id.tv_pseudo);
        sessionManager = new SessionManager(this);
        if(sessionManager.isLogged()){
            String pseudo = sessionManager.getPseudo();
            textView.setText(pseudo);
        }

        btn_choix_du_restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChoixDuRestaurant.class);
                startActivity(intent);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_commande.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PriseDeCommande.class);
                startActivity(intent);
            }
        });

        btn_suivi_commande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChoixTable.class);
                startActivity(intent);
            }
        });

    }
}
