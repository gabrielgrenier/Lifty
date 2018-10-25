package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* ==== INFO ====

 * @author maxime chausse
 * date : 25 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class ConnexionBD {
    // ==== VARIABLES ====
    private static Connection laConnexion = null;
    private static String chainePilote = "com.mysql.cj.jdbc.Driver", 
            urlBD = "jdbc:mysql://localhost/lifty?user=root&password=&serverTimezone=EST";
    private static String user = "root",
            password = "";
    
    // ==== CONSTRUCTEUR ====
    private ConnexionBD() {}
    
    // ==== SETTERS ====
    public static void setChainePilote(String chainePilote) {ConnexionBD.chainePilote = chainePilote;}
    
    public static void setUrlBD(String urlBD) {ConnexionBD.urlBD = urlBD;}

    public static void setUser(String user) {ConnexionBD.user = user;}

    public static void setPassword(String password) {ConnexionBD.password = password;}
    
    // ==== METHODES ====
    public static void loadDriver(String driverString){
        try {Class.forName(driverString);
        } catch (ClassNotFoundException ex) {System.out.println("Erreur de driver : "+ex.getMessage());}
    }
    
    public static Connection getConnexion() {
        try {
            // Si la connexion n'est pas etablie ou a ete ferme
            if (laConnexion == null || laConnexion.isClosed()) {
                ConnexionBD.loadDriver(chainePilote);
                //Ouvrir la connexion à la BD
                if ("".equals(user))laConnexion = DriverManager.getConnection(urlBD);
                else laConnexion = DriverManager.getConnection(urlBD,user,password);
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
        return laConnexion;
    }
    
    public static void close() {
        if (laConnexion != null)
            try {
                laConnexion.close();
            } catch (SQLException ex) {System.out.println(ex);}
    }
}
