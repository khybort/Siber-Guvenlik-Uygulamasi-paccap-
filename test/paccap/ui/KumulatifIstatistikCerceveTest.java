/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui;

import java.util.List;
import javax.swing.event.ListSelectionEvent;
import jpcap.packet.Packet;
import junit.framework.TestCase;
import paccap.stat.IstatistikAlici;

/**
 *
 * @author muhsin
 */
public class KumulatifIstatistikCerceveTest extends TestCase {
    
    public KumulatifIstatistikCerceveTest(String testName) {
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
     * Test of openWindow method, of class KumulatifIstatistikCerceve.
     */
    public void testOpenWindow() {
        System.out.println("openWindow");
        List<Packet> packets = null;
        IstatistikAlici staker = null;
        KumulatifIstatistikCerceve expResult = null;
        KumulatifIstatistikCerceve result = KumulatifIstatistikCerceve.openWindow(packets, staker);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fireUpdate method, of class KumulatifIstatistikCerceve.
     */
    public void testFireUpdate() {
        System.out.println("fireUpdate");
        KumulatifIstatistikCerceve instance = null;
        instance.fireUpdate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPacket method, of class KumulatifIstatistikCerceve.
     */
    public void testAddPacket() {
        System.out.println("addPacket");
        Packet p = null;
        KumulatifIstatistikCerceve instance = null;
        instance.addPacket(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class KumulatifIstatistikCerceve.
     */
    public void testClear() {
        System.out.println("clear");
        KumulatifIstatistikCerceve instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueChanged method, of class KumulatifIstatistikCerceve.
     */
    public void testValueChanged() {
        System.out.println("valueChanged");
        ListSelectionEvent evt = null;
        KumulatifIstatistikCerceve instance = null;
        instance.valueChanged(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
