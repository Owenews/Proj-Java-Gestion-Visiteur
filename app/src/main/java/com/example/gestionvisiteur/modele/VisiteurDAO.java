package com.example.gestionvisiteur.modele;

import android.util.Log;
import android.view.View;

import com.example.gestionvisiteur.controlleur.AjoutActivity;
import com.example.gestionvisiteur.controlleur.ConsultActivity;
import com.example.gestionvisiteur.controlleur.DetailsActivity;
import com.example.gestionvisiteur.controlleur.MainActivity;
import com.example.gestionvisiteur.controlleur.ModifierActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class VisiteurDAO {

    public VisiteurDAO(AjoutActivity ajoutActivity) {
    }

    public VisiteurDAO(ConsultActivity consultActivity){
    }

    public VisiteurDAO(DetailsActivity detailsActivity){
    }

    public VisiteurDAO(View.OnClickListener mainActivity){
    }

    public VisiteurDAO(ModifierActivity modifierActivity){
    }



    // Fonction qui permet d'ajouter un visiteur
    public String addVisiteur(Visiteur unVisiteur) {
        String result = "";

        //adresse de l'URL de l\'API à interroger et fichier php permettant d'ajouter le visiteur
        String myUrl="https://sjpslam.alwaysdata.net/owen/API/addVisiteur.php";

        //informations à transmettre pour effectuer l'ajout
		String params =
                "id=" +unVisiteur.getId() + "\n"
                 + "&nom="+unVisiteur.getNom() + "\n"
                 + "&prenom="+unVisiteur.getPrenom( ) + "\n"
                 + "&login=" +unVisiteur.getLogin() + "\n"
                 + "&mdp="+unVisiteur.getMdp() + "\n"
                 + "&adresse="+unVisiteur.getAdresse() + "\n"
                 + "&cp="+unVisiteur.getCp() + "\n"
                 + "&ville="+unVisiteur.getVille() + "\n"
                 + "&dateEmbauche="+unVisiteur.getDate();
        Log.d("requete",params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //Log.d("resultat",result);
        return result;
    }

    // Foncion qui récupère une collection de visiteur
    public ArrayList<Visiteur> getVisiteurs() throws JSONException{

        String result = "";

        //adresse de l'URL de l'API à interroger et fichier php permettant d'afficher tous les visiteurs
        String myUrl="https://sjpslam.alwaysdata.net/owen/API/getVisiteurs.php";
        String params = "";
        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayList<Visiteur> visiteurs = new ArrayList<Visiteur>();
        JSONArray array = new JSONArray(result);
        for (int i=0; i<array.length();i++){
            String id=array.getJSONObject(i).getString("id");
            String nom=array.getJSONObject(i).getString("nom");
            String prenom=array.getJSONObject(i).getString("prenom");
            String login=array.getJSONObject(i).getString("login");
            String mdp=array.getJSONObject(i).getString("mdp");
            String adresse=array.getJSONObject(i).getString("adresse");
            String cp=array.getJSONObject(i).getString("cp");
            String ville=array.getJSONObject(i).getString("ville");
            String date=array.getJSONObject(i).getString("dateEmbauche");
            visiteurs.add(new Visiteur(id,nom,prenom,login,mdp,adresse,cp,ville,date));
        }
        return visiteurs;
    }
    
    public String modifierVisiteurById(Visiteur unVisiteur, String idV) {
        String result = "";
        Log.d("msgTest",result);
        String myUrl="https://sjpslam.alwaysdata.net/owen/API/modifVisiteurById.php";
        String params =
                "id="+ idV
                        +"&nom="+unVisiteur.getNom()+
                        "&prenom="+unVisiteur.getPrenom()+
                        "&login="+unVisiteur.getLogin()+
                        "&mdp="+unVisiteur.getMdp()+
                        "&adresse="+unVisiteur.getAdresse()+
                        "&cp="+unVisiteur.getCp()+
                        "&ville="+unVisiteur.getVille()+
                        "&dateEmbauche="+unVisiteur.getDate() ;

        Log.d("requete",params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String supprimerVisiteurById(Visiteur unVisiteur, String idV) {
        String result = "";
        String myUrl="https://sjpslam.alwaysdata.net/owen/API/supVisiteurById.php";
        String params =
                "id="+ idV
                        +"&nom="+unVisiteur.getNom()+
                        "&prenom="+unVisiteur.getPrenom()+
                        "&login="+unVisiteur.getLogin()+
                        "&mdp="+unVisiteur.getMdp()+
                        "&adresse="+unVisiteur.getAdresse()+
                        "&cp="+unVisiteur.getCp()+
                        "&ville="+unVisiteur.getVille()+
                        "&dateEmbauche="+unVisiteur.getDate() ;

        Log.d("requete",params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}
