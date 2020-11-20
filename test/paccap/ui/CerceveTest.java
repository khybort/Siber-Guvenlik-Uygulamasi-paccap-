/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui;

import java.awt.event.ActionEvent;
import junit.framework.TestCase;
import paccap.Yakalayici;

/**
 *
 * @author muhsin
 */
public class CerceveTest extends TestCase {
    
    public CerceveTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of openNewWindow method, of class Cerceve.
     */
    public void testOpenNewWindow() {
        System.out.println("openNewWindow");
        Yakalayici yakalayici = null;
        Cerceve expResult = null;
        Cerceve result = Cerceve.openNewWindow(yakalayici);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class Cerceve.
     */
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        Cerceve instance = null;
        instance.actionPerformed(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of temizle method, of class Cerceve.
     */
    public void testTemizle() {
        System.out.println("temizle");
        Cerceve instance = null;
        instance.temizle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guncellemeyeBasla method, of class Cerceve.
     */
    public void testGuncellemeyeBasla() {
        System.out.println("guncellemeyeBasla");
        Cerceve instance = null;
        instance.guncellemeyeBasla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guncellemeyiDurdur method, of class Cerceve.
     */
    public void testGuncellemeyiDurdur() {
        System.out.println("guncellemeyiDurdur");
        Cerceve instance = null;
        instance.guncellemeyiDurdur();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nitelikleriYukle method, of class Cerceve.
     */
    public void testNitelikleriYukle() {
        System.out.println("nitelikleriYukle");
        Cerceve instance = null;
        instance.nitelikleriYukle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nitelikleriKaydet method, of class Cerceve.
     */
    public void testNitelikleriKaydet() {
        System.out.println("nitelikleriKaydet");
        Cerceve instance = null;
        instance.nitelikleriKaydet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of yakalamaDevrede method, of class Cerceve.
     */
    public void testYakalamaDevrede() {
        System.out.println("yakalamaDevrede");
        Cerceve instance = null;
        instance.yakalamaDevrede();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of yakalamaDevredisi method, of class Cerceve.
     */
    public void testYakalamaDevredisi() {
        System.out.println("yakalamaDevredisi");
        Cerceve instance = null;
        instance.yakalamaDevredisi();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
