/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui;

import junit.framework.TestCase;
import paccap.analizci.JPaketAnalizci;

/**
 *
 * @author muhsin
 */
public class TabloTest extends TestCase {
    
    public TabloTest(String testName) {
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
     * Test of fireTableChanged method, of class Tablo.
     */
    public void testFireTableChanged() {
        System.out.println("fireTableChanged");
        Tablo instance = null;
        instance.fireTableChanged();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of temizle method, of class Tablo.
     */
    public void testTemizle() {
        System.out.println("temizle");
        Tablo instance = null;
        instance.temizle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTableView method, of class Tablo.
     */
    public void testSetTableView() {
        System.out.println("setTableView");
        JPaketAnalizci analizci = null;
        String ad = "";
        boolean set = false;
        Tablo instance = null;
        instance.setTableView(analizci, ad, set);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tabloGorunumDurumunuGetir method, of class Tablo.
     */
    public void testTabloGorunumDurumunuGetir() {
        System.out.println("tabloGorunumDurumunuGetir");
        Tablo instance = null;
        String[] expResult = null;
        String[] result = instance.tabloGorunumDurumunuGetir();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
