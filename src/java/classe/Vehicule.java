<<<<<<< HEAD:web/modele/classes/com/mchausse/lifty/Vehicule.java
package modele.classes.com.mchausse.lifty;
=======
package classe;
>>>>>>> origin:src/java/classe/Vehicule.java
/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class Vehicule {
    /* ==== VARIABLES ====
    id      : le id de la voiture associée au conducteur
    nbPlace : nombre de place dans le véhicule
    modele  : modele du véhicule
    annee   : année du véhicule
    couleur : couleur du véhicule
    fumeur  : true le conducteur est un fumeur
    */
    private int id, nbPlace;
    private String modele,
            annee,
            couleur;
    private boolean fumeur;

   // ==== CONSTRUCTEURS ====
    public Vehicule(int id, int nbPlace, String modele, String annee, String couleur, boolean fumeur) {
        this.id = id;
        this.nbPlace = nbPlace;
        this.modele = modele;
        this.annee = annee;
        this.couleur = couleur;
        this.fumeur = fumeur;
    }
    
    // ==== GETTERS====
    public String getAnnee() {return annee;}
    public String getCouleur() {return couleur;}
    public int getId() {return id;}
    public String getModele() {return modele;}
    public int getNbPlace() {return nbPlace;}
    public boolean isFumeur() {return fumeur;}
    
    // ==== SETTERS ====
    public void setId(int id) {this.id = id;}
    public void setNbPlace(int nbPlace) {this.nbPlace = nbPlace;}
    public void setModele(String modele) {this.modele = modele;}
    public void setAnnee(String annee) {this.annee = annee;}
    public void setCouleur(String couleur) {this.couleur = couleur;}
    public void setFumeur(boolean fumeur) {this.fumeur = fumeur;}
}
