
package dao;
/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
 *
 * ==== A faire ==== 
 * find(int id)
 * find(Sting username)
 * create(Profil profil)
 * delete(int id)
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import classe.Profil;

public class ProfilDAO {
    
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
            con = DriverManager.getConnection("jdbc:mysql://localhost/lifty?user=root&password=&serverTimezone=UTC&characterEncoding=UTF-8");
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
                p.setConducteur(("0".equals(rs.getString("nomPublic"))));
                if(rs.getString("note")!=null)p.setRating(Double.parseDouble(rs.getString("note")));
                if(rs.getString("tarif")!=null)p.setTarif(Double.parseDouble(rs.getString("tarif")));
                if(rs.getString("rayon")!=null)p.setRayon(Double.parseDouble(rs.getString("rayon")));
                // Verification du conducteur
                if("1".equals(rs.getString("conducteur")))p.setConducteur(true);
                    //p.setVehicule(v); // Achanger pour aller chercher le vehicule de la personne
                return p;
            }else return null;
        }
        catch (SQLException e){System.out.println("Exception : "+e);}
        catch (ClassNotFoundException e){System.out.println("Exception : "+e);}
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
            con = DriverManager.getConnection("jdbc:mysql://localhost/lifty?user=root&password=&serverTimezone=UTC&characterEncoding=UTF-8");
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
                p.setConducteur(("0".equals(rs.getString("nomPublic"))));
                if(rs.getString("note")!=null)p.setRating(Double.parseDouble(rs.getString("note")));
                if(rs.getString("tarif")!=null)p.setTarif(Double.parseDouble(rs.getString("tarif")));
                if(rs.getString("rayon")!=null)p.setRayon(Double.parseDouble(rs.getString("rayon")));
                // Verification du conducteur
                if("1".equals(rs.getString("conducteur")))p.setConducteur(true);
                    //p.setVehicule(v); // Achanger pour aller chercher le vehicule de la personne
                return p;
            }else return null;
        }
        catch (SQLException e){System.out.println("Exception : "+e);}
        catch (ClassNotFoundException e){System.out.println("Exception : "+e);}
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
            con = DriverManager.getConnection("jdbc:mysql://localhost/lifty?user=root&password=&serverTimezone=UTC&characterEncoding=UTF-8");
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
                p.setConducteur(("0".equals(rs.getString("nomPublic"))));
                if(rs.getString("note")!=null)p.setRating(Double.parseDouble(rs.getString("note")));
                if(rs.getString("tarif")!=null)p.setTarif(Double.parseDouble(rs.getString("tarif")));
                if(rs.getString("rayon")!=null)p.setRayon(Double.parseDouble(rs.getString("rayon")));
                // Verification du conducteur
                if("1".equals(rs.getString("conducteur")))p.setConducteur(true);
                    //p.setVehicule(v); // Achanger pour aller chercher le vehicule de la personne
                return p;
            }else return null;
        }
        catch (SQLException e){System.out.println("Exception : "+e);}
        catch (ClassNotFoundException e){System.out.println("Exception : "+e);}
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
}
