package classe;
/* ==== INFO ====

 * @author maxime chausse
 * date : 14 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class Message {
    // ==== VARIABLES ====
    private String id;
    private String titre, message, date, time;
    private boolean vu;
    
    // ==== CONSTRUCTEURS ====
    public Message(){}
    public Message(String id, String titre, String message, String date, String time, boolean vu){
        this.id = id;
        this.titre = titre;
        this.message = message;
        this.date = date;
        this.time = time;
        this.vu = vu;
    }

    // ==== GETTERS ====
    public String getId() {return id;}
    public String getTitre() {return titre;}
    public String getMessage() {return message;}
    public String getDate() {return date;}
    public String getTime() {return time;}
    public boolean isVu() {return vu;}

    // ==== SETTERS ====
    public void setId(String id) {this.id = id;}
    public void setTitre(String titre) {this.titre = titre;}
    public void setMessage(String message) {this.message = message;}
    public void setDate(String date) {this.date = date;}
    public void setTime(String time) {this.time = time;}
    public void setVu(boolean vu) {this.vu = vu;}
    
    // ==== AFFICHAGE ====
    @Override
    public String toString(){
        return "["+this.getId()+"] "+this.getTitre()+" "+this.getDate()+"-"+this.getTime()+" ("+this.isVu()+")";
    }
}
