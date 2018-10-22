package controleurs;
/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class DeconnexionAction extends AbstractAction{

    @Override
    public String execute() {
        request.removeAttribute("connecte");
        return "accueil";
    }
    
}
