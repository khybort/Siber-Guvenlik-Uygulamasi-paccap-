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
public class PaketAnalizciTest extends TestCase {
    
    public PaketAnalizciTest(String testName) {
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
     * Test of isAnalyzable method, of class PaketAnalizci.
     */
    public void testIsAnalyzable() {
        System.out.println("isAnalyzable");
        Packet packet = null;
        PaketAnalizci instance = new PaketAnalizci();
        boolean expResult = false;
        boolean result = instance.isAnalyzable(packet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtocolName method, of class PaketAnalizci.
     */
    public void testGetProtocolName() {
        System.out.println("getProtocolName");
        PaketAnalizci instance = new PaketAnalizci();
        String expResult = "";
        String result = instance.getProtocolName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueNames method, of class PaketAnalizci.
     */
    public void testGetValueNames() {
        System.out.println("getValueNames");
        PaketAnalizci instance = new PaketAnalizci();
        String[] expResult = null;
        String[] result = instance.getValueNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class PaketAnalizci.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        Packet p = null;
        PaketAnalizci instance = new PaketAnalizci();
        instance.analyze(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class PaketAnalizci.
     */
    public void testGetValue() {
        System.out.println("getValue");
        String name = "";
        PaketAnalizci instance = new PaketAnalizci();
        Object expResult = null;
        Object result = instance.getValue(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class PaketAnalizci.
     */
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int index = 0;
        PaketAnalizci instance = new PaketAnalizci();
        Object expResult = null;
        Object result = instance.getValueAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class PaketAnalizci.
     */
    public void testGetValues() {
        System.out.println("getValues");
        PaketAnalizci instance = new PaketAnalizci();
        Object[] expResult = null;
        Object[] result = instance.getValues();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
