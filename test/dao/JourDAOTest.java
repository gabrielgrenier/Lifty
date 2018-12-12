/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Jour;
import classe.Profil;
import java.sql.ResultSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabri
 */
public class JourDAOTest {
    
    public JourDAOTest() {
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
     * Test of find method, of class JourDAO.
     */
    @Test
    public void testFind_int_String() {
        System.out.println("find");
        int idUser = 0;
        String jour = "";
        //int id, int userId, String jour, String debut, String fin
        Jour jourTemp = new Jour(999, 200, "lundi", "09:00:00", "10:00:00");
        JourDAO instance = new JourDAO();
        Jour expResult = null;
        Jour result = instance.find(idUser, jour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class JourDAO.
     */
    @Test
    public void testFind_Jour() {
        System.out.println("find");
        Jour j = null;
        JourDAO instance = new JourDAO();
        Jour expResult = null;
        Jour result = instance.find(j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class JourDAO.
     */
    @Test
    public void testFindAll_int() {
        System.out.println("findAll");
        int idUser = 0;
        JourDAO instance = new JourDAO();
        List<Jour> expResult = null;
        List<Jour> result = instance.findAll(idUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class JourDAO.
     */
    @Test
    public void testFindAll_Profil() {
        System.out.println("findAll");
        Profil p = null;
        JourDAO instance = new JourDAO();
        List<Jour> expResult = null;
        List<Jour> result = instance.findAll(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class JourDAO.
     */
    @Test
    public void testCreate_Object() {
        System.out.println("create");
        Object o = null;
        JourDAO instance = new JourDAO();
        instance.create(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class JourDAO.
     */
    @Test
    public void testCreate_5args() {
        System.out.println("create");
        int idJour = 0;
        int idUser = 0;
        String jour = "";
        String debut = "";
        String fin = "";
        JourDAO instance = new JourDAO();
        instance.create(idJour, idUser, jour, debut, fin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class JourDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object o = null;
        JourDAO instance = new JourDAO();
        instance.update(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class JourDAO.
     */
    @Test
    public void testFindById_int() {
        System.out.println("findById");
        int id = 0;
        JourDAO instance = new JourDAO();
        Object expResult = null;
        Object result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class JourDAO.
     */
    @Test
    public void testDelete_int() {
        System.out.println("delete");
        int id = 0;
        JourDAO instance = new JourDAO();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of construireObjet method, of class JourDAO.
     */
    @Test
    public void testConstruireObjet() throws Exception {
        System.out.println("construireObjet");
        ResultSet rs = null;
        JourDAO instance = new JourDAO();
        Jour expResult = null;
        Jour result = instance.construireObjet(rs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class JourDAO.
     */
    @Test
    public void testFindById_String() {
        System.out.println("findById");
        String id = "";
        JourDAO instance = new JourDAO();
        Object expResult = null;
        Object result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class JourDAO.
     */
    @Test
    public void testDelete_String() {
        System.out.println("delete");
        String id = "";
        JourDAO instance = new JourDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
