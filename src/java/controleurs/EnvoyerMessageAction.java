package controleurs;

import classe.Message;
import dao.MessageDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
            
            if(request.getParameter("titre")!=null){
                MessageDAO mDao = new MessageDAO();
                Message newMessage = new Message();
                
                // Trouver la date live
                Date dateTime = new Date();
                // Avoir un format qui affiche juste la date
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                // Avoir un format qui affiche juste le temps
                SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
                
                // Remplir le nouveau message
                newMessage.setId(UUID.randomUUID().toString());
                newMessage.setTitre(String.valueOf(request.getParameter("titre")));
                newMessage.setMessage(String.valueOf(request.getParameter("texte")));
                newMessage.setDate(date.format(dateTime));
                newMessage.setTime(time.format(dateTime));
                newMessage.setVu(false);
                
                // Envoyer le message
                boolean succes;
                succes = mDao.envoyerMessage(newMessage,
                        Integer.parseInt(request.getParameter("connecte")),
                        String.valueOf(request.getParameter("usernameDestinataire"))
                );
                
                // Afficher une notification
                if(succes)request.setAttribute("notif1", "Message envoyé à "+String.valueOf(request.getParameter("usernameDestinataire")));
                else request.setAttribute("notif2", "Oups! Un probleme est survenu. Veuiller recommencer.");
            }
        }
        //return "accueil";
        return "messagerie";
    }
    
}
