/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classe.Profil;
import dao.ProfilDAO;
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
 * @author usager
 */
public class rechercheServiceTest {
    private static final ProfilDAO PROFILDAO = new ProfilDAO();
    
    public rechercheServiceTest() {
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
     * Test of rechercheUsername method, of class rechercheService.
     */
    @Test
    public void testRechercheUsername() {
        System.out.println("rechercheUsername");
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
        int expResult = 7;
        int result = rechercheService.rechercheUsername().size();
        for(Profil profil : p){
            Profil pro = PROFILDAO.findByEmail(profil.getEmail());
            PROFILDAO.delete(pro.getId());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of ListeUserAround method, of class rechercheService.
     */
    @Test
    public void testListeUserAround() {
        
        System.out.println("ListeUserAround");
        
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
        int expResult = 3;
        int result = rechercheService.ListeUserAround("test", false).size();
        for(Profil profil : p){
            Profil pro = PROFILDAO.findByEmail(profil.getEmail());
            PROFILDAO.delete(pro.getId());
        }
        assertEquals(expResult, result);
    }
    
}
