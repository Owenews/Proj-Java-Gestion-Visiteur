package com.example.gestionvisiteur.modele;

public class Visiteur {
        private String id;
        private String nom;
        private String prenom;
        private String login;
        private String mdp;
        private String adresse;
        private String cp;
        private String ville;
        private String date;


        public Visiteur(String id, String nom, String prenom, String login, String mdp, String adresse, String cp, String ville, String date) {
            this.id = id;
            this.nom = nom;
            this.prenom = prenom;
            this.login = login;
            this.mdp = mdp;
            this.adresse = adresse;
            this.cp = cp;
            this.ville = ville;
            this.date = date;
        }
        public Visiteur(String nom, String prenom, String login, String mdp, String adresse, String cp, String ville, String date) {
            this.nom = nom;
            this.prenom = prenom;
            this.login = login;
            this.mdp = mdp;
            this.adresse = adresse;
            this.cp = cp;
            this.ville = ville;
            this.date = date;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getMdp() {
            return mdp;
        }

        public void setMdp(String mdp) {
            this.mdp = mdp;
        }

        public String getAdresse() {
            return adresse;
        }

        public void setAdresse(String adresse) {
            this.adresse = adresse;
        }

        public String getCp() {
            return cp;
        }

        public void setCp(String cp) {
            this.cp = cp;
        }

        public String getVille() {
            return ville;
        }

        public void setVille(String ville) {
            this.ville = ville;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    @Override
    public String toString() {
        return  (nom + "            " + prenom + "          " + id);
    }
}
