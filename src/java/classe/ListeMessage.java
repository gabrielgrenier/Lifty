package classe;

import java.util.LinkedList;

/* ==== INFO ====

 * @author maxime chausse
 * date : 14 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class ListeMessage {
    // ==== VARIABLES ====
    private LinkedList messages;
    
    // ==== CONSTRUCTEURS ====
    public ListeMessage(LinkedList l){messages = l;}
    public ListeMessage(){messages = new LinkedList();}
    
    // ==== GETTERS ====
    public int length(){return messages.size();}
    public Message get(int i){return (Message)messages.get(i);}
    
    // ==== SETTERS ====
    public void add(Message m){messages.add(m);}
}
