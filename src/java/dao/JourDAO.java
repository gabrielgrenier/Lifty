package dao;

import classe.Jour;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JourDAO {
    
    public Jour find(int idUser, String jour){ //trouve un jour de la semaine selon l'ID et le jour
        Connection con=null;
        ResultSet rs=null;
	Statement sqlQuery=null;

	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/lifty?user=root&password=root&serverTimezone=EST");
            String requete;
            requete = "SELECT * FROM jour WHERE userID = '"+idUser+"' and journee = '"+jour+"'";
            sqlQuery=con.createStatement();
            rs = sqlQuery.executeQuery(requete);
            if (rs.next()) {
                Jour j = new Jour();
                j.setId(rs.getInt("ID"));
                j.setUserID(rs.getInt("userID"));
                j.setJour(rs.getString("journee"));
                j.setDebut(""+rs.getTime("debut"));
                j.setFin(""+rs.getTime("fin"));
                return j;
            }else{return null;}

                        
	}catch(SQLException e){ 
            //return new Jour(0, 0, ""+e, "", "");
            return null;
        }catch (ClassNotFoundException e){
            return null;
        }
	finally{
                try{
                    if (rs!=null) rs.close();
                    if (sqlQuery!=null) sqlQuery.close();
                    if (con!=null) con.close();
                }catch (SQLException e){System.out.println("Exception : "+e);}
        }
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