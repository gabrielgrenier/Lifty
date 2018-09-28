
package com.lifty.dao;
/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.lifty.classes.Profil;

public class ProfilDAO {
    
    // Trouver un profil grace au email
    public static Profil find(String email){
        Connection con=null;
        ResultSet rs=null;
        Statement sqlQuery=null;
        Profil p = null;
        
        try{
            //Chargement du pilote 
            Class.forName("com.mysql.jc.jdbc.Driver");
            //Ouverture de connexion 
            con = DriverManager.getConnection("jdbc:mysql://localhost/lifty?user=root&password=Admin");
            String requete;
            requete = "SELECT * FROM compte WHERE email = "+email;
            sqlQuery=con.createStatement();
            rs = sqlQuery.executeQuery(requete);
            if(rs.next()){
                p=new Profil(
                    rs.getInt("ID"),
                    rs.getString("email"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("motDePasse"),
                    rs.getInt("role"),
                    rs.getString("dateInscription"),
                    rs.getString("dateConnexion"),
                    rs.getString("codePostal"),
                    rs.getString("etablissement"),
                    rs.getString("imageProfil"),
                    rs.getBoolean("nomPublic"),
                    rs.getBoolean("prenomPublic"),
                    rs.getBoolean("emailPublic"),
                    rs.getBoolean("valide"),
                    rs.getBoolean("conducteur"),
                    rs.getDouble("note"),
                    rs.getDouble("tarif"),
                    rs.getDouble("rayon")
                );
                return new Profil(5, "email", "Nom", "Prenom","mot", 1,  "123", "123", "123", "123", "123", false, false, false, false, false,5,23, 22);
            }
            //System.out.println(p);
            if("1".equals(rs.getString("conducteur"))){
                p.setConducteur(true);
                //p.setVehicule(v); // Achanger pour aller chercher le vehicule de la personne
            }
        }
        catch (SQLException e){
            //ystem.out.println("Exception : "+e);
            return new Profil(5, "email", "Nom", "Prenom","mot", 1,  "123", "123", "123", "123", "123", false, false, false, false, false,5,23, 22);
        }
        catch (ClassNotFoundException e){System.out.println("Exception : "+e);}
        finally{
            try{
                if (rs!=null) rs.close();
                if (sqlQuery!=null) sqlQuery.close();
                if (con!=null) con.close();
            }
            catch (SQLException e){
                //System.out.println("Exception : "+e);
                return new Profil(5, "email", "Nom", "Prenom","mot", 1,  "123", "123", "123", "123", "123", false, false, false, false, false,5,23, 22);
            }
        }
        return p;
    }
}
