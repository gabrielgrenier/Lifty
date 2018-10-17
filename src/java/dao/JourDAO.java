package dao;

import java.sql.SQLException;
import classe.Jour;
import classe.Profil;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class JourDAO extends Dao{
    
    public Jour find(int idUser, String jour){ //trouve un jour de la semaine selon l'ID du user et le jour
	try{
            String requete;
            requete = "SELECT * FROM jour WHERE userID = '"+idUser+"' and journee = '"+jour+"'";
            // Executer la requete
            rs = ouvrirConnexion().executeQuery(requete);
            if (rs.next()) return construireObjet(rs);
            else return null;
	}
        catch(SQLException | ClassNotFoundException e){ return null;}
	finally{fermerConnexions(con,rs,sqlQuery);}
    }
    public Jour find(Jour j){return find(j.getUserId(),j.getJour());}
    
    public List<Jour> findAll(int idUser){ //trouve tous les jours d'un utilisateur
        List<Jour> listeJour = new ArrayList<>();
        List<Jour> listeTrie = new ArrayList<>();
        String requete;
	try{
            requete = "SELECT * FROM jour WHERE userID = '"+idUser+"'";
            // Executer la requete
            rs = ouvrirConnexion().executeQuery(requete);
            // Pour chaque on cree un jour et lajoute a la liste
            while(rs.next())listeJour.add(construireObjet(rs));
            for(int i=0; i<5; i++){
                switch (listeJour.get(i).getJour()) {
                    case "lundi":
                        listeTrie.add(listeJour.get(i));
                        break;
                    case "mardi":
                        listeTrie.add(listeJour.get(i));
                        break;
                    case "mercredi":
                        listeTrie.add(listeJour.get(i));
                        break;
                    case "jeudi":
                        listeTrie.add(listeJour.get(i));
                        break;
                    case "vendredi":
                        listeTrie.add(listeJour.get(i));
                        break;
                    default:
                        listeTrie.add(null);
                        break;
                }
            }
            return listeTrie;              
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
                String requete;
                requete = "INSERT INTO `jour` (`ID`, `debut`, `fin`, `journee`, `userID`) "
                        + "VALUES ('"+j.getId()+"', '"+Time.valueOf(j.getDebut())+"', '"+Time.valueOf(j.getFin())+"', '"+j.getJour()+"', '"+j.getUserId()+"')";

                //Ouverture de connexion
                ouvrirConnexion().executeUpdate(requete);
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
                String requete;
                requete = "UPDATE `jour` SET `debut`='"+Time.valueOf(j.getDebut())+"', "
                        + "`fin`='"+Time.valueOf(j.getFin())+"',  `journee` = '"+j.getJour()+"', `userID` = '"+j.getUserId()+"' "
                        + "WHERE `jour`.`ID` = '"+j.getId()+"';";
                //Ouverture de connexion 
                ouvrirConnexion().executeUpdate(requete);
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
    
    @Override
    public Jour construireObjet(ResultSet rs) throws SQLException{
        Jour j = new Jour();
        j.setId(rs.getInt("ID"));
        j.setUserID(rs.getInt("userID"));
        j.setJour(rs.getString("journee"));
        j.setDebut(""+rs.getTime("debut"));
        j.setFin(""+rs.getTime("fin"));
        return j;
    }
}