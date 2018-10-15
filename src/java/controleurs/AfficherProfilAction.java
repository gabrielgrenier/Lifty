/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

/**
 *
 * @author usager
 */
public class AfficherProfilAction extends AbstractAction{
    @Override
    public String execute() {
        request.setAttribute("connecte",""+1);
        return "profil";
    }
}
