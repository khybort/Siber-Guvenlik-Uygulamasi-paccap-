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
public class HTTPAnalizciTest extends TestCase {
    
    public HTTPAnalizciTest(String testName) {
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
     * Test of isAnalyzable method, of class HTTPAnalizci.
     */
    public void testIsAnalyzable() {
        System.out.println("isAnalyzable");
        Packet p = null;
        HTTPAnalizci instance = new HTTPAnalizci();
        boolean expResult = false;
        boolean result = instance.isAnalyzable(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtocolName method, of class HTTPAnalizci.
     */
    public void testGetProtocolName() {
        System.out.println("getProtocolName");
        HTTPAnalizci instance = new HTTPAnalizci();
        String expResult = "";
        String result = instance.getProtocolName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueNames method, of class HTTPAnalizci.
     */
    public void testGetValueNames() {
        System.out.println("getValueNames");
        HTTPAnalizci instance = new HTTPAnalizci();
        String[] expResult = null;
        String[] result = instance.getValueNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class HTTPAnalizci.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        Packet p = null;
        HTTPAnalizci instance = new HTTPAnalizci();
        instance.analyze(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class HTTPAnalizci.
     */
    public void testGetValue() {
        System.out.println("getValue");
        String degerAdi = "";
        HTTPAnalizci instance = new HTTPAnalizci();
        Object expResult = null;
        Object result = instance.getValue(degerAdi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class HTTPAnalizci.
     */
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int indeks = 0;
        HTTPAnalizci instance = new HTTPAnalizci();
        Object expResult = null;
        Object result = instance.getValueAt(indeks);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class HTTPAnalizci.
     */
    public void testGetValues() {
        System.out.println("getValues");
        HTTPAnalizci instance = new HTTPAnalizci();
        Object[] expResult = null;
        Object[] result = instance.getValues();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
