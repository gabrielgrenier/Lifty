package classe;

import java.util.ArrayList;

/* ==== INFO ====

 * @author maxime chausse
 * date : 14 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class ListeMessage {
    // ==== VARIABLES ====
    private ArrayList messages;
    
    // ==== CONSTRUCTEURS ====
    public ListeMessage(ArrayList l){messages = l;}
    public ListeMessage(){}
    
    // ==== GETTERS ====
    public int length(){return messages.size();}
    public Message get(int i){return (Message)messages.get(i);}
    
    // ==== SETTERS ====
    public void add(Message m){messages.add(m);}
}
