package servlets;

import controleurs.AbstractAction;
import controleurs.AfficherProfilAction;
import controleurs.AjouterCommentaireAction;
import controleurs.ConfidentialiteAction;
import controleurs.ConnexionAction;
import controleurs.DeconnexionAction;
import controleurs.DefaultAction;
import controleurs.MessagerieAction;
import controleurs.InscriptionAction;
import controleurs.ModifierInformationProfilAction;
import controleurs.PreferencesAction;
import controleurs.RechercheAction;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControleurFrontal extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AbstractAction action;
        String vue;
        String actionAFaire = request.getParameter("action");
        if (actionAFaire == null) actionAFaire = "";
        
        switch (actionAFaire) {
            case "connexion":
                action = new ConnexionAction();
                break;
            case "inscription":
                action = new InscriptionAction();
                break;
            case "confidentialite":
                action = new ConfidentialiteAction();
                break;
            case "preferences":
                action = new PreferencesAction();
                break;
            case "deconnexion":
                action = new DeconnexionAction();
                break;
            case "messagerie":
                action = new MessagerieAction();
                break;
            case "recherche":
                action = new RechercheAction();
                break;
            case "afficherProfil":
                action = new AfficherProfilAction();
                break;
            case "modInformationProfil":
                action = new ModifierInformationProfilAction();
                break;
            case "ajouterCom":
                action = new AjouterCommentaireAction();
                break;
            default :
                action = new DefaultAction();
        }
        
        action.setRequest(request);
        action.setResponse(response);
        
        vue = action.execute();
        request.getRequestDispatcher("/WEB-INF/vues/"+vue+".jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Servelet du controleurFrontal";
    }// </editor-fold>
}
