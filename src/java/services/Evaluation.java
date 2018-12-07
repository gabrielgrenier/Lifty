/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
/**
 *
 * @author usager
 */
public class Evaluation {
    float note;
    int etoilePleine;
    String chiffre;
    float restant;
    int etoileVide;

    public Evaluation(float f){
        this.note = f;
        this.chiffre = Character.toString(String.valueOf(f).charAt(0));
        this.etoilePleine = Integer.valueOf(this.chiffre);
        this.restant = (f % etoilePleine);
        this.etoileVide = 4-etoilePleine;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
        this.etoilePleine = Math.round(note);
        this.restant = (note % etoilePleine);
        this.etoileVide = 5-etoilePleine;
    }

    public int getEtoilePleine() {
        return etoilePleine;
    }

    public void setEtoilePleine(int etoilePleine) {
        this.etoilePleine = etoilePleine;
    }

    public float getRestant() {
        return restant;
    }

    public void setRestant(float restant) {
        this.restant = restant;
    }

    public int getEtoileVide() {
        return etoileVide;
    }

    public void setEtoileVide(int etoileVide) {
        this.etoileVide = etoileVide;
    }
    
}
