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
public class POP3AnalizciTest extends TestCase {
    
    public POP3AnalizciTest(String testName) {
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
     * Test of isAnalyzable method, of class POP3Analizci.
     */
    public void testIsAnalyzable() {
        System.out.println("isAnalyzable");
        Packet p = null;
        POP3Analizci instance = new POP3Analizci();
        boolean expResult = false;
        boolean result = instance.isAnalyzable(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtocolName method, of class POP3Analizci.
     */
    public void testGetProtocolName() {
        System.out.println("getProtocolName");
        POP3Analizci instance = new POP3Analizci();
        String expResult = "";
        String result = instance.getProtocolName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueNames method, of class POP3Analizci.
     */
    public void testGetValueNames() {
        System.out.println("getValueNames");
        POP3Analizci instance = new POP3Analizci();
        String[] expResult = null;
        String[] result = instance.getValueNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class POP3Analizci.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        Packet p = null;
        POP3Analizci instance = new POP3Analizci();
        instance.analyze(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class POP3Analizci.
     */
    public void testGetValue() {
        System.out.println("getValue");
        String s = "";
        POP3Analizci instance = new POP3Analizci();
        Object expResult = null;
        Object result = instance.getValue(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class POP3Analizci.
     */
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int i = 0;
        POP3Analizci instance = new POP3Analizci();
        Object expResult = null;
        Object result = instance.getValueAt(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class POP3Analizci.
     */
    public void testGetValues() {
        System.out.println("getValues");
        POP3Analizci instance = new POP3Analizci();
        Object[] expResult = null;
        Object[] result = instance.getValues();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
