/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classe.Profil;
import dao.ProfilDAO;
import java.util.List;

/**
 *
 * @author Samuel
 */
public class rechercheService {
    public static List<Profil> rechercheUsername() {
        ProfilDAO pDao = new ProfilDAO();
        List<Profil> listProfil = pDao.findAll();
        return listProfil;
    }
    
    public static List<Profil> ListeUserAround(String etablissement, boolean conducteur) {
        ProfilDAO pDao = new ProfilDAO();
        List<Profil> listProfil = pDao.findAll(etablissement, conducteur);
        return listProfil;
    }
}
