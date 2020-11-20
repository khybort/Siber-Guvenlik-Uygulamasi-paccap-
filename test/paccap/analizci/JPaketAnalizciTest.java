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
public class JPaketAnalizciTest extends TestCase {
    
    public JPaketAnalizciTest(String testName) {
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
     * Test of isAnalyzable method, of class JPaketAnalizci.
     */
    public void testIsAnalyzable() {
        System.out.println("isAnalyzable");
        Packet packet = null;
        JPaketAnalizci instance = new JPaketAnalizciImpl();
        boolean expResult = false;
        boolean result = instance.isAnalyzable(packet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class JPaketAnalizci.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        Packet packet = null;
        JPaketAnalizci instance = new JPaketAnalizciImpl();
        instance.analyze(packet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProtocolName method, of class JPaketAnalizci.
     */
    public void testGetProtocolName() {
        System.out.println("getProtocolName");
        JPaketAnalizci instance = new JPaketAnalizciImpl();
        String expResult = "";
        String result = instance.getProtocolName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueNames method, of class JPaketAnalizci.
     */
    public void testGetValueNames() {
        System.out.println("getValueNames");
        JPaketAnalizci instance = new JPaketAnalizciImpl();
        String[] expResult = null;
        String[] result = instance.getValueNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class JPaketAnalizci.
     */
    public void testGetValue() {
        System.out.println("getValue");
        String valueName = "";
        JPaketAnalizci instance = new JPaketAnalizciImpl();
        Object expResult = null;
        Object result = instance.getValue(valueName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class JPaketAnalizci.
     */
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int index = 0;
        JPaketAnalizci instance = new JPaketAnalizciImpl();
        Object expResult = null;
        Object result = instance.getValueAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class JPaketAnalizci.
     */
    public void testGetValues() {
        System.out.println("getValues");
        JPaketAnalizci instance = new JPaketAnalizciImpl();
        Object[] expResult = null;
        Object[] result = instance.getValues();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class JPaketAnalizciImpl extends JPaketAnalizci {

        public boolean isAnalyzable(Packet packet) {
            return false;
        }

        public void analyze(Packet packet) {
        }

        public String getProtocolName() {
            return "";
        }

        public String[] getValueNames() {
            return null;
        }

        public Object getValue(String valueName) {
            return null;
        }

        public Object getValueAt(int index) {
            return null;
        }

        public Object[] getValues() {
            return null;
        }
    }
    
}
