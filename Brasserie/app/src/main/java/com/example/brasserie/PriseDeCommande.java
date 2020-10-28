package com.example.brasserie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PriseDeCommande extends AppCompatActivity {

    private Button btn_retour_commande, btn_valider_commande;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prise_de_commande);

        btn_retour_commande = (Button) findViewById(R.id.btn_retour_commande);
        btn_valider_commande = (Button) findViewById(R.id.btn_valider_commande);

        btn_retour_commande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuChoix.class);
                startActivity(intent);
            }
        });

        btn_valider_commande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuChoix.class);
                startActivity(intent);
            }
        });
    }

}
