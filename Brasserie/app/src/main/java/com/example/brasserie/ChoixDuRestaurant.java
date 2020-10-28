package com.example.brasserie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoixDuRestaurant extends AppCompatActivity {

    private Button btn_valider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_du_restaurant);
        btn_valider = (Button) findViewById(R.id.btn_valider);

        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuChoix.class);
                startActivity(intent);
            }
        });
    }
}
