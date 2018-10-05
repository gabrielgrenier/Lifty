
package dao;
/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
 *
 * ==== A faire ==== 
 * Arrangee le find pour assigner le vehicule au profil
 * update(Profil p)
 * delete(int id)
*/
import classe.Jour;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import classe.Profil;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.Time;

public class ProfilDAO {
    private static String connexionString = "jdbc:mysql://localhost/lifty?user=root&password=&serverTimezone=UTC&characterEncoding=UTF-8";
    
    // Trouver un profil grace au email
    public static Profil findByEmail(String email){
        Connection con=null;
        ResultSet rs=null;
        Statement sqlQuery=null;
        Profil p;
        
        try{
            //Chargement du pilote 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Ouverture de connexion 
            con = DriverManager.getConnection(connexionString);
            String requete;
            requete = "SELECT * FROM utilisateur WHERE email = '"+email+"'";
            sqlQuery=con.createStatement();
            rs = sqlQuery.executeQuery(requete);   
            if(rs.next()){
                p=new Profil();
                p.setId(Integer.parseInt(rs.getString("ID")));
                p.setUsername(rs.getString("username"));
                p.setEmail(rs.getString("email"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setMotDePasse(rs.getString("motDePasse"));
                p.setRole(Integer.parseInt(rs.getString("role")));
                p.setDateInscription(rs.getString("dateInscription"));
                p.setDateConnexion(rs.getString("dateConnexion"));
                p.setCodePostal(rs.getString("codePostal"));
                p.setEtablissement(rs.getString("etablissement"));
                p.setImageProfil(rs.getString("imageProfil"));
                p.setNomPublic(("0".equals(rs.getString("nomPublic"))));
                p.setPrenomPublic(("0".equals(rs.getString("prenomPublic"))));
                p.setEmailPublic(("0".equals(rs.getString("emailPublic"))));
                p.setValide(("0".equals(rs.getString("valide"))));
                p.setConducteur(("0".equals(rs.getString("conducteur"))));
                if(rs.getString("note")!=null)p.setRating(Double.parseDouble(rs.getString("note")));
                if(rs.getString("tarif")!=null)p.setTarif(Double.parseDouble(rs.getString("tarif")));
                if(rs.getString("rayon")!=null)p.setRayon(Double.parseDouble(rs.getString("rayon")));
                // Verification du conducteur
                if("1".equals(rs.getString("conducteur")))p.setConducteur(true);
                    //p.setVehicule(v); // Achanger pour aller chercher le vehicule de la personne
                return p;
            }else return null;
        }
        catch (SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
        finally{
            try{
                if (rs!=null) rs.close();
                if (sqlQuery!=null) sqlQuery.close();
                if (con!=null) con.close();
            }
            catch (SQLException e){System.out.println("Exception : "+e);}
        }
        return null;
    }
    
    public Profil findById(int id){
        Connection con=null;
        ResultSet rs=null;
        Statement sqlQuery=null;
        Profil p;
        
        try{
            //Chargement du pilote 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Ouverture de connexion 
            con = DriverManager.getConnection(connexionString);
            String requete;
            requete = "SELECT * FROM utilisateur WHERE ID = '"+id+"'";
            sqlQuery=con.createStatement();
            rs = sqlQuery.executeQuery(requete);   
            if(rs.next()){
                p=new Profil();
                p.setId(Integer.parseInt(rs.getString("ID")));
                p.setUsername(rs.getString("username"));
                p.setEmail(rs.getString("email"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setMotDePasse(rs.getString("motDePasse"));
                p.setRole(Integer.parseInt(rs.getString("role")));
                p.setDateInscription(rs.getString("dateInscription"));
                p.setDateConnexion(rs.getString("dateConnexion"));
                p.setCodePostal(rs.getString("codePostal"));
                p.setEtablissement(rs.getString("etablissement"));
                p.setImageProfil(rs.getString("imageProfil"));
                p.setNomPublic(("0".equals(rs.getString("nomPublic"))));
                p.setPrenomPublic(("0".equals(rs.getString("prenomPublic"))));
                p.setEmailPublic(("0".equals(rs.getString("emailPublic"))));
                p.setValide(("0".equals(rs.getString("valide"))));
                p.setConducteur(("0".equals(rs.getString("conducteur"))));
                if(rs.getString("note")!=null)p.setRating(Double.parseDouble(rs.getString("note")));
                if(rs.getString("tarif")!=null)p.setTarif(Double.parseDouble(rs.getString("tarif")));
                if(rs.getString("rayon")!=null)p.setRayon(Double.parseDouble(rs.getString("rayon")));
                // Verification du conducteur
                if("1".equals(rs.getString("conducteur")))p.setConducteur(true);
                    //p.setVehicule(v); // Achanger pour aller chercher le vehicule de la personne
                return p;
            }else return null;
        }
        catch (SQLException|ClassNotFoundException e){System.out.println("Exception : "+e);}
        finally{
            try{
                if (rs!=null) rs.close();
                if (sqlQuery!=null) sqlQuery.close();
                if (con!=null) con.close();
            }
            catch (SQLException e){System.out.println("Exception : "+e);}
        }
        return null;
    }
    public Profil findByUsername(String username){
        Connection con=null;
        ResultSet rs=null;
        Statement sqlQuery=null;
        Profil p;
        
        try{
            //Chargement du pilote 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Ouverture de connexion 
            con = DriverManager.getConnection(connexionString);
            String requete;
            requete = "SELECT * FROM utilisateur WHERE username = '"+username+"'";
            sqlQuery=con.createStatement();
            rs = sqlQuery.executeQuery(requete);   
            if(rs.next()){
                p=new Profil();
                p.setId(Integer.parseInt(rs.getString("ID")));
                p.setUsername(rs.getString("username"));
                p.setEmail(rs.getString("email"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setMotDePasse(rs.getString("motDePasse"));
                p.setRole(Integer.parseInt(rs.getString("role")));
                p.setDateInscription(rs.getString("dateInscription"));
                p.setDateConnexion(rs.getString("dateConnexion"));
                p.setCodePostal(rs.getString("codePostal"));
                p.setEtablissement(rs.getString("etablissement"));
                p.setImageProfil(rs.getString("imageProfil"));
                p.setNomPublic(("0".equals(rs.getString("nomPublic"))));
                p.setPrenomPublic(("0".equals(rs.getString("prenomPublic"))));
                p.setEmailPublic(("0".equals(rs.getString("emailPublic"))));
                p.setValide(("0".equals(rs.getString("valide"))));
                p.setConducteur(("0".equals(rs.getString("conducteur"))));
                if(rs.getString("note")!=null)p.setRating(Double.parseDouble(rs.getString("note")));
                if(rs.getString("tarif")!=null)p.setTarif(Double.parseDouble(rs.getString("tarif")));
                if(rs.getString("rayon")!=null)p.setRayon(Double.parseDouble(rs.getString("rayon")));
                // Verification du conducteur
                if("1".equals(rs.getString("conducteur")))p.setConducteur(true);
                    //p.setVehicule(v); // Achanger pour aller chercher le vehicule de la personne
                return p;
            }else return null;
        }
        catch (SQLException |ClassNotFoundException e){System.out.println("Exception : "+e);}
        finally{
            try{
                if (rs!=null) rs.close();
                if (sqlQuery!=null) sqlQuery.close();
                if (con!=null) con.close();
            }
            catch (SQLException e){System.out.println("Exception : "+e);}
        }
        return null;
    }
    
    public void create(Profil p){
        Connection con=null;
        Statement sqlQuery=null;
        try{            
            String requete;
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Ouverture de connexion 
            con = DriverManager.getConnection(connexionString);
            sqlQuery=con.createStatement();
            requete = "INSERT INTO `utilisateur` (`ID`, `username`, "
                    + "`email`, `motDePasse`, "
                    + "`nom`, `prenom`, "
                    + "`role`, `conducteur`, "
                    + "`note`, `codePostal`, "
                    + "`emailPublic`, `nomPublic`, "
                    + "`prenomPublic`, `valide`, "
                    + "`dateInscription`, `dateConnexion`, "
                    + "`etablissement`, `rayon`, "
                    + "`tarif`, `imageProfil`, "
                    + "`vehiculeID`) "
                    + "VALUES (\'"+p.getId()+"\', \'"+p.getUsername()+"\',"
                    + " \'"+p.getEmail()+"\', \'"+p.getMotDePasse()+"\',"
                    + " \'"+p.getNom()+"\', \'"+p.getPrenom()+"\',"
                    + " \'"+p.getRole()+"\', \'"+(p.isConducteur()?1:0)+"\',"
                    + " \'"+p.getRating()+"\', \'"+p.getCodePostal()+"\',"
                    + " \'"+(p.isPublicEmail()?1:0)+"\', \'"+(p.isPublicNom()?1:0)+"\',"
                    + " \'"+(p.isPublicPrenom()?1:0)+"\', \'"+(p.isValide()?1:0)+"\',"
                    + " \'"+p.getDateInscription()+"\', \'"+p.getDateConnexion()+"\',"
                    + " "+(p.getEtablissement()!=null?"\'"+p.getEtablissement()+"\'":"NULL")+", \'"+p.getRayon()+"\', "
                    + "\'"+p.getTarif()+"\', "+(p.getImageProfil()!=null?"\'"+p.getImageProfil()+"\'":"NULL")+", "
                    + ""+(p.getVehicule()!=null?"\'"+p.getVehicule().getId()+"\'":"NULL")+")";
            sqlQuery.executeUpdate(requete);
        }
        catch (SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
        finally{
            try{
                if (sqlQuery!=null) sqlQuery.close();
                if (con!=null) con.close();
            }
            catch (SQLException e){System.out.println("Exception : "+e);}
        }
    }
    public void update(Profil p){ //pas tester
        Connection con=null;
        ResultSet rs=null;
	Statement sqlQuery=null;

	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connexionString);
            String requete;
            requete = "UPDATE `utilisateur` SET `ID` = '"+p.getId()+"', `username`='"+p.getUsername()+"', "
                    + "`email`='"+p.getEmail()+"',  `motDePasse` = '"+p.getMotDePasse()+"', `nom` = '"+p.getNom()+"', "
                    + "`prenom`='"+p.getPrenom()+"',  `role` = '"+p.getRole()+"', `conducteur` = '"+(p.isConducteur()?1:0)+"', "
                    + "`note`='"+p.getRating()+"',  `codePostal` = '"+p.getCodePostal()+"', `emailPublic` = '"+(p.isPublicEmail()?1:0)+"', "
                    + "`nomPublic`='"+(p.isPublicNom()?1:0)+"',  `prenomPublic` = '"+(p.isPublicPrenom()?1:0)+"', `valide` = '"+(p.isValide()?1:0)+"', "
                    + "`dateInscription`='"+p.getDateInscription()+"',  `dateConnexion` = '"+p.getDateConnexion()+"', `etablissement` = "+(p.getEtablissement()!=null?"\'"+p.getEtablissement()+"\'":"NULL")+", "
                    + "`rayon`='"+p.getRayon()+"',  `tarif` = '"+p.getTarif()+"', `imageProfil` = "+(p.getImageProfil()!=null?"\'"+p.getImageProfil()+"\'":"NULL")+", "
                    + "`vehiculeID`="+(p.getVehicule()!=null?"\'"+p.getVehicule().getId()+"\'":"NULL")+""
                    + " WHERE `utilisateur`.`ID` = '"+p.getId()+"';";
            PreparedStatement statement = con.prepareStatement(requete);
            System.out.println("Requete : "+requete);
            statement.executeUpdate();
	}
        catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{
            try{
                if (rs!=null) rs.close();
                if (sqlQuery!=null) sqlQuery.close();
                if (con!=null) con.close();
            }
            catch (SQLException e){System.out.println("Exception : "+e);}
        }
    }
}
