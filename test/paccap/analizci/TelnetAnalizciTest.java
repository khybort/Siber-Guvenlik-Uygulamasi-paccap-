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
public class TelnetAnalizciTest extends TestCase {
    
    public TelnetAnalizciTest(String testName) {
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
     * Test of isAnalyzable method, of class TelnetAnalizci.
     */
    public void testIsAnalyzable() {
        System.out.println("isAnalyzable");
        Packet p = null;
        TelnetAnalizci instance = new TelnetAnalizci();
        boolean expResult = false;
        boolean result = instance.isAnalyzable(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtocolName method, of class TelnetAnalizci.
     */
    public void testGetProtocolName() {
        System.out.println("getProtocolName");
        TelnetAnalizci instance = new TelnetAnalizci();
        String expResult = "";
        String result = instance.getProtocolName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueNames method, of class TelnetAnalizci.
     */
    public void testGetValueNames() {
        System.out.println("getValueNames");
        TelnetAnalizci instance = new TelnetAnalizci();
        String[] expResult = null;
        String[] result = instance.getValueNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class TelnetAnalizci.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        Packet p = null;
        TelnetAnalizci instance = new TelnetAnalizci();
        instance.analyze(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class TelnetAnalizci.
     */
    public void testGetValue() {
        System.out.println("getValue");
        String s = "";
        TelnetAnalizci instance = new TelnetAnalizci();
        Object expResult = null;
        Object result = instance.getValue(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class TelnetAnalizci.
     */
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int i = 0;
        TelnetAnalizci instance = new TelnetAnalizci();
        Object expResult = null;
        Object result = instance.getValueAt(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class TelnetAnalizci.
     */
    public void testGetValues() {
        System.out.println("getValues");
        TelnetAnalizci instance = new TelnetAnalizci();
        Object[] expResult = null;
        Object[] result = instance.getValues();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
