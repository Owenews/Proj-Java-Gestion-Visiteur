package com.example.gestionvisiteur.controlleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

public class DetailsActivity extends AppCompatActivity {
    Button valider, supprimer;
    private VisiteurDAO recupVisiteur;
    private Visiteur leVisiteur;

    String idV, nom, prenom, login, mdp, adresse, cp, ville, date;
    private EditText idRecu, nomRecu, prenomRecu, loginRecu, mdpRecu, adresseRecu, cpRecu, villeRecu, dateRecu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        valider = findViewById(R.id.btnValiderAjout);
        supprimer = findViewById(R.id.btnSupprimer);

        idRecu = findViewById(R.id.editTextId);
        nomRecu = findViewById(R.id.editTextNom);
        prenomRecu = findViewById(R.id.editTextPre);
        loginRecu = findViewById(R.id.editTextLogin);
        mdpRecu = findViewById(R.id.editTextMdp);
        adresseRecu = findViewById(R.id.editTextAdRue);
        cpRecu = findViewById(R.id.editTextCP);
        villeRecu = findViewById(R.id.editTextVille);
        dateRecu = findViewById(R.id.editTextDate);

         idV = getIntent().getStringExtra("id");
         nom = getIntent().getStringExtra("nom");
         prenom = getIntent().getStringExtra("prenom");
         login = getIntent().getStringExtra("login");
         mdp = getIntent().getStringExtra("mdp");
         adresse = getIntent().getStringExtra("adresse");
         cp = getIntent().getStringExtra("cp");
         ville = getIntent().getStringExtra("ville");
         date = getIntent().getStringExtra("dateEmbauche");



        idRecu.setText(idV);
        nomRecu.setText(nom);
        prenomRecu.setText(prenom);
        loginRecu.setText(login);
        mdpRecu.setText(mdp);
        adresseRecu.setText(adresse);
        cpRecu.setText(cp);
        villeRecu.setText(ville);
        dateRecu.setText(date);

        VisiteurDAO visiteurAcces = new VisiteurDAO(this);


        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rId = idRecu.getText().toString();
                String rNom=nomRecu.getText().toString();
                String rPrenom=prenomRecu.getText().toString();
                String rLogin=loginRecu.getText().toString();
                String rMdp=mdpRecu.getText().toString();
                String rAdresse=adresseRecu.getText().toString();
                String rCp=cpRecu.getText().toString();
                String rVille=villeRecu.getText().toString();
                String rDate=dateRecu.getText().toString();


                Visiteur newVisiteur = new Visiteur(rId, rNom, rPrenom, rLogin, rMdp, rAdresse, rCp, rVille, rDate);
                String result = visiteurAcces.modifierVisiteurById(newVisiteur, idV);

                if (result.equals("1\r")) {
                    Context c = getApplicationContext();
                    Toast msg = Toast.makeText(c, "Veuillez saisir un nom pour ce visiteur.", Toast.LENGTH_LONG);
                    msg.show();
                    Intent i = new Intent(DetailsActivity.this, PropositionActivity.class);
                    startActivity(i);
                } else {
                    Context c = getApplicationContext();
                    Toast msg = Toast.makeText(c, "Votre visiteur a été modifiée.", Toast.LENGTH_LONG);
                    Intent i = new Intent(DetailsActivity.this, ConsultActivity.class);
                    startActivity(i);
                    msg.show();

                }
            }
        });

        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rId = idRecu.getText().toString();
                String rNom=nomRecu.getText().toString();
                String rPrenom=prenomRecu.getText().toString();
                String rLogin=loginRecu.getText().toString();
                String rMdp=mdpRecu.getText().toString();
                String rAdresse=adresseRecu.getText().toString();
                String rCp=cpRecu.getText().toString();
                String rVille=villeRecu.getText().toString();
                String rDate=dateRecu.getText().toString();


                Visiteur newVisiteur = new Visiteur(rId, rNom, rPrenom, rLogin, rMdp, rAdresse, rCp, rVille, rDate);
                String result = visiteurAcces.supprimerVisiteurById(newVisiteur, idV);

                if (result.equals("1\r")) {
                    Context c = getApplicationContext();
                    Toast msg = Toast.makeText(c, "Erreur !!!", Toast.LENGTH_LONG);
                    msg.show();
                    Intent i = new Intent(DetailsActivity.this, PropositionActivity.class);
                    startActivity(i);
                } else {
                    Context c = getApplicationContext();
                    Toast msg = Toast.makeText(c, "Votre visiteur a été supprimé.", Toast.LENGTH_LONG);
                    Intent i = new Intent(DetailsActivity.this, ConsultActivity.class);
                    startActivity(i);
                    msg.show();

                }
            }
        });
    }
}