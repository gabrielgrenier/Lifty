package classe;
/* ==== INFO ====

 * @author maxime chausse
 * date : 14 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class Message {
    // ==== VARIABLES ====
    private int id;
    private String message, date, time;
    private boolean vu;
    
    // ==== CONSTRUCTEURS ====
    public Message(){}
    public Message(int id, String message, String date, String time, boolean vu){
        this.id = id;
        this.message = message;
        this.date = date;
        this.time = time;
        this.vu = vu;
    }

    // ==== GETTERS ====
    public int getId() {return id;}
    public String getMessage() {return message;}
    public String getDate() {return date;}
    public String getTime() {return time;}
    public boolean isVu() {return vu;}

    // ==== SETTERS ====
    public void setId(int id) {this.id = id;}
    public void setMessage(String message) {this.message = message;}
    public void setDate(String date) {this.date = date;}
    public void setTime(String time) {this.time = time;}
    public void setVu(boolean vu) {this.vu = vu;}
}
