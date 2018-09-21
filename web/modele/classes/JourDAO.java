
import modele.classes.com.mchausse.lifty.Jour;

public class JourDAO {
    public Jour find(int idUser, String jour){ //trouve un jour de la semaine selon l'ID et le jour
        return new Jour(1, 1, "", "", "");
    }
    public Jour findAll(int idUser){ //trouve tous les jours d'un utilisateur
        return new Jour(1, 1, "", "", ""); //devrait return une liste de jour
    }
    public Jour create(int idJour, int idUser, String jour, String debut, String fin){ //créé un nouveau jour dans la BD
        return new Jour(idJour, idUser, jour, debut, fin);
    }
    public void update(Jour j){ //remplace une journée
        //trouve un jour avec l'id de J et le remplace avec les nouvelles infos
    }
}
