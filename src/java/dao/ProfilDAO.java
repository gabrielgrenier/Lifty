
package dao;
/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
 *
 * ==== A faire ==== 
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
    
    public void create(Profil profil){
        Connection con=null;
        Statement sqlQuery=null;
        String vId;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Ouverture de connexion 
            con = DriverManager.getConnection("jdbc:mysql://localhost/lifty?user=root&password=&serverTimezone=UTC&characterEncoding=UTF-8");
            String requete;
//            requete = "INSERT INTO utilisateur values (ID=\'"+profil.getId()+"\', username=\'"+profil.getUsername()+"\',"
//                    + "email=\'"+profil.getEmail()+"\',motDePasse=\'"+profil.getMotDePasse()+"\',nom=\'"+profil.getNom()+"\',prenom=\'"+profil.getPrenom()+"\',"
//                    + "role=\'"+profil.getRole()+"\',conducteur=\'"+(profil.isConducteur()?1:0)+"\',note="+profil.getRating()+",codePostal=\'"+profil.getCodePostal()+"\',"
//                    + "emailPublic=\'"+(profil.isPublicEmail()?1:0)+"\',nomPublic=\'"+(profil.isPublicNom()?1:0)+"\',prenomPublic=\'"+(profil.isPublicPrenom()?1:0)+"\',valide=\'"+(profil.isValide()?1:0)+"\',"
//                    + "dateInscription=\'"+profil.getDateInscription()+"\',dateConnexion=\'"+profil.getDateConnexion()+"\',etablissement=\'"+profil.getEtablissement()+"\',rayon="+profil.getRayon()+","
//                    + "tarif="+profil.getTarif()+",imageProfil="+profil.getImageProfil()+"";
//                    + ",vehiculeID="+profil.getVehicule().getId()+")";

            sqlQuery=con.createStatement();
            requete = "INSERT INTO `utilisateur` (`ID`, `username`, `email`, `motDePasse`, `nom`, `prenom`, `role`, `conducteur`, `note`, `codePostal`, `emailPublic`, `nomPublic`, `prenomPublic`, `valide`, `dateInscription`, `dateConnexion`, `etablissement`, `rayon`, `tarif`, `imageProfil`, `vehiculeID`) "
                    + "VALUES (\'"+profil.getId()+"\', \'"+profil.getUsername()+"\', \'"+profil.getEmail()+"\', \'"+profil.getMotDePasse()+"\', \'"+profil.getNom()+"\', \'"+profil.getPrenom()+"\', \'"+profil.getRole()+"\', \'"+(profil.isConducteur()?1:0)+"\', \'"+profil.getRating()+"\', \'"+profil.getCodePostal()+"\', \'"+(profil.isPublicEmail()?1:0)+"\', \'"+(profil.isPublicNom()?1:0)+"\', \'"+(profil.isPublicPrenom()?1:0)+"\', \'"+(profil.isValide()?1:0)+"\', \'"+profil.getDateInscription()+"\', \'"+profil.getDateConnexion()+"\', "+(profil.getEtablissement()!=null?"\'"+profil.getEtablissement()+"\'":"NULL")+", \'"+profil.getRayon()+"\', \'"+profil.getTarif()+"\', "+(profil.getImageProfil()!=null?"\'"+profil.getImageProfil()+"\'":"NULL")+", "+(profil.getVehicule()!=null?"\'"+profil.getVehicule().getId()+"\'":"NULL")+")";
            int x =sqlQuery.executeUpdate(requete);
            System.out.println(requete+"; "+x);
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
}
