/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

/**
 *
 * @author mchausse
 */
public class DeconnexionAction extends AbstractAction{

    @Override
    public String execute() {
        request.removeAttribute("connecte");
        return "accueil";
    }
    
}
