package controleurs;

public class MessagerieAction extends AbstractAction{

    @Override
    public String execute() {
        // IMPLEMENTER LA VERIFICATION DE CONNECTION
        if(request.getParameter("connecte")!=null){
            // Si l'utilisateur est connecter et il ne veut pas envoyer de message
            request.setAttribute("connecte",request.getParameter("connecte"));
            request.setAttribute("messageSelect",request.getParameter("messageSelect"));
            return "messagerie";
        }
        //return "accueil";
        return "messagerie";
    }
}
