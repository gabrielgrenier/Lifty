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
    public void testFindById_int() {
        System.out.println("findById");
        int id = 0;
        MessageDAO instance = new MessageDAO();
        Object expResult = null;
        Object result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class MessageDAO.
     */
    @Test
    public void testFindById_String() {
        System.out.println("findById");
        String id = "";
        MessageDAO instance = new MessageDAO();
        Message expResult = null;
        Message result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class MessageDAO.
     */
    @Test
    public void testFindById_Message() {
        System.out.println("findById");
        Message m = null;
        MessageDAO instance = new MessageDAO();
        Message expResult = null;
        Message result = instance.findById(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class MessageDAO.
     */
    @Test
    public void testFindAll_int() {
        System.out.println("findAll");
        int idR = 0;
        MessageDAO instance = new MessageDAO();
        ListeMessage expResult = null;
        ListeMessage result = instance.findAll(idR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class MessageDAO.
     */
    @Test
    public void testFindAll_Profil() {
        System.out.println("findAll");
        Profil pR = null;
        MessageDAO instance = new MessageDAO();
        ListeMessage expResult = null;
        ListeMessage result = instance.findAll(pR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class MessageDAO.
     */
    @Test
    public void testFindAll_int_int() {
        System.out.println("findAll");
        int idE = 0;
        int idR = 0;
        MessageDAO instance = new MessageDAO();
        ListeMessage expResult = null;
        ListeMessage result = instance.findAll(idE, idR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class MessageDAO.
     */
    @Test
    public void testFindAll_Profil_Profil() {
        System.out.println("findAll");
        Profil pE = null;
        Profil pR = null;
        MessageDAO instance = new MessageDAO();
        ListeMessage expResult = null;
        ListeMessage result = instance.findAll(pE, pR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllVu_3args_1() {
        System.out.println("findAllVu");
        int idE = 0;
        int idR = 0;
        boolean vu = false;
        MessageDAO instance = new MessageDAO();
        ListeMessage expResult = null;
        ListeMessage result = instance.findAllVu(idE, idR, vu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllVu_int_int() {
        System.out.println("findAllVu");
        int idE = 0;
        int idR = 0;
        MessageDAO instance = new MessageDAO();
        ListeMessage expResult = null;
        ListeMessage result = instance.findAllVu(idE, idR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllVu_Profil_Profil() {
        System.out.println("findAllVu");
        Profil pE = null;
        Profil pR = null;
        MessageDAO instance = new MessageDAO();
        ListeMessage expResult = null;
        ListeMessage result = instance.findAllVu(pE, pR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllVu_3args_2() {
        System.out.println("findAllVu");
        Profil pE = null;
        Profil pR = null;
        boolean b = false;
        MessageDAO instance = new MessageDAO();
        ListeMessage expResult = null;
        ListeMessage result = instance.findAllVu(pE, pR, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllNonVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllNonVu_int() {
        System.out.println("findAllNonVu");
        int idR = 0;
        MessageDAO instance = new MessageDAO();
        ListeMessage expResult = null;
        ListeMessage result = instance.findAllNonVu(idR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllNonVu method, of class MessageDAO.
     */
    @Test
    public void testFindAllNonVu_Profil() {
        System.out.println("findAllNonVu");
        Profil p = null;
        MessageDAO instance = new MessageDAO();
        ListeMessage expResult = null;
        ListeMessage result = instance.findAllNonVu(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countNonVu method, of class MessageDAO.
     */
    @Test
    public void testCountNonVu_int_int() {
        System.out.println("countNonVu");
        int idE = 0;
        int idR = 0;
        MessageDAO instance = new MessageDAO();
        int expResult = 0;
        int result = instance.countNonVu(idE, idR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countNonVu method, of class MessageDAO.
     */
    @Test
    public void testCountNonVu_Profil_Profil() {
        System.out.println("countNonVu");
        Profil pE = null;
        Profil pR = null;
        MessageDAO instance = new MessageDAO();
        int expResult = 0;
        int result = instance.countNonVu(pE, pR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countNonVu method, of class MessageDAO.
     */
    @Test
    public void testCountNonVu_int() {
        System.out.println("countNonVu");
        int idR = 0;
        MessageDAO instance = new MessageDAO();
        int expResult = 0;
        int result = instance.countNonVu(idR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countNonVu method, of class MessageDAO.
     */
    @Test
    public void testCountNonVu_Profil() {
        System.out.println("countNonVu");
        Profil p = null;
        MessageDAO instance = new MessageDAO();
        int expResult = 0;
        int result = instance.countNonVu(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class MessageDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Object o = null;
        MessageDAO instance = new MessageDAO();
        instance.create(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSender method, of class MessageDAO.
     */
    @Test
    public void testGetSender_String() {
        System.out.println("getSender");
        String message = "";
        MessageDAO instance = new MessageDAO();
        Profil expResult = null;
        Profil result = instance.getSender(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSender method, of class MessageDAO.
     */
    @Test
    public void testGetSender_Message() {
        System.out.println("getSender");
        Message m = null;
        MessageDAO instance = new MessageDAO();
        Profil expResult = null;
        Profil result = instance.getSender(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MessageDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object o = null;
        MessageDAO instance = new MessageDAO();
        instance.update(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of envoyerMessage method, of class MessageDAO.
     */
    @Test
    public void testEnvoyerMessage_3args_1() {
        System.out.println("envoyerMessage");
        Message m = null;
        Profil envoyeur = null;
        Profil destinataire = null;
        MessageDAO instance = new MessageDAO();
        boolean expResult = false;
        boolean result = instance.envoyerMessage(m, envoyeur, destinataire);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of envoyerMessage method, of class MessageDAO.
     */
    @Test
    public void testEnvoyerMessage_3args_2() {
        System.out.println("envoyerMessage");
        Message m = null;
        int idEnvoyeur = 0;
        String usernameDestinataire = "";
        MessageDAO instance = new MessageDAO();
        boolean expResult = false;
        boolean result = instance.envoyerMessage(m, idEnvoyeur, usernameDestinataire);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of envoyerMessage method, of class MessageDAO.
     */
    @Test
    public void testEnvoyerMessage_3args_3() {
        System.out.println("envoyerMessage");
        Message m = null;
        String usernameEnvoyeur = "";
        String usernameDestinataire = "";
        MessageDAO instance = new MessageDAO();
        boolean expResult = false;
        boolean result = instance.envoyerMessage(m, usernameEnvoyeur, usernameDestinataire);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MessageDAO.
     */
    @Test
    public void testDelete_int() {
        System.out.println("delete");
        int id = 0;
        MessageDAO instance = new MessageDAO();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MessageDAO.
     */
    @Test
    public void testDelete_String() {
        System.out.println("delete");
        String id = "";
        MessageDAO instance = new MessageDAO();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of construireObjet method, of class MessageDAO.
     */
    @Test
    public void testConstruireObjet() throws Exception {
        System.out.println("construireObjet");
        ResultSet rs = null;
        MessageDAO instance = new MessageDAO();
        Message expResult = null;
        Message result = instance.construireObjet(rs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
