/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import classe.Profil;
import dao.JourDAO;
import dao.ProfilDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Samuel
 */
public class InscriptionAction extends AbstractAction {

    @Override
    public String execute() {
        if(request.getParameter("prenomInsc")!=null && request.getParameter("nomInsc")!=null && request.getParameter("emailInsc")!=null && request.getParameter("codePInsc")!=null && request.getParameter("pwdInsc")!=null && request.getParameter("pwdConfInsc")!=null && request.getParameter("type")!=null){
            if(!request.getParameter("pwdInsc").equals(request.getParameter("pwdConfInsc"))){badPwd(); return "accueil";}
            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            int id = 0,
            role = 2;
            String username,
            email = request.getParameter("emailInsc"),
            nom = request.getParameter("nomInsc"),
            prenom = request.getParameter("prenomInsc"),        
            motDePasse = request.getParameter("pwdInsc"),
            dateInscription = sm.format(new Date()),
            dateConnexion = sm.format(new Date()),
            codePostal = request.getParameter("codePInsc"),
            imageProfil = "./static/images/profils/default.png";
            if(request.getParameter("nomInsc").length()>=3){username = ""+request.getParameter("prenomInsc").substring(0,2)+request.getParameter("nomInsc").substring(0,3)+"";}
            else{username = ""+request.getParameter("prenomInsc").substring(0,2)+request.getParameter("nomInsc").substring(0,2)+"";}
            boolean isPublicNom = false,
            isPublicPrenom = false,
            isPublicEmail =false,
            isValide = false,
            isConducteur;
            if("condInsc".equals(request.getParameter("type"))){isConducteur = true;}
            else{isConducteur = false;}
            double rating = 5,
            tarif = 0,
            rayon = 0;
            ProfilDAO pDao = new ProfilDAO();
            JourDAO jDao = new JourDAO();
            Profil p;
            p = pDao.findByEmail(email);
            if(p==null){
                p = new Profil(id,username,email,nom,prenom,motDePasse,role,dateInscription,dateConnexion,codePostal,null,imageProfil,isPublicNom,isPublicPrenom,isPublicEmail,isValide,isConducteur,rating,tarif,rayon);
                pDao.create(p);
                p = pDao.findByEmail(email);
                //Creation des jours
                jDao.create(0, p.getId(), "lundi", "00:00:00", "00:00:00");
                jDao.create(0, p.getId(), "mardi", "00:00:00", "00:00:00");
                jDao.create(0, p.getId(), "mercredi", "00:00:00", "00:00:00");
                jDao.create(0, p.getId(), "jeudi", "00:00:00", "00:00:00");
                jDao.create(0, p.getId(), "vendredi", "00:00:00", "00:00:00");
                request.setAttribute("connecte",""+p.getId());
                return "recherche";
            }
            else{emailExistant(); return "accueil";}
        }
        else{
            return "accueil";
        }
    }
    
    private void badPwd(){request.setAttribute("err"," Mot de passe incorrect ");}
    private void emailExistant(){request.setAttribute("err"," Courriel déjà en usage ");}
}
