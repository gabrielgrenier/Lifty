/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import dao.JourDAO;

/**
 *
 * @author gabri
 */
public class CreateHoraireAction extends AbstractAction {
    @Override
    public String execute() {
        try{
            JourDAO dao = new JourDAO();
            String idUser = request.getParameter("idCreateHoraire");
            
            //Lundi      
            String debLun = (request.getParameter("debLun") == null) ? "00" : request.getParameter("debLun");
            String finLun = (request.getParameter("finLun") == null) ? "00" : request.getParameter("finLun");

            //Mardi
            String debMar = (request.getParameter("debMar") == null) ? "00" : request.getParameter("debMar");
            String finMar = (request.getParameter("finMar") == null) ? "00" : request.getParameter("finMar");

            //Mercredi
            String debMer = (request.getParameter("debMer") == null) ? "00" : request.getParameter("debMer");
            String finMer = (request.getParameter("finMer") == null) ? "00" : request.getParameter("finMer");

            //Jeudi
            String debJeu = (request.getParameter("debJeu") == null) ? "00" : request.getParameter("debJeu");
            String finJeu = (request.getParameter("finJeu") == null) ? "00" : request.getParameter("finJeu");

            //Vendredi
            String debVen = (request.getParameter("debVen") == null) ? "00" : request.getParameter("debVen");
            String finVen = (request.getParameter("finVen") == null) ? "00" : request.getParameter("finVen");

            //Ajout dans la BD
            dao.create(0, Integer.parseInt(idUser), "lundi", (debLun+":00:00"), (finLun+":00:00"));
            dao.create(0, Integer.parseInt(idUser), "mardi", (debMar+":00:00"), (finMar+":00:00"));
            dao.create(0, Integer.parseInt(idUser), "mercredi", (debMer+":00:00"), (finMer+":00:00"));
            dao.create(0, Integer.parseInt(idUser), "jeudi", (debJeu+":00:00"), (finJeu+":00:00"));
            dao.create(0, Integer.parseInt(idUser), "vendredi", (debVen+":00:00"), (finVen+":00:00"));
            return "profil";
        }catch(NumberFormatException e){return "profil";}
    }
}
