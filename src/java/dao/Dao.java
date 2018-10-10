package dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
    protected abstract Object construireObjet(ResultSet rs) throws SQLException;
    
    protected Statement ouvrirConnexion()throws SQLException, ClassNotFoundException{
        //Chargement du pilote 
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Ouverture de connexion 
        con = DriverManager.getConnection(CONNEXIONSTRING);
        // Executer la requete
        return con.createStatement();
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
