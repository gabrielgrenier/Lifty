
package controleurs;
/* ==== INFO ====

 * @author maxime chausse
 * date : 14 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class RechercheAction extends AbstractAction{

    @Override
    public String execute() {
        // IMPLEMENTER LA VERIFICATION DE CONNECTION
        if(request.getParameter("connecte")!=null){
            request.setAttribute("connecte",request.getParameter("connecte"));
            return "recherche";
        }
        //return "accueil";
        return "recherche";
    }
    
}
