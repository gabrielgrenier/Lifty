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
public class AjouterCommentaireAction extends AbstractAction{
    @Override
    public String execute() {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("connected")==null) {//déjà non connecté
            return "accueil";
        }
        request.setAttribute("user",request.getParameter("user"));
        request.setAttribute("Commentaire","add");
        return "profil";
    }
}
