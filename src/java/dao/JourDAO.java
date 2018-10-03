package dao;

import classe.Jour;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import classe.Jour;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class JourDAO {
    
    public Jour find(int idUser, String jour){ //trouve un jour de la semaine selon l'ID du user et le jour
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
	}
        catch(SQLException e){ return null;}
        catch (ClassNotFoundException e){return null;}
	finally{
            try{
                if (rs!=null) rs.close();
                if (sqlQuery!=null) sqlQuery.close();
                if (con!=null) con.close();
            }catch (SQLException e){System.out.println("Exception : "+e);}
        }
    }
    public List<Jour> findAll(int idUser){ //trouve tous les jours d'un utilisateur
        Connection con=null;
        ResultSet rs=null;
	Statement sqlQuery=null;
        List<Jour> listeJour = new ArrayList<>();

	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/lifty?user=root&password=root&serverTimezone=EST");
            String requete;
            requete = "SELECT * FROM jour WHERE userID = '"+idUser+"'";
            sqlQuery=con.createStatement();
            rs = sqlQuery.executeQuery(requete);
            while(rs.next()){
                Jour temp = new Jour();
                temp.setId(rs.getInt("ID"));
                temp.setUserID(rs.getInt("userID"));
                temp.setJour(rs.getString("journee"));
                temp.setDebut(""+rs.getTime("debut"));
                temp.setFin(""+rs.getTime("fin"));
                
                listeJour.add(temp);
            }
            return listeJour;              
	}
        catch(SQLException e){return null;}
        catch (ClassNotFoundException e){return null;}
	finally{
            try{
                if (rs!=null) rs.close();
                if (sqlQuery!=null) sqlQuery.close();
                if (con!=null) con.close();
            }catch (SQLException e){System.out.println("Exception : "+e);}
        }
    }
    public void create(int idJour, int idUser, String jour, String debut, String fin){ //crée un nouveau jour à partir de paramètre
        Connection con=null;
        ResultSet rs=null;
	Statement sqlQuery=null;

	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/lifty?user=root&password=root&serverTimezone=EST");
            String requete;
            requete = "INSERT INTO `jour` (`ID`, `debut`, `fin`, `journee`, `userID`) "
                    + "VALUES ('"+idJour+"', '"+Time.valueOf(debut)+"', '"+Time.valueOf(debut)+"', '"+jour+"', '"+idUser+"')";
            
            PreparedStatement statement = con.prepareStatement(requete);
            statement.executeUpdate();
	}
        catch(SQLException e){}
        catch (ClassNotFoundException e){}
	finally{
            try{
                if (rs!=null) rs.close();
                if (sqlQuery!=null) sqlQuery.close();
                if (con!=null) con.close();
            }catch (SQLException e){System.out.println("Exception : "+e);}
        }
    }
    public void update(Jour j){ //Update un jour à partir d'un objet jour
        Connection con=null;
        ResultSet rs=null;
	Statement sqlQuery=null;

	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/lifty?user=root&password=root&serverTimezone=EST");
            String requete;
            requete = "UPDATE `jour` SET `debut`='"+Time.valueOf(j.getDebut())+"', "
                    + "`fin`='"+Time.valueOf(j.getFin())+"',  `journee` = '"+j.getJour()+"', `userID` = '"+j.getUserId()+"' "
                    + "WHERE `jour`.`ID` = '"+j.getId()+"';";
            
            PreparedStatement statement = con.prepareStatement(requete);
            statement.executeUpdate();
	}
        catch(SQLException e){}
        catch (ClassNotFoundException e){}
	finally{
            try{
                if (rs!=null) rs.close();
                if (sqlQuery!=null) sqlQuery.close();
                if (con!=null) con.close();
            }catch (SQLException e){System.out.println("Exception : "+e);}
        }
    }
}