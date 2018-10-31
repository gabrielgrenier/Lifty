package dao;
/* ==== INFO ====

 * @author maxime chausse
 * date : 19 septembre 2018
 * cour : Développement de projet informatique
 * College Rosemont
 *
 * ==== A faire ==== 
 * Arrangee le find pour assigner le vehicule au profil
*/
import java.sql.SQLException;
import classe.Profil;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfilDAO extends Dao{
    // Trouver un profil grace au email
    public Profil findByEmail(String email){
        String requete;
        try{
            requete = "SELECT * FROM utilisateur WHERE email = '"+email+"'";
            // Executer la requete
            rs = ouvrirConnexion().executeQuery(requete);
            // Construire le profil avec le resultat recu de la requete
            if(rs.next())return construireObjet(rs);
        }
        catch (SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    }
    public Profil findByEmail(Profil p){return findByEmail(p.getEmail());}
    
    @Override
    public Profil findById(int id) {
        String requete;
        try{
            //Ouverture de connexion 
            requete = "SELECT * FROM utilisateur WHERE ID = '"+id+"'";
            // Executer la requete
            rs = ouvrirConnexion().executeQuery(requete);
            // Construire le profil avec le resultat recu de la requete
            if(rs.next())return construireObjet(rs);
        }
        catch (SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    }
    public Profil findById(Profil p){return findById(p.getId());}
    
    public Profil findByUsername(String username){
        String requete;
        try{
            requete = "SELECT * FROM utilisateur WHERE username = '"+username+"'";
            rs = ouvrirConnexion().executeQuery(requete);
            // Construire le profil avec le resultat recu de la requete
            if(rs.next())return construireObjet(rs);
        }
        catch (SQLException |ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    }
    
    @Override
    public void create(Object o) {
        // Verifie que l'objet sois un Profil
        if(o instanceof Profil){
            // Caster l<objet en Profil
            Profil p=(Profil)o;
            String requete;
            try{
                requete = "INSERT INTO `utilisateur` (`ID`, `username`, `email`, `motDePasse`, "
                        + "`nom`, `prenom`, `role`, `conducteur`, "
                        + "`note`, `codePostal`, `emailPublic`, `nomPublic`, "
                        + "`prenomPublic`, `valide`, `dateInscription`, `dateConnexion`, "
                        + "`etablissement`, `rayon`, `tarif`, `imageProfil`, "
                        + "`vehiculeID`) "
                        + "VALUES (\'"+p.getId()+"\', \'"+p.getUsername()+"\', \'"+p.getEmail()+"\', \'"+p.getMotDePasse()+"\',"
                        + " \'"+p.getNom()+"\', \'"+p.getPrenom()+"\', \'"+p.getRole()+"\', \'"+(p.isConducteur()?1:0)+"\',"
                        + " \'"+p.getRating()+"\', \'"+p.getCodePostal()+"\', \'"+(p.isPublicEmail()?1:0)+"\', \'"+(p.isPublicNom()?1:0)+"\',"
                        + " \'"+(p.isPublicPrenom()?1:0)+"\', \'"+(p.isValide()?1:0)+"\', \'"+p.getDateInscription()+"\', \'"+p.getDateConnexion()+"\',"
                        + " "+(p.getEtablissement()!=null?"\'"+p.getEtablissement()+"\'":"NULL")+", \'"+p.getRayon()+"\', \'"+p.getTarif()+"\', "+(p.getImageProfil()!=null?"\'"+p.getImageProfil()+"\'":"NULL")+", "
                        + ""+(p.getVehicule()!=null?"\'"+p.getVehicule().getId()+"\'":"NULL")+")";
                ouvrirConnexion().executeUpdate(requete);
            }
            catch (SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
            finally{fermerConnexions(con,rs,sqlQuery);}
        }
    }
    
    @Override
    public void update(Object o) {
        // Verifie que l'objet sois un Profil
        if(o instanceof Profil){
            String requete;
            // Caster l<objet en Profil
            Profil p = (Profil)o;
            try{
                // Faire le requete qui va aller updater tous les champs 
                requete = "UPDATE `utilisateur` SET `ID` = '"+p.getId()+"', `username`='"+p.getUsername()+"', "
                        + "`email`='"+p.getEmail()+"',                      `motDePasse` = '"+p.getMotDePasse()+"',             `nom` = '"+p.getNom()+"', "
                        + "`prenom`='"+p.getPrenom()+"',                    `role` = '"+p.getRole()+"',                         `conducteur` = '"+(p.isConducteur()?1:0)+"', "
                        + "`note`='"+p.getRating()+"',                      `codePostal` = '"+p.getCodePostal()+"',             `emailPublic` = '"+(p.isPublicEmail()?1:0)+"', "
                        + "`nomPublic`='"+(p.isPublicNom()?1:0)+"',         `prenomPublic` = '"+(p.isPublicPrenom()?1:0)+"',    `valide` = '"+(p.isValide()?1:0)+"', "
                        + "`dateInscription`='"+p.getDateInscription()+"',  `dateConnexion` = '"+p.getDateConnexion()+"',       `etablissement` = "+(p.getEtablissement()!=null?"\'"+p.getEtablissement()+"\'":"NULL")+", "
                        + "`rayon`='"+p.getRayon()+"',                      `tarif` = '"+p.getTarif()+"',                       `imageProfil` = "+(p.getImageProfil()!=null?"\'"+p.getImageProfil()+"\'":"NULL")+", "
                        + "`vehiculeID`="+(p.getVehicule()!=null?"\'"+p.getVehicule().getId()+"\'":"NULL")+""
                        + " WHERE `utilisateur`.`ID` = '"+p.getId()+"';";
                // Executer la requete
                ouvrirConnexion().executeUpdate(requete);
            }
            catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
            finally{fermerConnexions(con,rs,sqlQuery);}
        }
    }
    
    @Override
    public void delete(int id) {
        String requete;
        try{
            requete = "DELETE FROM `utilisateur` "
                    + "WHERE `utilisateur`.`ID` = '"+id+"';";
            // Executer la requete
            ouvrirConnexion().executeUpdate(requete);
        }
        catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
        finally{fermerConnexions(con,rs,sqlQuery);}
    }
    public void delete(Profil p){delete(p.getId());}
    
    public ArrayList<Profil> findAll(){
        // Variable qui sera retourner et qui va contenir les profils
        ArrayList<Profil> output;
        String requete;
	try{
            //Construire la requete
            requete = "SELECT * FROM `utilisateur`";
            // Executer la requete
            rs = ouvrirConnexion().executeQuery(requete);
            // Definir un tableau de la du nombres de champs recu
            output = new ArrayList<>();
            // Construire un profil et le mettre dans la liste pour chaque donnees recu
            while(rs.next()) output.add(construireObjet(rs));
            return output;
	}
        catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    }
    public ArrayList<Profil> findAll(String etablissement, boolean conducteur){
        // Variable qui sera retourner et qui va contenir les profils
        ArrayList<Profil> output;
        String requete;
	try{
            //Construire la requete
            requete = "SELECT * FROM `utilisateur` WHERE";
            if(etablissement!=null)requete += " `utilisateur`.`etablissement` = '"+etablissement+"' AND";
            if(conducteur){requete += " `utilisateur`.`conducteur` = false";}
            else{requete += " `utilisateur`.`conducteur` = true";}
            // Executer la requete
            rs = ouvrirConnexion().executeQuery(requete);
            // Definir un tableau de la du nombres de champs recu
            output = new ArrayList<>();
            // Construire un profil et le mettre dans la liste pour chaque donnees recu
            while(rs.next()) output.add(construireObjet(rs));
            return output;
	}
        catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    }
    public ArrayList<Profil> findAll(boolean conducteur){return findAll(null,conducteur);}
    
        // Fonction qui recois un resultat de requete et construit un profil avec
    // Elle peut faire une exception sql car elle n'est pas traiter a l'interieur
    @Override
    public Profil construireObjet(ResultSet rs) throws SQLException{
        Profil p=new Profil();
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
        // Convertion des valeurs en boolean
        p.setNomPublic(("1".equals(rs.getString("nomPublic"))));
        p.setPrenomPublic(("1".equals(rs.getString("prenomPublic"))));
        p.setEmailPublic(("1".equals(rs.getString("emailPublic"))));
        p.setValide(("1".equals(rs.getString("valide"))));
        p.setConducteur(("1".equals(rs.getString("conducteur"))));
        // Convertion valeurs des doubles
        if(rs.getString("note")!=null)p.setRating(Double.parseDouble(rs.getString("note")));
        if(rs.getString("tarif")!=null)p.setTarif(Double.parseDouble(rs.getString("tarif")));
        if(rs.getString("rayon")!=null)p.setRayon(Double.parseDouble(rs.getString("rayon")));
        // Verification du conducteur
        if("1".equals(rs.getString("conducteur")))p.setConducteur(true);
            //p.setVehicule(v); // Achanger pour aller chercher le vehicule de la personne
        return p;
    }
}
