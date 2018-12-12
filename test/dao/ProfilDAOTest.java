/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Profil;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samuel
 */
public class ProfilDAOTest {
     private static final ProfilDAO PROFILDAO = new ProfilDAO();
    
    public ProfilDAOTest() {
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
     * Test of findById method, of class ProfilDAO.
     */
    @Test
    public void testFindById_int() {
        System.out.println("findById");
        Profil p1;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        p1 = new Profil(0,"test","pun@p","pun","pun","pun",2,sm.format(new Date()),sm.format(new Date()),"H0H 0H0","test",null,true,true,true,true,true,5,0,0);
        PROFILDAO.create(p1);
        List<Profil> p = new ArrayList();
        p.add(p1);
        String expResult = p1.getNom();
        String result = "";
        for(Profil profil : p){
            Profil pro = PROFILDAO.findByEmail(profil.getEmail());
            result = pro.getNom();
            PROFILDAO.delete(pro.getId());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class ProfilDAO.
     */
    @Test
    public void testFindById_Profil() {
        System.out.println("findById");
        Profil p1;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        p1 = new Profil(0,"test","pun@p","pun","pun","pun",2,sm.format(new Date()),sm.format(new Date()),"H0H 0H0","test",null,true,true,true,true,true,5,0,0);
        PROFILDAO.create(p1);
        List<Profil> p = new ArrayList();
        p.add(p1);
        String expResult = p1.getNom();
        String result = "";
        for(Profil profil : p){
            Profil pro = PROFILDAO.findByEmail(profil.getEmail());
            result = pro.getNom();
            PROFILDAO.delete(pro.getId());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of findByUsername method, of class ProfilDAO.
     */
    @Test
    public void testFindByUsername() {
        System.out.println("findByUsername");
        Profil p1;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        p1 = new Profil(0,"test","pun@p","pun","pun","pun",2,sm.format(new Date()),sm.format(new Date()),"H0H 0H0","test",null,true,true,true,true,true,5,0,0);
        PROFILDAO.create(p1);
        List<Profil> p = new ArrayList();
        p.add(p1);
        String expResult = "test";
        String result = PROFILDAO.findByUsername(expResult).getUsername();
        for(Profil profil : p){
            Profil pro = PROFILDAO.findByEmail(profil.getEmail());
            PROFILDAO.delete(pro.getId());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class ProfilDAO.
     */
    @Test
    public void testDelete_int() {
        System.out.println("delete");
        Profil p1, p2, p3;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        p1 = new Profil(0,"test","pun@p","pun","pun","pun",2,sm.format(new Date()),sm.format(new Date()),"H0H 0H0","test",null,true,true,true,true,true,5,0,0);
        p2 = new Profil(0,"test","pd@p","pd","pd","pd",2,sm.format(new Date()),sm.format(new Date()),"H0H 0H0","test",null,true,true,true,true,true,5,0,0);
        p3 = new Profil(0,"test","pt@p","pt","pt","pt",2,sm.format(new Date()),sm.format(new Date()),"H0H 0H0","test",null,true,true,true,true,true,5,0,0);
        PROFILDAO.create(p1);
        PROFILDAO.create(p2);
        PROFILDAO.create(p3);
        List<Profil> p = new ArrayList();
        p.add(p1);
        p.add(p2);
        p.add(p3);
        int expResult = 4;
        for(Profil profil : p){
            Profil pro = PROFILDAO.findByEmail(profil.getEmail());
            PROFILDAO.delete(pro.getId());
        }
        int result = PROFILDAO.findAll().size();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class ProfilDAO.
     */
    @Test
    public void testDelete_Profil() {
        System.out.println("delete");
        
        Profil p1, p2, p3;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        p1 = new Profil(0,"test","pun@p","pun","pun","pun",2,sm.format(new Date()),sm.format(new Date()),"H0H 0H0","test",null,true,true,true,true,true,5,0,0);
        p2 = new Profil(0,"test","pd@p","pd","pd","pd",2,sm.format(new Date()),sm.format(new Date()),"H0H 0H0","test",null,true,true,true,true,true,5,0,0);
        p3 = new Profil(0,"test","pt@p","pt","pt","pt",2,sm.format(new Date()),sm.format(new Date()),"H0H 0H0","test",null,true,true,true,true,true,5,0,0);
        PROFILDAO.create(p1);
        PROFILDAO.create(p2);
        PROFILDAO.create(p3);
        List<Profil> p = new ArrayList();
        p.add(p1);
        p.add(p2);
        p.add(p3);
        int expResult = 4;
        for(Profil profil : p){
            Profil pro = PROFILDAO.findByEmail(profil.getEmail());
            PROFILDAO.delete(pro);
        }
        int result = PROFILDAO.findAll().size();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class ProfilDAO.
     */
    @Test
    public void testFindAll_0args() {
        System.out.println("findAll");
        int expResult = 4;
        int result = PROFILDAO.findAll().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class ProfilDAO.
     */
    @Test
    public void testFindAll_boolean() {
        System.out.println("findAll");
        int expResult = 2;
        int result = PROFILDAO.findAll(true).size();
        assertEquals(expResult, result);
    }
    
}
