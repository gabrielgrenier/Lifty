/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mchausse.lifty;

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
    
    // ==== GETTERS ====
    public int getId(){return id;}
    public String getDebut() {return debut;}
    public String getFin() {return fin;}
    
    // ==== SETTERS ====
    public void setId(int id){this.id = id;}
    public void setDebut(String debut) {this.debut = debut;}
    public void setFin(String fin) {this.fin = fin;}
}
