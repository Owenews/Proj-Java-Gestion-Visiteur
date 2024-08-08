package com.example.gestionvisiteur.controlleur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.gestionvisiteur.R;

public class PropositionActivity extends Activity {
    Button ajouter, consulter, modifier ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposition);
        ajouter = findViewById(R.id.btnAjouter);
        consulter = findViewById(R.id.btnConsulter);
        modifier = findViewById(R.id.btnModifier);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 =  new Intent(PropositionActivity.this, AjoutActivity.class);
                startActivity(intent2);
            }
        });

        consulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent c = new Intent(PropositionActivity.this, ConsultActivity.class);
                startActivity(c);
            }
        });

        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent c = new Intent(PropositionActivity.this, ModifierActivity.class);
                startActivity(c);
            }
        });

    }
}
