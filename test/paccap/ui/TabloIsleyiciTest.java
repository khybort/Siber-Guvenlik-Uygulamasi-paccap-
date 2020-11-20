/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui;

import java.awt.Component;
import javax.swing.JTable;
import junit.framework.TestCase;

/**
 *
 * @author muhsin
 */
public class TabloIsleyiciTest extends TestCase {
    
    public TabloIsleyiciTest(String testName) {
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
     * Test of getTableCellRendererComponent method, of class TabloIsleyici.
     */
    public void testGetTableCellRendererComponent() {
        System.out.println("getTableCellRendererComponent");
        JTable tablo = null;
        Object deger = null;
        boolean secildi = false;
        boolean odaklandi = false;
        int satir = 0;
        int sutun = 0;
        TabloIsleyici instance = new TabloIsleyici();
        Component expResult = null;
        Component result = instance.getTableCellRendererComponent(tablo, deger, secildi, odaklandi, satir, sutun);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
