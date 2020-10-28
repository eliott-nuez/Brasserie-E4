package com.example.brasserie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChoixTable extends AppCompatActivity {

    private Button btn_retour_menu_choix, btn_valider_choix_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_table);

        btn_retour_menu_choix = (Button) findViewById(R.id.btn_retour_menu_choix);
        btn_valider_choix_table = (Button) findViewById(R.id.btn_valider_choix_table);

        btn_retour_menu_choix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuChoix.class);
                startActivity(intent);
            }
        });

        btn_valider_choix_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SuiviCommande.class);
                startActivity(intent);
            }
        });
    }
}
