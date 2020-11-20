/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui;

import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.event.ListSelectionEvent;
import junit.framework.TestCase;

/**
 *
 * @author muhsin
 */
public class TabloPaneliTest extends TestCase {
    
    public TabloPaneliTest(String testName) {
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
     * Test of fireTableChanged method, of class TabloPaneli.
     */
    public void testFireTableChanged() {
        System.out.println("fireTableChanged");
        TabloPaneli instance = null;
        instance.fireTableChanged();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of temizle method, of class TabloPaneli.
     */
    public void testTemizle() {
        System.out.println("temizle");
        TabloPaneli instance = null;
        instance.temizle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tabloGorunumMenusunuYerlestir method, of class TabloPaneli.
     */
    public void testTabloGorunumMenusunuYerlestir() {
        System.out.println("tabloGorunumMenusunuYerlestir");
        JMenu menu = null;
        TabloPaneli instance = null;
        instance.tabloGorunumMenusunuYerlestir(menu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class TabloPaneli.
     */
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        TabloPaneli instance = null;
        instance.actionPerformed(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueChanged method, of class TabloPaneli.
     */
    public void testValueChanged() {
        System.out.println("valueChanged");
        ListSelectionEvent evt = null;
        TabloPaneli instance = null;
        instance.valueChanged(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nitelikleriYukle method, of class TabloPaneli.
     */
    public void testNitelikleriYukle() {
        System.out.println("nitelikleriYukle");
        TabloPaneli instance = null;
        instance.nitelikleriYukle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nitelikleriKaydet method, of class TabloPaneli.
     */
    public void testNitelikleriKaydet() {
        System.out.println("nitelikleriKaydet");
        TabloPaneli instance = null;
        instance.nitelikleriKaydet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
