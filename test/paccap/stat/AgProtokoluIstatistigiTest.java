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
public class AgProtokoluIstatistigiTest extends TestCase {
    
    public AgProtokoluIstatistigiTest(String testName) {
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
     * Test of getName method, of class AgProtokoluIstatistigi.
     */
    public void testGetName() {
        System.out.println("getName");
        AgProtokoluIstatistigi instance = new AgProtokoluIstatistigi();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class AgProtokoluIstatistigi.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        List<Packet> paketler = null;
        AgProtokoluIstatistigi instance = new AgProtokoluIstatistigi();
        instance.analyze(paketler);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPacket method, of class AgProtokoluIstatistigi.
     */
    public void testAddPacket() {
        System.out.println("addPacket");
        Packet p = new Packet();
        IndexOutOfBoundsException w=new IndexOutOfBoundsException();
        AgProtokoluIstatistigi instance = new AgProtokoluIstatistigi();
        assertNull(w.getMessage());
        assertNull(w.getLocalizedMessage());
        assertNull(w.getCause());
    }

    /**
     * Test of getLabels method, of class AgProtokoluIstatistigi.
     */
    public void testGetLabels() {
        System.out.println("getLabels");
        AgProtokoluIstatistigi instance = new AgProtokoluIstatistigi();
        String[] expResult = null;
        String[] result = instance.getLabels();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatTypes method, of class AgProtokoluIstatistigi.
     */
    public void testGetStatTypes() {
        System.out.println("getStatTypes");
        AgProtokoluIstatistigi instance = new AgProtokoluIstatistigi();
        String[] expResult = null;
        String[] result = instance.getStatTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class AgProtokoluIstatistigi.
     */
    public void testGetValues() {
        System.out.println("getValues");
        int index = 0;
        AgProtokoluIstatistigi instance = new AgProtokoluIstatistigi();
        long[] expResult = null;
        long[] result = instance.getValues(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class AgProtokoluIstatistigi.
     */
    public void testClear() {
        System.out.println("clear");
        AgProtokoluIstatistigi instance = new AgProtokoluIstatistigi();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
