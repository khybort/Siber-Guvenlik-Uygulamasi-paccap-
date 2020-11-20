/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui;

import java.util.List;
import jpcap.packet.Packet;
import junit.framework.TestCase;
import paccap.stat.IstatistikAlici;

/**
 *
 * @author muhsin
 */
public class BirikimliIstatistikCerceveTest extends TestCase {
    
    public BirikimliIstatistikCerceveTest(String testName) {
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
     * Test of openWindow method, of class BirikimliIstatistikCerceve.
     */
    public void testOpenWindow() {
        System.out.println("openWindow");
        List<Packet> packets = null;
        IstatistikAlici staker = null;
        BirikimliIstatistikCerceve expResult = null;
        BirikimliIstatistikCerceve result = BirikimliIstatistikCerceve.openWindow(packets, staker);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPacket method, of class BirikimliIstatistikCerceve.
     */
    public void testAddPacket() {
        System.out.println("addPacket");
        Packet p = null;
        BirikimliIstatistikCerceve instance = null;
        instance.addPacket(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class BirikimliIstatistikCerceve.
     */
    public void testClear() {
        System.out.println("clear");
        BirikimliIstatistikCerceve instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fireUpdate method, of class BirikimliIstatistikCerceve.
     */
    public void testFireUpdate() {
        System.out.println("fireUpdate");
        BirikimliIstatistikCerceve instance = null;
        instance.fireUpdate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
