/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import classe.Profil;
import dao.ProfilDAO;
import java.time.LocalDate;
import java.time.ZoneId;
/**
 *
 * @author Samuel
 */
public class InscriptionAction extends AbstractAction {

    @Override
    public String execute() {
        if(request.getParameter("prenomInsc")!=null && request.getParameter("nomInsc")!=null && request.getParameter("emailInsc")!=null && request.getParameter("codePInsc")!=null && request.getParameter("pwdInsc")!=null && request.getParameter("pwdConfInsc")!=null && request.getParameter("type")!=null){
            LocalDate now = LocalDate.now( ZoneId.of( "America/Montreal" ) ) ;
            int id = 0,
            role = 2;
            String username = ""+request.getParameter("prenomInsc").substring(0,0)+request.getParameter("nomInsc").substring(0,2)+"",
            email = request.getParameter("emailInsc"),
            nom = request.getParameter("nomInsc"),
            prenom = request.getParameter("prenomInsc"),        
            motDePasse = request.getParameter("pswInsc"),
            dateInscription = now.toString(),
            dateConnexion = now.toString(),
            codePostal = request.getParameter("codePInsc");
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
            Profil p;
            p = pDao.findByEmail(email);
            if(p==null){
                p = new Profil(id,username,email,nom,prenom,motDePasse,role,dateInscription,dateConnexion,codePostal,null,null,isPublicNom,isPublicPrenom,isPublicEmail,isValide,isConducteur,rating,tarif,rayon);
                pDao.create(p);
                return "recherche";
            }
            else{return "accueil";}
        }
        else{
            return "accueil";
        }
    }
}
