/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Critique;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CritiqueDAO extends Dao {
    
    public List<Critique> findByIdUserReceveur(int id) {
        try{
            List<Critique> listeCritique = new ArrayList<Critique>();
            String requete;
            requete = "SELECT * FROM `critique` WHERE `receveurID` = '"+id+"'";
            // Executer la requete
            rs = ouvrirConnexion().executeQuery(requete);
            while (rs.next()) {
                listeCritique.add(construireObjet(rs));
            }
            return listeCritique;
	}
        catch(SQLException e){ return null;}
	finally{fermerConnexions(con,rs,sqlQuery);}
    }
    
    @Override
    public Object findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Object o) {
         if(o instanceof Critique){
            Critique c =(Critique)o;
            String requete;
            try{
                requete = "INSERT INTO `critique` (`ID`, `note`, `commentaire`, `like`, `dislike`, `envoyeurID`, `receveurID`) "
                        + "VALUES (\'"+c.getCritiqueID()+"\', \'"+c.getNote()+"\', \'"+c.getCommentaire()+"\', \'"+c.getLike()+"\', \'"+c.getDislike()+"\', \'"+c.getEnvoyeurID()+"\', \'"+c.getReceveurID()+"\')";
                ouvrirConnexion().executeUpdate(requete);
            }
            catch (SQLException e){System.out.println("Exception : "+e);}
            finally{fermerConnexions(con,rs,sqlQuery);}
        }
    }

    @Override
    public void update(Object o) {
        if(o instanceof Critique){
            Critique c =(Critique)o;
            String requete;
            try{
                requete = "UPDATE `critique` SET `note`='"+c.getNote()+"', `commentaire`='"+c.getCommentaire()+"', `like`='"+c.getLike()
                          +"', `dislike`='"+c.getDislike()+"', `envoyeurID`='"+c.getEnvoyeurID()
                          +"', `receveurID`='"+c.getReceveurID()+"' WHERE `critique`.`ID` = '"+c.getCritiqueID()+"';";
                ouvrirConnexion().executeUpdate(requete);
            }
            catch (SQLException e){System.out.println("Exception : "+e);}
            finally{fermerConnexions(con,rs,sqlQuery);}
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void delete(Critique c) {
        try{
            int id = c.getCritiqueID();
            String requete;
            requete = "DELETE * FROM critique WHERE utilisateurID = '"+id+"'";
            ouvrirConnexion().executeUpdate(requete);
            
        }
        catch (SQLException e){System.out.println("Exception : "+e);}
        finally{fermerConnexions(con,rs,sqlQuery);}
    }
    
    @Override
    public Critique construireObjet(ResultSet rs) throws SQLException {
        Critique c = new Critique();
        c.setCritiqueID(Integer.parseInt(rs.getString("ID")));
        c.setNote(Double.valueOf(rs.getString("note")));
        c.setCommentaire(rs.getString("commentaire"));
        c.setLike(Integer.parseInt(rs.getString("like")));
        c.setDislike(Integer.parseInt(rs.getString("dislike")));
        c.setEnvoyeurID(Integer.parseInt(rs.getString("envoyeurID")));
        c.setReceveurID(Integer.parseInt(rs.getString("receveurID")));
        return c;
    }

    @Override
    public Object findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
