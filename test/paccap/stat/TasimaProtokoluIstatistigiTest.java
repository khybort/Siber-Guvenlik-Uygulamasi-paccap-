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
public class TasimaProtokoluIstatistigiTest extends TestCase {
    
    public TasimaProtokoluIstatistigiTest(String testName) {
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
     * Test of getName method, of class TasimaProtokoluIstatistigi.
     */
    public void testGetName() {
        System.out.println("getName");
        TasimaProtokoluIstatistigi instance = new TasimaProtokoluIstatistigi();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class TasimaProtokoluIstatistigi.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        List<Packet> packets = null;
        TasimaProtokoluIstatistigi instance = new TasimaProtokoluIstatistigi();
        instance.analyze(packets);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPacket method, of class TasimaProtokoluIstatistigi.
     */
    public void testAddPacket() {
        System.out.println("addPacket");
        Packet p = null;
        TasimaProtokoluIstatistigi instance = new TasimaProtokoluIstatistigi();
        instance.addPacket(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLabels method, of class TasimaProtokoluIstatistigi.
     */
    public void testGetLabels() {
        System.out.println("getLabels");
        TasimaProtokoluIstatistigi instance = new TasimaProtokoluIstatistigi();
        String[] expResult = null;
        String[] result = instance.getLabels();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatTypes method, of class TasimaProtokoluIstatistigi.
     */
    public void testGetStatTypes() {
        System.out.println("getStatTypes");
        TasimaProtokoluIstatistigi instance = new TasimaProtokoluIstatistigi();
        String[] expResult = null;
        String[] result = instance.getStatTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class TasimaProtokoluIstatistigi.
     */
    public void testGetValues() {
        System.out.println("getValues");
        int indeks = 0;
        TasimaProtokoluIstatistigi instance = new TasimaProtokoluIstatistigi();
        long[] expResult = null;
        long[] result = instance.getValues(indeks);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class TasimaProtokoluIstatistigi.
     */
    public void testClear() {
        System.out.println("clear");
        TasimaProtokoluIstatistigi instance = new TasimaProtokoluIstatistigi();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
