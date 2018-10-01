/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class Horaire {
    // ==== VARIABLES ====
    private Jour[] semaine = new Jour[7];

    // ==== CONSTRUCTEUR ====
    public Horaire(Jour j0, Jour j1, Jour j2, Jour j3, Jour j4, Jour j5, Jour j6){
        this.semaine[0] = j0;
        this.semaine[1] = j1;
        this.semaine[2] = j2;
        this.semaine[3] = j3;
        this.semaine[4] = j4;
        this.semaine[5] = j5;
        this.semaine[6] = j6;
    }
    
    public Horaire(Jour[] j){
        for(int i=0;i<7;i++)this.semaine[i]=j[i];
    }
    
    // ==== GETTERS ====
    public Jour getLundi() {return this.semaine[0];}
    public Jour getMardi() {return this.semaine[1];}
    public Jour getMercredi() {return this.semaine[2];}
    public Jour getJeudi() {return this.semaine[3];}
    public Jour getVendredi() {return this.semaine[4];}
    public Jour getSamedi() {return this.semaine[5];}
    public Jour getDimanche() {return this.semaine[6];}
    
    // ==== SETTERS ====
    public void setLundi(Jour l) {this.semaine[0] = l;}
    public void setMardi(Jour ma) {this.semaine[1] = ma;}
    public void setMercredi(Jour mr) {this.semaine[2] = mr;}
    public void setJeudi(Jour j) {this.semaine[3] = j;}
    public void setVendredi(Jour v) {this.semaine[4] = v;}
    public void setSamedi(Jour s) {this.semaine[5] = s;}
    public void setDimanche(Jour d) {this.semaine[6] = d;}
}
