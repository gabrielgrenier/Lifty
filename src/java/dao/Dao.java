package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import singleton.ConnexionBD;
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
    
    // ==== METHODES ====
    public abstract Object findById(int id);
    public abstract Object findById(String id);
    public abstract void create(Object o);
    public abstract void update(Object o);
    public abstract void delete(int id);
    public abstract boolean delete(String id);
    
    // ==== FONCTIONS ====
    
    // Fonction qui recois un resultat de requete et construit un profil avec
    // Elle peut faire une exception sql car elle n'est pas traiter a l'interieur
    public abstract Object construireObjet(ResultSet rs) throws SQLException;
    
    protected Statement ouvrirConnexion()throws SQLException{
        // Ouverture de connexion et retour du statement
        return ConnexionBD.getConnexion().createStatement();
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
