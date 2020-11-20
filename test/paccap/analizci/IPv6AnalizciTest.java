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
public class IPv6AnalizciTest extends TestCase {
    
    public IPv6AnalizciTest(String testName) {
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
     * Test of isAnalyzable method, of class IPv6Analizci.
     */
    public void testIsAnalyzable() {
        System.out.println("isAnalyzable");
        Packet p = null;
        IPv6Analizci instance = new IPv6Analizci();
        boolean expResult = false;
        boolean result = instance.isAnalyzable(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtocolName method, of class IPv6Analizci.
     */
    public void testGetProtocolName() {
        System.out.println("getProtocolName");
        IPv6Analizci instance = new IPv6Analizci();
        String expResult = "";
        String result = instance.getProtocolName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueNames method, of class IPv6Analizci.
     */
    public void testGetValueNames() {
        System.out.println("getValueNames");
        IPv6Analizci instance = new IPv6Analizci();
        String[] expResult = null;
        String[] result = instance.getValueNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class IPv6Analizci.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        Packet packet = null;
        IPv6Analizci instance = new IPv6Analizci();
        instance.analyze(packet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class IPv6Analizci.
     */
    public void testGetValue() {
        System.out.println("getValue");
        String valueName = "";
        IPv6Analizci instance = new IPv6Analizci();
        Object expResult = null;
        Object result = instance.getValue(valueName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class IPv6Analizci.
     */
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int index = 0;
        IPv6Analizci instance = new IPv6Analizci();
        Object expResult = null;
        Object result = instance.getValueAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class IPv6Analizci.
     */
    public void testGetValues() {
        System.out.println("getValues");
        IPv6Analizci instance = new IPv6Analizci();
        Object[] expResult = null;
        Object[] result = instance.getValues();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
