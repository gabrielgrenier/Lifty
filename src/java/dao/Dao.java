package dao;

import classe.Profil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/* ==== INFO ====

 * @author maxime chausse
 * date : 6 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
 *
 * ==== A faire ==== 
*/
public abstract class Dao {
    // ==== VARIABLES ====
    protected static Connection con=null;
    protected static ResultSet rs=null;
    protected static Statement sqlQuery=null;
    protected static final String CONNEXIONSTRING = "jdbc:mysql://localhost/lifty?user=root&password=&serverTimezone=UTC&characterEncoding=UTF-8";
    
    // ==== METHODES ====
    public abstract Object findById(int id);
    public abstract void create(Object o);
    public abstract void update(Object o);
    public abstract void delete(int id);
    
    // ==== FONCTIONS ====
    
    // Fonction qui recois un resultat de requete et construit un profil avec
    // Elle peut faire une exception sql car elle n'est pas traiter a l'interieur
    protected static Object construireObject(ResultSet rs, Object o) throws SQLException{
        if(o instanceof Profil){
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
            p.setNomPublic(("0".equals(rs.getString("nomPublic"))));
            p.setPrenomPublic(("0".equals(rs.getString("prenomPublic"))));
            p.setEmailPublic(("0".equals(rs.getString("emailPublic"))));
            p.setValide(("0".equals(rs.getString("valide"))));
            p.setConducteur(("0".equals(rs.getString("conducteur"))));
            // Convertion valeurs des doubles
            if(rs.getString("note")!=null)p.setRating(Double.parseDouble(rs.getString("note")));
            if(rs.getString("tarif")!=null)p.setTarif(Double.parseDouble(rs.getString("tarif")));
            if(rs.getString("rayon")!=null)p.setRayon(Double.parseDouble(rs.getString("rayon")));
            // Verification du conducteur
            if("1".equals(rs.getString("conducteur")))p.setConducteur(true);
                //p.setVehicule(v); // Achanger pour aller chercher le vehicule de la personne
            return (Profil)p;
        }
        return null;
    }
    
    // Fonctions qui recouves et fermes les connexions ouvertes
    // lors des traitements dans les fonctions public
    protected static void fermerConnexions(Connection c, ResultSet r, Statement s){
        try{
            if (c!=null) c.close();
            if (r!=null) r.close();
            if (s!=null) s.close();
        }
        catch (SQLException e){System.out.println("Exception : "+e);}
    }
    protected static void fermerConnexions(Connection c, Statement s){fermerConnexions(c,null,s);}
}
