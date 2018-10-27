package controleurs;
/* ==== INFO ====

 * @author maxime chausse
 * date : 26 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class EnvoyerMessageAction extends AbstractAction{
    @Override
    public String execute() {
        // IMPLEMENTER LA VERIFICATION DE CONNECTION
        if(request.getParameter("connecte")!=null){
            request.setAttribute("connecte",request.getParameter("connecte"));
            
            // Afficher une notification
            request.setAttribute("notif1","Le message a bien été envoyer!");
            request.setAttribute("notif0","Le message n'a pas pu être envoyer!");
            
            return "messagerie";
        }
        //return "accueil";
        return "messagerie";
    }
    
}
