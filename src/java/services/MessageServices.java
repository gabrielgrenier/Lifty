package services;

import dao.MessageDAO;

/* ==== INFO ====

 * @author maxime chausse
 * date : 5 décembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class MessageServices {
    private MessageDAO messageDAO = new MessageDAO();

    public MessageDAO getMessageDAO() {
        return messageDAO;
    }

    public void setMessageDAO(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }
    
}
