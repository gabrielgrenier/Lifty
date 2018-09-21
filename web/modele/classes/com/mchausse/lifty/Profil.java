
package modele.classes.com.mchausse.lifty;

/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
 */
public class Profil {
    /* ==== VARIABLES ====
    - strings -
    id              : numéro du profil
    email           : email du profil
    nom             : nom de la personne
    prenom          : prénom de la personne
    dateInscription : la date d'inscription de la personne. Elle ne peut pas être modifiée
    dateConnexion   : la date de la dernière connexion de l'utilisateur
    codePostal      : le code postal de la personne
    etablissement   : nom de l'étalissement que ou lutilisateur va
    imageProfil     : chemin vers l'image de profil
    
    - boolean -
    conducteur    : 0-passager, 1-conducteur
    nomPublic     : true si l'utilisateur accepte d'afficher son nom sur son profil
    isPublicprenom  : true si l'utilisateur accepte d'afficher son prénom sur son profil
    isPublicprenom  : true si l'utilisateur accepte d'afficher son adresse couriel sur son profil
    valide        : true si le compte a été validé par un administrateur
    
    - double -
    rating          : moyenne des notes laissées sur le profil
    tarif           : montant d'argent demandé par les conducteur ou souhaité par les passagés
    rayon           : distance en mètre utilisé pour trouver les clients dans le rayon de leur location
    
    - int -
    role            : 0-Administrateur; 1-Modérateur; 2-Utilisateur
    */
    private int id,role;
    private String email,nom,prenom,dateInscription,dateConnexion,codePostal,etablissement,imageProfil;
    private boolean nomPublic,prenomPublic,emailPublic,valide,conducteur; 
    private double rating,tarif,rayon;
    private Vehicule vehicule;
    
    // ==== CONSTRUCTEURS ====
    // - complet -
    public Profil(int id, int role, String email, String nom, String prenom, String dateInscription, String dateConnexion, String codePostal, String etablissement, String imageProfil, boolean isPublicNom, boolean isPublicPrenom, boolean isPublicEmail, boolean isValide, boolean isConducteur, double rating, double tarif, double rayon, Horaire horaire, Vehicule vehicule) {
        this.id = id;    
        this.role = role;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscription = dateInscription;
        this.dateConnexion = dateConnexion;
        this.codePostal = codePostal;
        this.etablissement = etablissement;
        this.imageProfil = imageProfil;
        this.nomPublic = isPublicNom;
        this.prenomPublic = isPublicPrenom;
        this.emailPublic = isPublicEmail;
        this.valide = isValide;
        this.conducteur = isConducteur;
        this.rating = rating;
        this.tarif = tarif;
        this.rayon = rayon;
        this.vehicule = vehicule;
    }
    // - sans vehicule -
    public Profil(int id, int role, String email, String nom, String prenom, String dateInscription, String dateConnexion, String codePostal, String etablissement, String imageProfil, boolean isPublicNom, boolean isPublicPrenom, boolean isPublicEmail, boolean isValide, boolean isConducteur, double rating, double tarif, double rayon, Horaire horaire) {
        this.id = id;    
        this.role = role;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscription = dateInscription;
        this.dateConnexion = dateConnexion;
        this.codePostal = codePostal;
        this.etablissement = etablissement;
        this.imageProfil = imageProfil;
        this.nomPublic = isPublicNom;
        this.prenomPublic = isPublicPrenom;
        this.emailPublic = isPublicEmail;
        this.valide = isValide;
        this.conducteur = isConducteur;
        this.rating = rating;
        this.tarif = tarif;
        this.rayon = rayon;
    }
    // - sans vehicule et horaire -
        public Profil(int id, int role, String email, String nom, String prenom, String dateInscription, String dateConnexion, String codePostal, String etablissement, String imageProfil, boolean isPublicNom, boolean isPublicPrenom, boolean isPublicEmail, boolean isValide, boolean isConducteur, double rating, double tarif, double rayon) {
        this.id = id;    
        this.role = role;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscription = dateInscription;
        this.dateConnexion = dateConnexion;
        this.codePostal = codePostal;
        this.etablissement = etablissement;
        this.imageProfil = imageProfil;
        this.nomPublic = isPublicNom;
        this.prenomPublic = isPublicPrenom;
        this.emailPublic = isPublicEmail;
        this.valide = isValide;
        this.conducteur = isConducteur;
        this.rating = rating;
        this.tarif = tarif;
        this.rayon = rayon;
    }
    // - sans vehicule, horaire, rayon-
        public Profil(int id, int role, String email, String nom, String prenom, String dateInscription, String dateConnexion, String codePostal, String etablissement, String imageProfil, boolean isPublicNom, boolean isPublicPrenom, boolean isPublicEmail, boolean isValide, boolean isConducteur, double rating, double tarif) {
        this.id = id;    
        this.role = role;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscription = dateInscription;
        this.dateConnexion = dateConnexion;
        this.codePostal = codePostal;
        this.etablissement = etablissement;
        this.imageProfil = imageProfil;
        this.nomPublic = isPublicNom;
        this.prenomPublic = isPublicPrenom;
        this.emailPublic = isPublicEmail;
        this.valide = isValide;
        this.conducteur = isConducteur;
        this.rating = rating;
        this.tarif = tarif;
    }    
    // - sans vehicule, horaire, rayon, tarif-
        public Profil(int id, int role, String email, String nom, String prenom, String dateInscription, String dateConnexion, String codePostal, String etablissement, String imageProfil, boolean isPublicNom, boolean isPublicPrenom, boolean isPublicEmail, boolean isValide, boolean isConducteur, double rating) {
        this.id = id;    
        this.role = role;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscription = dateInscription;
        this.dateConnexion = dateConnexion;
        this.codePostal = codePostal;
        this.etablissement = etablissement;
        this.imageProfil = imageProfil;
        this.nomPublic = isPublicNom;
        this.prenomPublic = isPublicPrenom;
        this.emailPublic = isPublicEmail;
        this.valide = isValide;
        this.conducteur = isConducteur;
        this.rating = rating;
    }
    // - sans vehicule, horaire, rayon, tarif, rating-
    public Profil(int id, int role, String email, String nom, String prenom, String dateInscription, String dateConnexion, String codePostal, String etablissement, String imageProfil, boolean isPublicNom, boolean isPublicPrenom, boolean isPublicEmail, boolean isValide, boolean isConducteur) {
        //this(id,role,email,nom,prenom,dateInscription,dateConnexion,codePostal,etablissement,imageProfil)
        this.id = id;    
        this.role = role;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscription = dateInscription;
        this.dateConnexion = dateConnexion;
        this.codePostal = codePostal;
        this.etablissement = etablissement;
        this.imageProfil = imageProfil;
        this.nomPublic = isPublicNom;
        this.prenomPublic = isPublicPrenom;
        this.emailPublic = isPublicEmail;
        this.valide = isValide;
        this.conducteur = isConducteur;
    }
    // ==== GETTERS ====
    // - String -
    public String getCodePostal() {return codePostal;}
    public String getDateConnexion() {return dateConnexion;}
    public String getDateInscription() {return dateInscription;}
    public String getEmail() {return email;}
    public String getEtablissement() {return etablissement;}
    public String getImageProfil() {return imageProfil;}
    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    
    // - int -
    public int getId() {return id;}
    public int getRole() {return role;}
    
    // - double -
    public double getRating() {return rating;}
    public double getRayon() {return rayon;}
    public double getTarif() {return tarif;}
    
    // - boolean -
    public boolean isConducteur() {return conducteur;}
    public boolean isPublicEmail() {return emailPublic;}
    public boolean isNomPublic() {return nomPublic;}
    public boolean isPublicPrenom() {return prenomPublic;}
    public boolean isValide() {return valide;}
    
    // - objets -
    public Vehicule getVehicule(){return vehicule;}
    
    // ==== SETTERS ====
    public void setCodePostal(String codePostal) {this.codePostal = codePostal;}
    public void setDateInscription(String dateInscription) {this.dateInscription = dateInscription;}
    public void setDateConnexion(String dateConnexion) {this.dateConnexion = dateConnexion;}
    public void setEmail(String email) {this.email = email;}
    public void setEtablissement(String etablissement) {this.etablissement = etablissement;}
    public void setId(int id) {this.id = id;}
    public void setImageProfil(String imageProfil) {this.imageProfil = imageProfil;}
    public void setConducteur(boolean conducteur) {this.conducteur = conducteur;}
    public void setNomPublic(boolean nomPublic) {this.nomPublic = nomPublic;}
    public void setPrenomPublic(boolean prenomPublic) {this.prenomPublic = prenomPublic;}
    public void setEmailPublic(boolean emailPublic) {this.emailPublic = emailPublic;}
    public void setValide(boolean valide) {this.valide = valide;}
    public void setNom(String nom) {this.nom = nom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public void setRating(double rating) {this.rating = rating;}
    public void setRole(int role) {this.role = role;}
    public void setRayon(double rayon) {this.rayon = rayon;}
    public void setTarif(double tarif) {this.tarif = tarif;}
    public void setVehicule(Vehicule vehicule){this.vehicule = vehicule;}
}
