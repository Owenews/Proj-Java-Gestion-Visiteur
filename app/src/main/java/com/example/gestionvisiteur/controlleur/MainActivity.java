package com.example.gestionvisiteur.controlleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

public class MainActivity extends AppCompatActivity {
    EditText txtLogin, txtMdp;
    Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLogin = findViewById(R.id.editLogin);
        txtMdp = findViewById(R.id.editLogin);
        valider = findViewById(R.id.btnValider);

        valider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, PropositionActivity.class);
                startActivity(intent);

            }
        });
    }
}