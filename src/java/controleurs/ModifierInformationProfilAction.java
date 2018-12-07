/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import classe.Profil;
import dao.ProfilDAO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author usager
 */
public class ModifierInformationProfilAction extends AbstractAction{

    @Override
    public String execute() {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("connected")==null) {//déjà non connecté
            return "accueil";
        }
        if(this.valide()){
            request.setAttribute("modInf","erreur");
            return "profil";
        }
        if(!request.getParameter("mdp").equals(request.getParameter("rmdp"))&&(!"".equals(request.getParameter("mdp"))&&!"".equals(request.getParameter("rmdp")))){
            request.setAttribute("erreurMdp2","Les deux mots de passes ne sont pas identique !");
            request.setAttribute("modInf","erreur");
            return "profil";
        }
        ProfilDAO pDao = new ProfilDAO();
        Profil p = (Profil) session.getAttribute("connected");
        if(request.getParameter("mdp").equals(request.getParameter("rmdp"))&&(!"".equals(request.getParameter("mdp"))&&!"".equals(request.getParameter("rmdp")))){
            p.setMotDePasse(request.getParameter("mdp"));
        }
        p.setCodePostal(request.getParameter("codePostal"));
        p.setEtablissement(request.getParameter("etablissement"));
        p.setNom(request.getParameter("nom"));
        p.setPrenom(request.getParameter("prenom"));
        p.setEmail(request.getParameter("email"));
        if("Conducteur".equals(request.getParameter("role"))){
            p.setConducteur(true);
        }
        else if("Passager".equals(request.getParameter("role"))){
            p.setConducteur(false);
        }
        session.setAttribute("connected",p);
        pDao.update(p);
        return "profil";
    }
    public boolean valide(){
        boolean valide = false;
        if(request.getParameter("email")== null ||request.getParameter("codePostal")== null ||request.getParameter("etablissement")== null 
        || request.getParameter("nom")== null || request.getParameter("prenom")== null || request.getParameter("mdp")== null||request.getParameter("rmdp")== null||request.getParameter("role")== null){
            valide = true;
        }
        if("".equals(request.getParameter("email"))){
            request.setAttribute("erreurEmail","Vous devez entrez un email valide !");
            valide = true;
        }
        if("".equals(request.getParameter("codePostal"))){
            request.setAttribute("erreurCode","Vous devez entrez un code postal valide !");
            valide = true;
        }
        if("".equals(request.getParameter("etablissement"))){
            request.setAttribute("erreurEta","Vous devez entrez un etablissement valide !");
            valide = true;
        }
        if("".equals(request.getParameter("nom"))){
            request.setAttribute("erreurNom","Vous devez entrez un nom valide !");
            valide = true;
        }
        if("".equals(request.getParameter("prenom"))){
            request.setAttribute("erreurPre","Vous devez entrez un prenom valide !");
            valide = true;
        }
        if((!"".equals(request.getParameter("mdp"))&&"".equals(request.getParameter("rmdp")))){
            request.setAttribute("erreurRmdp","Vous devez répéter le mote de passe !");
            valide = true;
        }
        if(("".equals(request.getParameter("mdp"))&&!"".equals(request.getParameter("rmdp")))){
            request.setAttribute("erreurMdp","Vous devez entrez un mot de passe avant !");
            valide = true;
        }
        
        return valide;
        
    }
        
}
