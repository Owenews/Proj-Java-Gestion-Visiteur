package com.example.gestionvisiteur.controlleur;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

import org.json.JSONException;

import java.util.ArrayList;

public class ModifierActivity extends AppCompatActivity {
    private Spinner choixV;
    private ArrayList<Visiteur> lesVisiteurs;
    private EditText txtId,txtNom,txtPrenom,txtLogin,txtMdp,txtAdresse,txtCP,txtVille,txtDateE;
    private Visiteur leVisiteur;
    private Button boutonModif;
    private VisiteurDAO unVisiteurDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);

        unVisiteurDAO=new VisiteurDAO(this);

        lesVisiteurs = new ArrayList<Visiteur>();

        try {
            lesVisiteurs=unVisiteurDAO.getVisiteurs();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        choixV = (Spinner) findViewById(R.id.spinner);

        boutonModif=(Button) findViewById(R.id.btnValiderAjout);

        txtNom = findViewById(R.id.editTextNom);
        txtPrenom = findViewById(R.id.editTextPre);
        txtLogin = findViewById(R.id.editTextLogin);
        txtMdp = findViewById(R.id.editTextMdp);
        txtAdresse = findViewById(R.id.editTextAdRue);
        txtCP = findViewById(R.id.editTextCP);
        txtVille = findViewById(R.id.editTextVille);
        txtDateE = findViewById(R.id.editTextDate);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lesVisiteurs);

        choixV.setAdapter(adapter);
        txtNom.setText(lesVisiteurs.get(0).getNom());
        txtPrenom.setText(lesVisiteurs.get(0).getPrenom());
        txtLogin.setText(lesVisiteurs.get(0).getLogin());
        txtMdp.setText(lesVisiteurs.get(0).getMdp());
        txtAdresse.setText(lesVisiteurs.get(0).getAdresse());
        txtCP.setText(lesVisiteurs.get(0).getCp());
        txtVille.setText(lesVisiteurs.get(0).getVille());
        txtDateE.setText(lesVisiteurs.get(0).getDate());

        choixV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                leVisiteur = (Visiteur) adapterView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "ID: " + leVisiteur.getId() + "\nName: " + leVisiteur.getPrenom(), Toast.LENGTH_SHORT).show();

                actualiser(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        boutonModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModifierActivity.this, ConsultActivity.class);
                String resId=leVisiteur.getId().toString();
                String resNom = txtNom.getText().toString();
                Log.i("nouveau nom",resNom);
                String resPrenom = txtPrenom.getText().toString();
                String resLogin=txtLogin.getText().toString();
                String resMdp=txtMdp.getText().toString();
                String resAdresse = txtAdresse.getText().toString();
                String resCP = txtCP.getText().toString();
                String resVille = txtVille.getText().toString();
                String resDateE = txtDateE.getText().toString();

                Visiteur leNouveauVisiteur = new Visiteur(resNom, resPrenom, resLogin,resMdp,resAdresse, resCP, resVille, resDateE);

                String result = unVisiteurDAO.modifierVisiteurById(leNouveauVisiteur,resId);
                if (result.equals("1\r")) {
                    Toast.makeText(getApplicationContext(),"Echec de la modification !",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Modification réussi !",Toast.LENGTH_LONG).show();
                }

                startActivity(intent);

            }

        });
    }


    public void actualiser(int position){
        /*   txtId.setText(leVisiteur.getId());*/
        txtNom.setText(lesVisiteurs.get(position).getNom());
        txtPrenom.setText(lesVisiteurs.get(position).getPrenom());
        txtLogin.setText(lesVisiteurs.get(position).getLogin());
        txtMdp.setText(lesVisiteurs.get(position).getMdp());
        txtAdresse.setText(lesVisiteurs.get(position).getAdresse());
        txtCP.setText(lesVisiteurs.get(position).getCp());
        txtVille.setText(lesVisiteurs.get(position).getVille());
        txtDateE.setText(lesVisiteurs.get(position).getDate());
    }
}
