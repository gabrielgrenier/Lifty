package classe;
/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class Critique {
    private int critiqueID;
    private double note;
    private String commentaire;
    private int like;
    private int dislike;
    private int envoyeurID;
    private int receveurID;
    
    //Constructeur
    public Critique(int critiqueID, double note, String commentaire, int like, int dislike, int envoyeurID, int receveurID) {    
        this.critiqueID = critiqueID;
        this.note = note;
        this.commentaire = commentaire;
        this.like = like;
        this.dislike = dislike;
        this.envoyeurID = envoyeurID;
        this.receveurID = receveurID;
    }
    
    public Critique() {
        this.critiqueID = 0;
        this.note = 0;
        this.commentaire = "";
        this.like = 0;
        this.dislike = 0;
        this.envoyeurID = 0;
        this.receveurID = 0;
    }
    
    
    // Getters & Setters
    public int getCritiqueID() {
        return critiqueID;
    }

    public void setCritiqueID(int critiqueID) {
        this.critiqueID = critiqueID;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getEnvoyeurID() {
        return envoyeurID;
    }

    public void setEnvoyeurID(int envoyeurID) {
        this.envoyeurID = envoyeurID;
    }

    public int getReceveurID() {
        return receveurID;
    }

    public void setReceveurID(int receveurID) {
        this.receveurID = receveurID;
    }
    
    //Autre
    public void augmenterLike() {
        this.like += 1;
    }
    public void decrementerLike() {
        this.like -= 1;
    }
    public void augmenterDislike() {
        this.dislike += 1;
    }
    public void decrementerDislike() {
        this.dislike -= 1;
    }    
    
    
}
