package dao;

import classe.Message;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
// ================================ CLASSE NON-TESTER ======================================

/* ==== INFO ====

 * @author maxime chausse
 * date : 14 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class MessageDAO extends Dao{

    @Override
    public Message findById(int id) {
        String requete;
        try{
            requete = "SELECT * FROM message WHERE ID = '"+id+"'";
            // Executer la requete
            rs = ouvrirConnexion().executeQuery(requete);
            // Construire le profil avec le resultat recu de la requete
            if(rs.next())return construireObjet(rs);
        }
        catch (SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    }
    
    public ArrayList<Message> findAll(int idE, int idR){
        // Variable qui sera retourner et qui va contenir les profils
        ArrayList<Message> output;
        String requete;
        String sousRequete;
	try{
            //Construire la requete
            sousRequete = "SELECT id FROM `messageutilisateur` WHERE `messageutilisateur`.`receveurID` = '"+idR+"' AND `messageutilisateur`.`envoyeurID` = '"+idE+"'";
            requete = "SELECT * FROM message WHERE message.ID = ("+sousRequete+")";
            // Executer la requete
            rs = ouvrirConnexion().executeQuery(requete);
            // Definir un tableau de la du nombres de champs recu
            output = new ArrayList<>();
            // Construire un profil et le mettre dans la liste pour chaque donnees recu
            while(rs.next()) output.add(construireObjet(rs));
            return output;
	}
        catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    }

    @Override
    public void create(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Message construireObjet(ResultSet rs) throws SQLException {
        Message m = new Message();
        m.setId(Integer.parseInt(rs.getString("ID")));
        m.setMessage(rs.getString("message"));
        m.setTitre(rs.getString("titre"));
        m.setDate(rs.getString("date"));
        m.setTime(rs.getString("time"));
        m.setVu("0".equals(rs.getString("vu")));
        return m;
    }
    
}
