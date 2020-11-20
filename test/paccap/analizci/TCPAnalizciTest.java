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
public class TCPAnalizciTest extends TestCase {
    
    public TCPAnalizciTest(String testName) {
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
     * Test of isAnalyzable method, of class TCPAnalizci.
     */
    public void testIsAnalyzable() {
        System.out.println("isAnalyzable");
        Packet p = new Packet();
        TCPAnalizci instance = new TCPAnalizci();
        boolean expResult = false;
        boolean result = instance.isAnalyzable(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProtocolName method, of class TCPAnalizci.
     */
    public void testGetProtocolName() {
        System.out.println("getProtocolName");
        TCPAnalizci instance = new TCPAnalizci();
        String expResult = "";
        String result = instance.getProtocolName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueNames method, of class TCPAnalizci.
     */
    public void testGetValueNames() {
        System.out.println("getValueNames");
        TCPAnalizci instance = new TCPAnalizci();
        String[] expResult = null;
        String[] result = instance.getValueNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class TCPAnalizci.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        Packet p = null;
        TCPAnalizci instance = new TCPAnalizci();
        instance.analyze(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class TCPAnalizci.
     */
    public void testGetValue() {
        System.out.println("getValue");
        String valueName = "";
        TCPAnalizci instance = new TCPAnalizci();
        Object expResult = null;
        Object result = instance.getValue(valueName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class TCPAnalizci.
     */
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int index = 0;
        TCPAnalizci instance = new TCPAnalizci();
        Object expResult = null;
        Object result = instance.getValueAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class TCPAnalizci.
     */
    public void testGetValues() {
        System.out.println("getValues");
        TCPAnalizci instance = new TCPAnalizci();
        Object[] expResult = null;
        Object[] result = instance.getValues();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
