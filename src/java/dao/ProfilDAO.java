
package dao;
/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
 *
 * ==== A faire ==== 
 * Arrangee le find pour assigner le vehicule au profil
 * findAll(etablissement, conducteur)
 * findAll(conducteur)
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import classe.Profil;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ProfilDAO {
    private static final String CONNEXIONSTRING = "jdbc:mysql://localhost/lifty?user=root&password=&serverTimezone=UTC&characterEncoding=UTF-8";
    
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
            con = DriverManager.getConnection(CONNEXIONSTRING);
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
            con = DriverManager.getConnection(CONNEXIONSTRING);
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
            con = DriverManager.getConnection(CONNEXIONSTRING);
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
            con = DriverManager.getConnection(CONNEXIONSTRING);
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
            con = DriverManager.getConnection(CONNEXIONSTRING);
            String requete;
            requete = "UPDATE `utilisateur` SET `ID` = '"+p.getId()+"', `username`='"+p.getUsername()+"', "
                    + "`email`='"+p.getEmail()+"',                      `motDePasse` = '"+p.getMotDePasse()+"',             `nom` = '"+p.getNom()+"', "
                    + "`prenom`='"+p.getPrenom()+"',                    `role` = '"+p.getRole()+"',                         `conducteur` = '"+(p.isConducteur()?1:0)+"', "
                    + "`note`='"+p.getRating()+"',                      `codePostal` = '"+p.getCodePostal()+"',             `emailPublic` = '"+(p.isPublicEmail()?1:0)+"', "
                    + "`nomPublic`='"+(p.isPublicNom()?1:0)+"',         `prenomPublic` = '"+(p.isPublicPrenom()?1:0)+"',    `valide` = '"+(p.isValide()?1:0)+"', "
                    + "`dateInscription`='"+p.getDateInscription()+"',  `dateConnexion` = '"+p.getDateConnexion()+"',       `etablissement` = "+(p.getEtablissement()!=null?"\'"+p.getEtablissement()+"\'":"NULL")+", "
                    + "`rayon`='"+p.getRayon()+"',                      `tarif` = '"+p.getTarif()+"',                       `imageProfil` = "+(p.getImageProfil()!=null?"\'"+p.getImageProfil()+"\'":"NULL")+", "
                    + "`vehiculeID`="+(p.getVehicule()!=null?"\'"+p.getVehicule().getId()+"\'":"NULL")+""
                    + " WHERE `utilisateur`.`ID` = '"+p.getId()+"';";
            PreparedStatement statement = con.prepareStatement(requete);
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
    
    public void delete(Profil p){delete(p.getId());}
    
    public void delete(int id){
        Connection con=null;
        ResultSet rs=null;
	Statement sqlQuery=null;

	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(CONNEXIONSTRING);
            String requete;
            requete = "DELETE FROM `utilisateur` "
                    + "WHERE `utilisateur`.`ID` = '"+id+"';";
            PreparedStatement statement = con.prepareStatement(requete);
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
    
    public ArrayList<Profil> findAll(String etablissement, boolean conducteur){
        Connection con=null;
        ResultSet rs=null;
	Statement sqlQuery=null;
        int i=0;
        ArrayList<Profil> output;

	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(CONNEXIONSTRING);
            String requete;
            requete = "SELECT * FROM `utilisateur` "
                    + "WHERE `utilisateur`.`etablissement` = '"+etablissement+"'"
                    + "AND   `utilisateur`.`conducteur` = '"+(conducteur?1:0)+"'";
            // Executer la requete
            sqlQuery=con.createStatement();
            rs = sqlQuery.executeQuery(requete);
            // Definir un tableau de la du nombres de champs recu
            output = new ArrayList<>();
            while(rs.next()){
                output.add(new Profil());
                output.get(i).setId(Integer.parseInt(rs.getString("ID")));
                output.get(i).setUsername(rs.getString("username"));
                output.get(i).setEmail(rs.getString("email"));
                output.get(i).setNom(rs.getString("nom"));
                output.get(i).setPrenom(rs.getString("prenom"));
                output.get(i).setMotDePasse(rs.getString("motDePasse"));
                output.get(i).setRole(Integer.parseInt(rs.getString("role")));
                output.get(i).setDateInscription(rs.getString("dateInscription"));
                output.get(i).setDateConnexion(rs.getString("dateConnexion"));
                output.get(i).setCodePostal(rs.getString("codePostal"));
                output.get(i).setEtablissement(rs.getString("etablissement"));
                output.get(i).setImageProfil(rs.getString("imageProfil"));
                output.get(i).setNomPublic(("0".equals(rs.getString("nomPublic"))));
                output.get(i).setPrenomPublic(("0".equals(rs.getString("prenomPublic"))));
                output.get(i).setEmailPublic(("0".equals(rs.getString("emailPublic"))));
                output.get(i).setValide(("0".equals(rs.getString("valide"))));
                output.get(i).setConducteur(("0".equals(rs.getString("conducteur"))));
                if(rs.getString("note")!=null)output.get(i).setRating(Double.parseDouble(rs.getString("note")));
                if(rs.getString("tarif")!=null)output.get(i).setTarif(Double.parseDouble(rs.getString("tarif")));
                if(rs.getString("rayon")!=null)output.get(i).setRayon(Double.parseDouble(rs.getString("rayon")));
                // Verification du conducteur
                if("1".equals(rs.getString("conducteur")))output.get(i).setConducteur(true);
                    //p.setVehicule(v); // Achanger pour aller chercher le vehicule de la personne
                // Incrementer l'index
                i++;
            }
            return output;
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
        return null;
    }
}
