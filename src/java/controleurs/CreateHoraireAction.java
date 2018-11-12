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
        JourDAO dao = new JourDAO();
        String idUser = request.getParameter("idCreateHoraire");
        String debLun = request.getParameter("debLun");
        String finLun = request.getParameter("finLun");
        
        
        dao.create(0, Integer.parseInt(idUser), "Lundi", (debLun+":00:00"), (finLun+":00:00"));
        
        return "profil";
    }
}
