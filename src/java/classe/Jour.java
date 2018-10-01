/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD:web/modele/classes/com/mchausse/lifty/Jour.java
package modele.classes.com.mchausse.lifty;
=======
package classe;
>>>>>>> origin:src/java/classe/Jour.java

/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class Jour {
    // ==== VARIABLES ====
    private int id,
            userId;      // id de l'utilisateur
    private String jour, // nom du jour de la semaine
            debut       // l'heure de debut du cours
            ,fin;       // l'heure de fin du cour
    
    // ==== CONSTRUCTEUR ====
    public Jour(int id, int userId, String jour, String debut, String fin){
        this.id = id;
        this.userId = userId;
        this.jour = jour;
        this.debut = debut;
        this.fin = fin;
    }
     public Jour(){
        this.id = 0;
        this.userId = 0;
        this.jour = "";
        this.debut = "";
        this.fin = "";
    }
    
    // ==== GETTERS ====
    public int getId(){return id;}
    public String getDebut() {return debut;}
    public String getFin() {return fin;}
    public int getUserId(){return userId;}
    public String getJour() {return jour;}
    
    // ==== SETTERS ====
    public void setId(int id){this.id = id;}
    public void setDebut(String debut) {this.debut = debut;}
    public void setFin(String fin) {this.fin = fin;}
    public void setUserID(int id){this.userId = id;}
    public void setJour(String jour){this.jour = jour;}
}
