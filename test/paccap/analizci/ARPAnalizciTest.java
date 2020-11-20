/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.analizci;

import jpcap.packet.Packet;
import junit.framework.TestCase;

/**
 *
 * @author muhsin
 */
public class ARPAnalizciTest extends TestCase {
    
    public ARPAnalizciTest(String testName) {
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
     * Test of isAnalyzable method, of class ARPAnalizci.
     */
    public void testIsAnalyzable() {
        System.out.println("isAnalyzable");
        Packet p = null;
        ARPAnalizci instance = new ARPAnalizci();
        boolean expResult = false;
        boolean result = instance.isAnalyzable(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtocolName method, of class ARPAnalizci.
     */
    public void testGetProtocolName() {
        System.out.println("getProtocolName");
        ARPAnalizci instance = new ARPAnalizci();
        String expResult = "";
        String result = instance.getProtocolName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueNames method, of class ARPAnalizci.
     */
    public void testGetValueNames() {
        System.out.println("getValueNames");
        ARPAnalizci instance = new ARPAnalizci();
        String[] expResult = null;
        String[] result = instance.getValueNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class ARPAnalizci.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        Packet p = null;
        ARPAnalizci instance = new ARPAnalizci();
        instance.analyze(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class ARPAnalizci.
     */
    public void testGetValue() {
        System.out.println("getValue");
        String degerAdi = "";
        ARPAnalizci instance = new ARPAnalizci();
        Object expResult = null;
        Object result = instance.getValue(degerAdi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class ARPAnalizci.
     */
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int index = 0;
        ARPAnalizci instance = new ARPAnalizci();
        Object expResult = null;
        Object result = instance.getValueAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class ARPAnalizci.
     */
    public void testGetValues() {
        System.out.println("getValues");
        ARPAnalizci instance = new ARPAnalizci();
        Object[] expResult = null;
        Object[] result = instance.getValues();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
