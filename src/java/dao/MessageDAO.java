package dao;

import classe.ListeMessage;
import classe.Message;
import classe.Profil;
import java.sql.ResultSet;
import java.sql.SQLException;

/* ==== INFO ====

 * @author maxime chausse
 * date : 14 octobre 2018
 * cour : Développement de projet informatique
 * College Rosemont
*/
public class MessageDAO extends Dao{

    @Override
    public Message findById(int id) {
        String requete;
        try{
            requete = "SELECT * FROM message WHERE ID = '"+id+"'";
            // Executer la requete
            rs = ouvrirConnexion().executeQuery(requete);
            // Construire le profil avec le resultat recu de la requete
            if(rs.next())return construireObjet(rs);
                System.out.println(requete);
        }
        catch (SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    }
    public Message findById(Message m){return findById(m.getId());}
    
    public ListeMessage findAll(int idE, int idR){
        // Variable qui sera retourner et qui va contenir les profils
        ListeMessage output;
        String requete;
        String sousRequete;
	try{
            //Construire la requete
            sousRequete = "SELECT messageID FROM `messageutilisateur` WHERE `messageutilisateur`.`receveurID` = '"+idR+"' AND `messageutilisateur`.`envoyeurID` = '"+idE+"'";
            requete = "SELECT * FROM message WHERE message.ID IN ( "+sousRequete+" )";
            // Executer la requete
            System.out.println(sousRequete);
            System.out.println(requete);
            rs = ouvrirConnexion().executeQuery(requete);
            // Definir un tableau de la du nombres de champs recu
            output = new ListeMessage();
            // Construire un profil et le mettre dans la liste pour chaque donnees recu
            while(rs.next()) output.add((Message)construireObjet(rs));
            return output;
	}
        catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    }
    public ListeMessage findAll(Profil pE, Profil pR){return findAll(pE.getId(),pR.getId());}
    
    public ListeMessage findAllVu(int idE, int idR, boolean vu){
        // Variable qui sera retourner et qui va contenir les profils
        ListeMessage output;
        String requete;
        String sousRequete;
	try{
            //Construire la requete
            sousRequete = "SELECT messageID FROM `messageutilisateur` WHERE `messageutilisateur`.`receveurID` = '"+idR+"' AND `messageutilisateur`.`envoyeurID` = '"+idE+"'";
            requete = "SELECT * FROM message WHERE message.vu = '"+(vu?1:0)+"' AND message.ID IN ("+sousRequete+")";
            // Executer la requete
            System.out.println(requete);
            rs = ouvrirConnexion().executeQuery(requete);
            System.out.println(requete);
            // Definir un tableau de la du nombres de champs recu
            output = new ListeMessage();
            // Construire un profil et le mettre dans la liste pour chaque donnees recu
            while(rs.next()) output.add(construireObjet(rs));
            return output;
	}
        catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    }
    public ListeMessage findAllVu(int idE, int idR){return findAllVu(idE,idR,true);}
    public ListeMessage findAllVu(Profil pE, Profil pR){return findAllVu(pE.getId(),pR.getId(),true);}
    public ListeMessage findAllVu(Profil pE, Profil pR, boolean b){return findAllVu(pE.getId(),pR.getId(),b);}
    
    public ListeMessage findAllNonVu(int idR){
        // Variable qui sera retourner et qui va contenir les profils
        ListeMessage output;
        String requete;
        String sousRequete;
	try{
            //Construire la requete
            sousRequete = "SELECT messageID FROM `messageutilisateur` WHERE `messageutilisateur`.`receveurID` = '"+idR+"'";
            requete = "SELECT * FROM message WHERE message.ID IN ("+sousRequete+")";
            // Executer la requete
            System.out.println(requete);
            rs = ouvrirConnexion().executeQuery(requete);
            // Definir un tableau de la du nombres de champs recu
            output = new ListeMessage();
            // Construire un profil et le mettre dans la liste pour chaque donnees recu
            while(rs.next()) output.add(construireObjet(rs));
            return output;
	}
        catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return null;
    
    }
    public ListeMessage findAllNonVu(Profil p){return findAllNonVu(p.getId());}
    
    // Retourne le nombre de message qui non pas encore ete vu/ouvert
    public int countNonVu(int idE, int idR){return findAllVu(idE,idR,false).length();}
    public int countNonVu(Profil pE, Profil pR){return findAllVu(pE.getId(),pR.getId(),false).length();}
    public int countNonVu(int idR){
        // Variable qui sera retourner et qui va contenir les profils
        int i =0;
        String requete;
        String sousRequete;
	try{
            //Construire la requete
            sousRequete = "SELECT messageID FROM `messageutilisateur` WHERE `messageutilisateur`.`receveurID` = '"+idR+"'";
            requete = "SELECT * FROM message WHERE message.vu = '0' AND message.ID IN ("+sousRequete+")";
            // Executer la requete
            System.out.println(requete);
            rs = ouvrirConnexion().executeQuery(requete);
            // Construire un profil et le mettre dans la liste pour chaque donnees recu
            while(rs.next()) i++;
            return i;
	}
        catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
	finally{fermerConnexions(con,rs,sqlQuery);}
        return -1;
        
    }
    public int countNonVu(Profil p){return countNonVu(p.getId());}
    
    @Override
    public void create(Object o) {
        // Verifie que l'objet sois un Profil
        if(o instanceof Message){
            // Caster l<objet en Profil
            Message p=(Message)o;
            String requete;
            try{
                requete = "INSERT INTO `message` (`ID`, `titre`, `message`, `date`, `time`, `vu`) "
                        + "VALUES (\'"+p.getId()+"\', \'"+p.getTitre()+"\', \'"+p.getMessage()+"\', \'"+p.getDate()+"\', \'"+p.getTime()+"\', \'"+(p.isVu()?1:0)+"\')";
                System.out.println(requete);
                ouvrirConnexion().executeUpdate(requete);
            }
            catch (SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
            finally{fermerConnexions(con,rs,sqlQuery);}
        }
    }

    @Override
    public void update(Object o) {// Pas tester
        // Verifie que l'objet sois un Profil
        if(o instanceof Message){
            String requete;
            // Caster l<objet en Profil
            Message ms = (Message)o;
            try{
                // Faire le requete qui va aller updater tous les champs 
                requete = "UPDATE `message` SET `ID` = '"+ms.getId()+"', `titre`='"+ms.getTitre()+"', "
                        + "`message`="+ms.getMessage()+" `date`="+ms.getDate()+" `time`="+ms.getTime()+" `vu`="+(ms.isVu()?1:0)+""
                        + " WHERE `message`.`ID` = '"+ms.getId()+"';";
                // Executer la requete
                ouvrirConnexion().executeUpdate(requete);
            }
            catch(SQLException | ClassNotFoundException e){System.out.println("Exception : "+e);}
            finally{fermerConnexions(con,rs,sqlQuery);}
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Message construireObjet(ResultSet rs) throws SQLException {
        Message m = new Message();
        m.setId(Integer.parseInt(rs.getString("ID")));
        m.setMessage(rs.getString("message"));
        m.setTitre(rs.getString("titre"));
        m.setDate(rs.getString("date"));
        m.setTime(rs.getString("time"));
        m.setVu("0".equals(rs.getString("vu")));
        System.out.println(m);
        return m;
    }
    
}
