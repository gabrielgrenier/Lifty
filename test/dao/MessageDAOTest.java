/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.ListeMessage;
import classe.Message;
import classe.Profil;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mchausse
 */
public class MessageDAOTest {
    private static final MessageDAO MESSAGEDAO = new MessageDAO();
    private static final ProfilDAO PROFILDAO = new ProfilDAO();
    
    public MessageDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findById method, of class MessageDAO.
     */
    @Test
    public void testFindById_String() {
        // Cree le message a aller chercher
        Message m = new Message();
        Date dateTime = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        m.setId("ABCDE12345");
        m.setTitre("classe de test");
        m.setMessage("classe de test");
        m.setDate(date.format(dateTime));
        m.setTime(time.format(dateTime));
        m.setVu(false);
        MESSAGEDAO.create(m);
        
        // Comparer les noms 
        Object expResult = m.getId();
        Object result = MESSAGEDAO.findById("ABCDE12345").getId();
        
        // Supprimer le message pour le test
        MESSAGEDAO.delete("ABCDE12345");
        
        // Faire la verification des donnees recus
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class MessageDAO.
     */
    @Test
    public void testFindById_Message() {
        // Cree le message a aller chercher
        Message m = new Message();
        Date dateTime = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        m.setId("ABCDE12345");
        m.setTitre("classe de test");
        m.setMessage("classe de test");
        m.setDate(date.format(dateTime));
        m.setTime(time.format(dateTime));
        m.setVu(false);
        MESSAGEDAO.create(m);
        
        // Comparer les noms 
        Object expResult = m.getId();
        Object result = MESSAGEDAO.findById(m).getId();
        
        // Supprimer le message pour le test
        MESSAGEDAO.delete("ABCDE12345");
        
        // Faire la verification des donnees recus
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class MessageDAO.
     */
    @Test
    public void testFindAll_int() {
        System.out.println("findAll");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int idR = p.getId();
        int expResult = 3;
        int result = MESSAGEDAO.findAll(idR).length();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class MessageDAO.
     */
    @Test
    public void testFindAll_Profil() {
        System.out.println("findAll");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 3;
        int result = MESSAGEDAO.findAll(p).length();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class MessageDAO.
     */
    @Test
    public void testFindAll_int_int() {
        System.out.println("findAll");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 3;
        int result = MESSAGEDAO.findAll(p.getId(), p.getId()).length();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class MessageDAO.
     */
    @Test
    public void testFindAll_Profil_Profil() {
        System.out.println("findAll");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 3;
        int result = MESSAGEDAO.findAll(p, p).length();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllVu_3args_1() {
        System.out.println("findAll");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 1;
        int result = MESSAGEDAO.findAllVu(p.getId(), p.getId(), true).length();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllVu_int_int() {
        
        System.out.println("findAll");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 1;
        int result = MESSAGEDAO.findAllVu(p.getId(), p.getId()).length();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllVu_Profil_Profil() {
        
        System.out.println("findAll");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 1;
        int result = MESSAGEDAO.findAllVu(p, p).length();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllVu_3args_2() {
        
        System.out.println("findAll");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 1;
        int result = MESSAGEDAO.findAllVu(p, p, true).length();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllNonVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllNonVu_int() {
        System.out.println("findAll");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 2;
        int result = MESSAGEDAO.findAllNonVu(p.getId()).length();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllNonVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllNonVu_Profil() {
        System.out.println("findAll");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 2;
        int result = MESSAGEDAO.findAllNonVu(p).length();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of countNonVu method, of class MessageDAO.
     */
    @Test
    public void testCountNonVu_int_int() {
        System.out.println("countNonVu");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 1;
        int result = MESSAGEDAO.countNonVu(p.getId(), p.getId());
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of countNonVu method, of class MessageDAO.
     */
    @Test
    public void testCountNonVu_Profil_Profil() {
        System.out.println("countNonVu");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 1;
        int result = MESSAGEDAO.countNonVu(p, p);
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of countNonVu method, of class MessageDAO.
     */
    @Test
    public void testCountNonVu_int() {
        System.out.println("countNonVu");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 1;
        int result = MESSAGEDAO.countNonVu(p.getId());
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of countNonVu method, of class MessageDAO.
     */
    @Test
    public void testCountNonVu_Profil() {
        System.out.println("countNonVu");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("dateInscription");
        p.setDateConnexion("dateConnexion");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        
        // Envoyer 3 messages
        MESSAGEDAO.envoyerMessage(new Message("100000", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100001", "test", "de la classe", "2018-10-10", "09:20:19", true), p, p);
        MESSAGEDAO.envoyerMessage(new Message("100010", "test", "de la classe", "2018-10-10", "09:20:19", false), p, p);
        
        // Faire le traitement 
        int expResult = 1;
        int result = MESSAGEDAO.countNonVu(p);
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100000");
        MESSAGEDAO.delete("100001");
        MESSAGEDAO.delete("100010");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class MessageDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        // Cree le message a aller chercher
        Message m = new Message();
        Date dateTime = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        m.setId("ABCDE12345");
        m.setTitre("classe de test");
        m.setMessage("classe de test");
        m.setDate(date.format(dateTime));
        m.setTime(time.format(dateTime));
        m.setVu(false);
        MESSAGEDAO.create(m);
        
        // Comparer les noms 
        Object expResult = m.getId();
        Object result = MESSAGEDAO.findById("ABCDE12345").getId();
        
        // Supprimer le message pour le test
        MESSAGEDAO.delete("ABCDE12345");
        
        // Faire la verification des donnees recus
        assertEquals(expResult, result);
    }

    /**
     * Test of getSender method, of class MessageDAO.
     */
    @Test
    public void testGetSender_String() {
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("2018-10-03");
        p.setDateConnexion("2018-10-03");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        PROFILDAO.delete(p); 
        PROFILDAO.create(p); 
        
        // Envoyer 3 messages
        MESSAGEDAO.delete("110000");
        Message m = new Message("110000", "test", "de la classe", "2018-10-10", "09:20:19", true);
        MESSAGEDAO.envoyerMessage(m, p, p);
        
        // Faire le traitement 
        int expResult = p.getId();
        int result = MESSAGEDAO.getSender(m.getId()).getId();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("110000");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of getSender method, of class MessageDAO.
     */
    @Test
    public void testGetSender_Message() {
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("2018-10-03");
        p.setDateConnexion("2018-10-03");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        PROFILDAO.delete(p); 
        PROFILDAO.create(p); 
        
        // Envoyer 3 messages
        MESSAGEDAO.delete("110000");
        Message m = new Message("110000", "test", "de la classe", "2018-10-10", "09:20:19", true);
        MESSAGEDAO.envoyerMessage(m, p, p);
        
        // Faire le traitement 
        int expResult = p.getId();
        int result = MESSAGEDAO.getSender(m).getId();
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("110000");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class MessageDAO.
     */
    @Test
    public void testUpdate() {
        // Cree le message a aller chercher
        Message m = new Message();
        Date dateTime = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        m.setId("ABCDE12345");
        m.setTitre("classe de test");
        m.setMessage("classe de test");
        m.setDate(date.format(dateTime));
        m.setTime(time.format(dateTime));
        m.setVu(false);
        MESSAGEDAO.create(m);
        
        // Modifier le message
        m.setTitre("allo");
        MESSAGEDAO.update(m);
        
        // Comparer les noms 
        String expResult = m.getTitre();
        String result = MESSAGEDAO.findById(m).getTitre();
        
        // Supprimer le message pour le test
        MESSAGEDAO.delete("ABCDE12345");
        
        // afficher le resultat du test
        assertEquals(expResult, result);
    }

    /**
     * Test of envoyerMessage method, of class MessageDAO.
     */
    @Test
    public void testEnvoyerMessage_3args_1() {
        System.out.println("envoyerMessage");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("2018-10-03");
        p.setDateConnexion("2018-10-03");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        PROFILDAO.delete(p); 
        PROFILDAO.create(p); 
        
        // Envoyer le messages
        MESSAGEDAO.delete("101000");
        Message expResult = new Message("101000", "test", "de la classe", "2018-10-10", "09:20:19", false);
        MESSAGEDAO.envoyerMessage(expResult, p, p);
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("101000");
        
        int result = MESSAGEDAO.findAll(p, p).length();
        assertEquals(0, result);
    }

    /**
     * Test of envoyerMessage method, of class MessageDAO.
     */
    @Test
    public void testEnvoyerMessage_3args_2() {
        System.out.println("envoyerMessage");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("2018-10-03");
        p.setDateConnexion("2018-10-03");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        PROFILDAO.delete(p); 
        PROFILDAO.create(p); 
        
        // Envoyer le messages
        Message expResult = new Message("100100", "test", "de la classe", "2018-10-10", "09:20:19", false);
        MESSAGEDAO.envoyerMessage(expResult, p.getId(), p.getUsername());
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("100100");
        
        int result = MESSAGEDAO.findAll(p, p).length();
        assertEquals(0, result);
    }

    /**
     * Test of envoyerMessage method, of class MessageDAO.
     */
    @Test
    public void testEnvoyerMessage_3args_3() {
        System.out.println("envoyerMessage");
        // Cree un profil
        Profil p = new Profil();
        p.setId(100000);
        p.setNom("testMessageDAO");
        p.setPrenom("testMessageDAO");
        p.setUsername("username");
        p.setEmail("email");
        p.setMotDePasse("motDePasse");
        p.setRole(1);
        p.setDateInscription("2018-10-03");
        p.setDateConnexion("2018-10-03");
        p.setCodePostal("codePostal");
        p.setEtablissement("etablissement");
        p.setImageProfil("imageProfil");
        p.setNomPublic(true);
        p.setPrenomPublic(true);
        p.setEmailPublic(true);
        p.setValide(true);
        p.setConducteur(false);
        p.setRating(5);
        p.setTarif(5);
        p.setRayon(5);
        PROFILDAO.delete(p); 
        PROFILDAO.create(p); 
        
        // Envoyer le messages
        MESSAGEDAO.delete("200000");
        Message expResult = new Message("200000", "test", "de la classe", "2018-10-10", "09:20:19", false);
        MESSAGEDAO.envoyerMessage(expResult, p.getUsername(), p.getUsername());
        
        // Supprimer les donnes pour le test
        PROFILDAO.delete(p);
        MESSAGEDAO.delete("200000");
        
        int result = MESSAGEDAO.findAll(p, p).length();
        assertEquals(0, result);
    }

    /**
     * Test of delete method, of class MessageDAO.
     */
    @Test
    public void testDelete_String() {
        System.out.println("delete");
        // Cree le message
        Message m = new Message("30000", "test", "de la classe", "2018-10-10", "09:20:19", false);
        MESSAGEDAO.create(m);
        
        // Supprimer le message
        boolean result = MESSAGEDAO.delete(m.getId());
        
        // Verifier
        assertTrue(result);
    }

    /**
     * Test of construireObjet method, of class MessageDAO.
     */
    @Test
    public void testConstruireObjet() throws Exception {
        System.out.println("construireObjet");
        // Cree le message a aller chercher
        Message m = new Message();
        Date dateTime = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        m.setId("ABCDE12345");
        m.setTitre("classe de test");
        m.setMessage("classe de test");
        m.setDate(date.format(dateTime));
        m.setTime(time.format(dateTime));
        m.setVu(false);
        MESSAGEDAO.create(m);
        
        // Comparer les noms 
        Object expResult = m.getId();
        Object result = MESSAGEDAO.findById("ABCDE12345").getId();
        
        // Supprimer le message pour le test
        MESSAGEDAO.delete("ABCDE12345");
        
        assertEquals(expResult, result);
    }
    
}
