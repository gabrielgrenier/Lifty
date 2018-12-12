package controleurs;
/* ==== INFO ====

 * @author maxime chausse
 * date : 16 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class OuvrirMessageAction extends AbstractAction{

    @Override
    public String execute() {
        if(request.getParameter("connecte")!=null){
            System.out.println("MessageSelectId : "+request.getParameter("messageSelect"));
            request.setAttribute("connecte",request.getParameter("connecte"));
            request.setAttribute("messageSelect",request.getParameter("messageSelect"));
            return "messagerie";
        }
        return "messagerie";
    }
    
}
