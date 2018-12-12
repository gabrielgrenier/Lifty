/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import javax.servlet.http.HttpSession;

/**
 *
 * @author usager
 */
public class AfficherProfilAction extends AbstractAction{
    @Override
    public String execute() {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("connected")==null) {//déjà non connecté
            return "accueil";
        }
        if (request.getParameter("user")!=null){
            request.setAttribute("userC",request.getParameter("user"));
        }
        return "profil";
    }
}
