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
public class PaketIstatistigiTest extends TestCase {
    
    public PaketIstatistigiTest(String testName) {
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
     * Test of getName method, of class PaketIstatistigi.
     */
    public void testGetName() {
        System.out.println("getName");
        PaketIstatistigi instance = new PaketIstatistigi();
        String expResult = "Bilgi";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of analyze method, of class PaketIstatistigi.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        List<Packet> paketler = null;
        PaketIstatistigi instance = new PaketIstatistigi();
        instance.analyze(paketler);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPacket method, of class PaketIstatistigi.
     */
    public void testAddPacket() {
        System.out.println("addPacket");
        Packet p = null;
        PaketIstatistigi instance = new PaketIstatistigi();
        instance.addPacket(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLabels method, of class PaketIstatistigi.
     */
    public void testGetLabels() {
        System.out.println("getLabels");
        PaketIstatistigi instance = new PaketIstatistigi();
        String[] expResult = null;
        String[] result = instance.getLabels();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatTypes method, of class PaketIstatistigi.
     */
    public void testGetStatTypes() {
        System.out.println("getStatTypes");
        PaketIstatistigi instance = new PaketIstatistigi();
        String[] expResult = null;
        String[] result = instance.getStatTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class PaketIstatistigi.
     */
    public void testGetValues() {
        System.out.println("getValues");
        int index = 0;
        PaketIstatistigi instance = new PaketIstatistigi();
        long[] expResult = null;
        long[] result = instance.getValues(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class PaketIstatistigi.
     */
    public void testClear() {
        System.out.println("clear");
        PaketIstatistigi instance = new PaketIstatistigi();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
