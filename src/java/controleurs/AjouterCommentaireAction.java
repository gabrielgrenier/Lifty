/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import classe.Critique;
import classe.Profil;
import dao.CritiqueDAO;
import dao.ProfilDAO;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author usager
 */
public class AjouterCommentaireAction extends AbstractAction{
    @Override
    public String execute() {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("connected")==null) {//déjà non connecté
            return "accueil";
        }
        request.setAttribute("userC",request.getParameter("user"));
        if(this.valide()){
            request.setAttribute("Commentaire","add");
            return "profil";
        }
        request.setAttribute("Commentaire","");
        Critique c = new Critique();
        CritiqueDAO cDao = new CritiqueDAO();
        Profil p;
        ProfilDAO pDao = new ProfilDAO();
        c.setCommentaire(request.getParameter("commentaire"));
        c.setDislike(0);
        c.setLike(0);
        c.setEnvoyeurID(Integer.valueOf(request.getParameter("envoyeur")));
        c.setReceveurID(Integer.valueOf(request.getParameter("receveur")));
        c.setNote(Float.valueOf(request.getParameter("evaluation")));
        cDao.create(c);
        List<Critique> listeCritique = cDao.findByIdUserReceveur(Integer.valueOf(request.getParameter("receveur")));
        double notes=0;
        if (listeCritique.size() > 0){
            notes = listeCritique.stream().map((cri) -> cri.getNote()).reduce(notes, (accumulator, _item) -> accumulator + _item);
            notes = notes/listeCritique.size();
        }
        p = pDao.findById(Integer.valueOf(request.getParameter("receveur")));
        p.setRating(notes);
        pDao.update(p);
        
        return "profil";
    }
     public boolean valide(){
        if(request.getParameter("commentaire")==null||request.getParameter("evaluation")==null){
            request.setAttribute("erreurEmail","Vous devez entrez un email valide !");
            return true;
        }
        if("".equals(request.getParameter("evaluation"))){
            request.setAttribute("erreurEv","Vous devez entrez un evaluation valide !");
            return true;
        }
        if(!(Float.valueOf(request.getParameter("evaluation"))<=5 && Float.valueOf(request.getParameter("evaluation"))>=0)){
            request.setAttribute("erreurEv","Vous devez entrez un evaluation valide !");
            return true;
        }
        if("".equals(request.getParameter("commentaire"))){
            request.setAttribute("erreurCom","Vous devez entrez un commentaire valide !");
            return true;
        }
        return false;
        
    }
}
