package controleurs;

import javax.servlet.http.HttpSession;

public class MessagerieAction extends AbstractAction{

    @Override
    public String execute() {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("connected")==null) {//déjà non connecté
            return "accueil";
        }
        request.setAttribute("messageSelect",request.getParameter("messageSelect"));
        return "messagerie";
        }
    }
