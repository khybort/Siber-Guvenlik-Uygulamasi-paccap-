/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.stat;

import java.util.List;
import jpcap.packet.Packet;
import junit.framework.TestCase;

/**
 *
 * @author muhsin
 */
public class UygulamaProtokolIstatistigiTest extends TestCase {
    
    public UygulamaProtokolIstatistigiTest(String testName) {
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
     * Test of getName method, of class UygulamaProtokolIstatistigi.
     */
    public void testGetName() {
        System.out.println("getName");
        UygulamaProtokolIstatistigi instance = new UygulamaProtokolIstatistigi();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class UygulamaProtokolIstatistigi.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        List<Packet> packets = null;
        UygulamaProtokolIstatistigi instance = new UygulamaProtokolIstatistigi();
        instance.analyze(packets);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPacket method, of class UygulamaProtokolIstatistigi.
     */
    public void testAddPacket() {
        System.out.println("addPacket");
        Packet p = null;
        UygulamaProtokolIstatistigi instance = new UygulamaProtokolIstatistigi();
        instance.addPacket(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLabels method, of class UygulamaProtokolIstatistigi.
     */
    public void testGetLabels() {
        System.out.println("getLabels");
        UygulamaProtokolIstatistigi instance = new UygulamaProtokolIstatistigi();
        String[] expResult = null;
        String[] result = instance.getLabels();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatTypes method, of class UygulamaProtokolIstatistigi.
     */
    public void testGetStatTypes() {
        System.out.println("getStatTypes");
        UygulamaProtokolIstatistigi instance = new UygulamaProtokolIstatistigi();
        String[] expResult = null;
        String[] result = instance.getStatTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class UygulamaProtokolIstatistigi.
     */
    public void testGetValues() {
        System.out.println("getValues");
        int index = 0;
        UygulamaProtokolIstatistigi instance = new UygulamaProtokolIstatistigi();
        long[] expResult = null;
        long[] result = instance.getValues(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class UygulamaProtokolIstatistigi.
     */
    public void testClear() {
        System.out.println("clear");
        UygulamaProtokolIstatistigi instance = new UygulamaProtokolIstatistigi();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
