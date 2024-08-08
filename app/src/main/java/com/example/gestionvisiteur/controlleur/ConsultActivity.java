package com.example.gestionvisiteur.controlleur;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

import org.json.JSONException;

import java.util.ArrayList;

public class ConsultActivity extends AppCompatActivity {
    Button retour;
    private ListView listeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        listeView = findViewById(R.id.list);
        retour = findViewById(R.id.btnRetour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ret = new Intent(ConsultActivity.this, PropositionActivity.class);
                startActivity(ret);
            }
        });


        VisiteurDAO visiteurAcces = new VisiteurDAO(this);

        ArrayList<Visiteur> listeVisiteur = new ArrayList<Visiteur>();
        try {
            listeVisiteur  = visiteurAcces.getVisiteurs();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        for(Visiteur unVisiteur : listeVisiteur){
            Log.d("msg", unVisiteur.toString());
        }

        ArrayAdapter monAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listeVisiteur);
        listeView.setAdapter(monAdapter);

        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Visiteur clickedItem = (Visiteur) listeView.getAdapter().getItem(position);
                Intent i = new Intent(ConsultActivity.this, DetailsActivity.class);
                i.putExtra("id", clickedItem.getId());
                i.putExtra("nom", clickedItem.getNom());
                i.putExtra("prenom", clickedItem.getPrenom());
                i.putExtra("login", clickedItem.getLogin());
                i.putExtra("mdp", clickedItem.getMdp());
                i.putExtra("adresse", clickedItem.getAdresse());
                i.putExtra("cp", clickedItem.getCp());
                i.putExtra("ville", clickedItem.getVille());
                i.putExtra("dateEmbauche", clickedItem.getDate());
                startActivity(i);
            }

        });

    }
}
