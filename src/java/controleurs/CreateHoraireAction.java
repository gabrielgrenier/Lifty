/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import classe.Avertissement;
import classe.Jour;
import classe.Profil;
import dao.JourDAO;

/**
 *
 * @author gabri
 */
public class CreateHoraireAction extends AbstractAction {
    @Override
    public String execute() {
        try{
            JourDAO jourDao = new JourDAO();
            Profil currentUser = (Profil)request.getSession().getAttribute("connected");
            
            //Lundi
            String debLun = (request.getParameter("debLun") == null) ? "00" : request.getParameter("debLun");
            String finLun = (request.getParameter("finLun") == null) ? "00" : request.getParameter("finLun");
            Jour lundi = jourDao.find(currentUser.getId(), "lundi");
            if(Integer.parseInt(debLun) >=Integer.parseInt(finLun) && !"00".equals(debLun) && !"00".equals(finLun)){
                //Msg d'ereur
                Avertissement aver = new Avertissement("L'heure de début de lundi doit être inférieur à l'heure de fin.", "erreur");
                request.getSession().setAttribute("avertissement", aver);
                return "CreateHoraire";
            }
            else if(lundi==null){
                jourDao.create(0, currentUser.getId(), "lundi", (debLun+":00:00"), (finLun+":00:00"));
            }
            else{
                lundi.setDebut(debLun+":00:00");
                lundi.setFin(finLun+":00:00");
                jourDao.update(lundi);
            }
            //Mardi
            String debMar = (request.getParameter("debMar") == null) ? "00" : request.getParameter("debMar");
            String finMar = (request.getParameter("finMar") == null) ? "00" : request.getParameter("finMar");
            Jour mardi = jourDao.find(currentUser.getId(), "mardi");
            if(Integer.parseInt(debMar) >=Integer.parseInt(finMar) && !"00".equals(debMar) && !"00".equals(finMar)){
                //Msg d'ereur
                Avertissement aver = new Avertissement("L'heure de début de mardi doit être inférieur à l'heure de fin.", "erreur");
                request.getSession().setAttribute("avertissement", aver);
                return "CreateHoraire";
            }
            else if(mardi==null){
                jourDao.create(0, currentUser.getId(), "mardi", (debMar+":00:00"), (finMar+":00:00"));
            }
            else{
                mardi.setDebut(debMar+":00:00");
                mardi.setFin(finMar+":00:00");
                jourDao.update(mardi);
            }

            //Mercredi
            String debMer = (request.getParameter("debMer") == null) ? "00" : request.getParameter("debMer");
            String finMer = (request.getParameter("finMer") == null) ? "00" : request.getParameter("finMer");
            Jour mercredi = jourDao.find(currentUser.getId(), "mercredi");
            if(Integer.parseInt(debMer) >=Integer.parseInt(finMer) && !"00".equals(debMer) && !"00".equals(finMer)){
                //Msg d'ereur
                Avertissement aver = new Avertissement("L'heure de début de mercredi doit être inférieur à l'heure de fin.", "erreur");
                request.getSession().setAttribute("avertissement", aver);
                return "CreateHoraire";
            }
            else if(mercredi==null){
                jourDao.create(0, currentUser.getId(), "mercredi", (debMer+":00:00"), (finMer+":00:00"));
            }
            else{
                mercredi.setDebut(debMer+":00:00");
                mercredi.setFin(finMer+":00:00");
                jourDao.update(mercredi);
            }

            //Jeudi
            String debJeu = (request.getParameter("debJeu") == null) ? "00" : request.getParameter("debJeu");
            String finJeu = (request.getParameter("finJeu") == null) ? "00" : request.getParameter("finJeu");
            Jour jeudi = jourDao.find(currentUser.getId(), "jeudi");  
            if(Integer.parseInt(debJeu) >=Integer.parseInt(finJeu) && !"00".equals(debJeu) && !"00".equals(finJeu)){
                //Msg d'ereur
                Avertissement aver = new Avertissement("L'heure de début de jeudi doit être inférieur à l'heure de fin.", "erreur");
                request.getSession().setAttribute("avertissement", aver);
                return "CreateHoraire";
            }
            else if(jeudi==null){
                jourDao.create(0, currentUser.getId(), "jeudi", (debJeu+":00:00"), (finJeu+":00:00"));
            }
            else{
                jeudi.setDebut(debJeu+":00:00");
                jeudi.setFin(finJeu+":00:00");
                jourDao.update(jeudi);
            }

            //Vendredi
            String debVen = (request.getParameter("debVen") == null) ? "00" : request.getParameter("debVen");
            String finVen = (request.getParameter("finVen") == null) ? "00" : request.getParameter("finVen");
            Jour vendredi = jourDao.find(currentUser.getId(), "vendredi");
            if(Integer.parseInt(debVen) >=Integer.parseInt(finVen)&& !"00".equals(debVen) && !"00".equals(finVen) ){
                //Msg d'ereur
                Avertissement aver = new Avertissement("L'heure de début de vendredi doit être inférieur à l'heure de fin.", "erreur");
                request.getSession().setAttribute("avertissement", aver);
                return "CreateHoraire";
            }
            else if(vendredi==null){
                jourDao.create(0, currentUser.getId(), "vendredi", (debVen+":00:00"), (finVen+":00:00"));
            }
            else{
                vendredi.setDebut(debVen+":00:00");
                vendredi.setFin(finVen+":00:00");
                jourDao.update(vendredi);
            }
            return "profil";
        }catch(NumberFormatException e){return "recherche";}
    }
}
