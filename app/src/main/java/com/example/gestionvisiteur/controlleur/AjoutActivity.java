package com.example.gestionvisiteur.controlleur;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

public class AjoutActivity extends Activity {
    Button ajoutValider;
    EditText unId, unNom, unPrenom, unLogin, unMdp, uneAdresse, unCp, uneVille, uneDate;
    String id, nom, prenom, login, mdp, adresse, cp, ville, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

    unId = findViewById(R.id.editTextId);
    unNom = findViewById(R.id.editTextNom);
    unPrenom = findViewById(R.id.editTextPre);
    unLogin = findViewById(R.id.editTextLogin);
    unMdp = findViewById(R.id.editTextMdp);
    uneAdresse = findViewById(R.id.editTextAdRue);
    unCp = findViewById(R.id.editTextCP);
    uneVille = findViewById(R.id.editTextVille);
    uneDate = findViewById(R.id.editTextDate);
    ajoutValider = findViewById(R.id.btnValiderAjout);

    VisiteurDAO visiteurAcces = new VisiteurDAO(this);




        ajoutValider.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         id = unId.getText().toString();
         nom = unNom.getText().toString();
         prenom = unPrenom.getText().toString();
         login = unLogin.getText().toString();
         mdp = unMdp.getText().toString();
         adresse = uneAdresse.getText().toString();
         cp = unCp.getText().toString();
         ville = uneVille.getText().toString();
         date = uneDate.getText().toString();

            Visiteur newVisiteur = new Visiteur(id, nom, prenom, login, mdp, adresse, cp, ville, date);
            visiteurAcces.addVisiteur(newVisiteur);

            String result = "";
            if(result.equals("1\r")){
                Context c = getApplicationContext();
                Toast msg = Toast.makeText(c, "ERREUR : Echech de l'ajout du client !", Toast.LENGTH_LONG);
                msg.show();
                Intent i = new Intent(AjoutActivity.this, PropositionActivity.class);
                startActivity(i);
            } else {
                Context c = getApplicationContext();
                Toast msg = Toast.makeText(c, "Le client a bien été ajouté !", Toast.LENGTH_LONG);
                msg.show();

            }
        }


    });



}


    /*private void modifierNiveau() {
        VisiteurDAO visiteurAcces = new VisiteurDAO(this);
        Visiteur newVisiteur2 = new Visiteur(unId.getText().toString(), unNom.getText().toString(), unPrenom.getText().toString(), unLogin.getText().toString(), unMdp.getText().toString(), uneAdresse.getText().toString(), unCp.getText().toString(), uneVille.getText().toString(), uneDate.getText().toString());
        visiteurAcces.addVisiteur(newVisiteur2);
    }*/
}
