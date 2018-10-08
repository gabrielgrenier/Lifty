package dao;

import java.sql.SQLException;
import classe.Jour;
import classe.Profil;
import static dao.Dao.con;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class JourDAO extends Dao{
    
    public Jour find(int idUser, String jour){ //trouve un jour de la semaine selon l'ID du user et le jour
	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String requete;
            requete = "SELECT * FROM jour WHERE userID = '"+idUser+"' and journee = '"+jour+"'";
            //Ouverture de connexion 
            con = DriverManager.getConnection(CONNEXIONSTRING);
            sqlQuery=con.createStatement();
            rs = sqlQuery.executeQuery(requete);
            if (rs.next()) return (Jour)construireObjet(rs,new Jour());
            else return null;
	}
        catch(SQLException | ClassNotFoundException e){ return null;}
	finally{fermerConnexions(con,rs,sqlQuery);}
    }
    public Jour find(Jour j){return find(j.getUserId(),j.getJour());}
    
    public List<Jour> findAll(int idUser){ //trouve tous les jours d'un utilisateur
        List<Jour> listeJour = new ArrayList<>();
        String requete;
	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            requete = "SELECT * FROM jour WHERE userID = '"+idUser+"'";
            //Ouverture de connexion 
            con = DriverManager.getConnection(CONNEXIONSTRING);
            sqlQuery=con.createStatement();
            rs = sqlQuery.executeQuery(requete);
            // Pour chaque on cree un jour et lajoute a la liste
            while(rs.next())listeJour.add((Jour)construireObjet(rs,new Jour()));
            return listeJour;              
	}
        catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    }
    public List<Jour> findAll(Profil p){return findAll(p.getId());}
    
    @Override
    public void create(Object o) {
        // Verifie que l'objet sois un Jour
        if(o instanceof Jour){
            // Caster l<objet en Jour
            Jour j=(Jour)o;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String requete;
                requete = "INSERT INTO `jour` (`ID`, `debut`, `fin`, `journee`, `userID`) "
                        + "VALUES ('"+j.getId()+"', '"+Time.valueOf(j.getDebut())+"', '"+Time.valueOf(j.getFin())+"', '"+j.getJour()+"', '"+j.getUserId()+"')";

                //Ouverture de connexion 
                con = DriverManager.getConnection(CONNEXIONSTRING);
                PreparedStatement statement = con.prepareStatement(requete);
                statement.executeUpdate();
            }
            catch(SQLException | ClassNotFoundException e){}
            finally{fermerConnexions(con,rs,sqlQuery);}
        }
    }
    public void create(int idJour, int idUser, String jour, String debut, String fin){create(new Jour(idJour, idUser, jour, debut, fin));}
    
    @Override
    public void update(Object o) {
        // Verifie que l'objet sois un Jour
        if(o instanceof Jour){
            // Caster l<objet en Jour
            Jour j=(Jour)o;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String requete;
                requete = "UPDATE `jour` SET `debut`='"+Time.valueOf(j.getDebut())+"', "
                        + "`fin`='"+Time.valueOf(j.getFin())+"',  `journee` = '"+j.getJour()+"', `userID` = '"+j.getUserId()+"' "
                        + "WHERE `jour`.`ID` = '"+j.getId()+"';";

                //Ouverture de connexion 
                con = DriverManager.getConnection(CONNEXIONSTRING);
                PreparedStatement statement = con.prepareStatement(requete);
                statement.executeUpdate();
            }
            catch(SQLException | ClassNotFoundException e){}
            finally{fermerConnexions(con,rs,sqlQuery);}
        }
    }

    @Override
    public Object findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}