/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
public class EvaluationTest {
    
    public EvaluationTest() {
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
     * Test of getNote method, of class Evaluation.
     */
    @Test
    public void testGetNote() {
        System.out.println("getNote");
        Evaluation instance = new Evaluation(5);
        float expResult = 5;
        float result = instance.getNote();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setNote method, of class Evaluation.
     */
    @Test
    public void testSetNote() {
        System.out.println("setNote");
        float note = 5;
        Evaluation instance = new Evaluation(5);
        instance.setNote(note);
        assertEquals(5, instance.getNote(), 0.0);
    }

    /**
     * Test of getEtoilePleine method, of class Evaluation.
     */
    @Test
    public void testGetEtoilePleine() {
        System.out.println("getEtoilePleine");
        Evaluation instance = new Evaluation(3);
        int expResult = 3;
        int result = instance.getEtoilePleine();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEtoilePleine method, of class Evaluation.
     */
    @Test
    public void testSetEtoilePleine() {
        System.out.println("setEtoilePleine");
        int etoilePleine = 4;
        Evaluation instance = new Evaluation(3);
        instance.setEtoilePleine(etoilePleine);
        assertEquals(4, instance.getEtoilePleine(), 0.0);
    }

    /**
     * Test of getRestant method, of class Evaluation.
     */
    @Test
    public void testGetRestant() {
        System.out.println("getRestant");
        Evaluation instance = new Evaluation(4.1f);
        float expResult = 0.1f;
        float result = instance.getRestant();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setRestant method, of class Evaluation.
     */
    @Test
    public void testSetRestant() {
        System.out.println("setRestant");
        float restant = 0.2f;
        Evaluation instance = new Evaluation(4.1f);
        instance.setRestant(restant);
        assertEquals(0.2, instance.getRestant(), 0.1);
    }

    /**
     * Test of getEtoileVide method, of class Evaluation.
     */
    @Test
    public void testGetEtoileVide() {
        System.out.println("getEtoileVide");
        Evaluation instance = new Evaluation(3.1f);
        int expResult = 1;
        int result = instance.getEtoileVide();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEtoileVide method, of class Evaluation.
     */
    @Test
    public void testSetEtoileVide() {
        System.out.println("setEtoileVide");
        int etoileVide = 2;
        Evaluation instance = new Evaluation(2.1f);
        instance.setEtoileVide(etoileVide);
        assertEquals(2, instance.getEtoileVide());
    }
    
}
