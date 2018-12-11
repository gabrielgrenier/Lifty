
package controleurs;

import javax.servlet.http.HttpSession;

/* ==== INFO ====

 * @author maxime chausse
 * date : 14 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class RechercheAction extends AbstractAction{

    @Override
    public String execute() {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("connected")==null) {//déjà non connecté
            return "accueil";
        }
        return "recherche";
    }
    
}
