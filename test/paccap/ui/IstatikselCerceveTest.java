/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui;

import jpcap.packet.Packet;
import junit.framework.TestCase;

/**
 *
 * @author muhsin
 */
public class IstatikselCerceveTest extends TestCase {
    
    public IstatikselCerceveTest(String testName) {
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
     * Test of fireUpdate method, of class IstatikselCerceve.
     */
    public void testFireUpdate() {
        System.out.println("fireUpdate");
        IstatikselCerceve instance = null;
        instance.fireUpdate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPacket method, of class IstatikselCerceve.
     */
    public void testAddPacket() {
        System.out.println("addPacket");
        Packet p = null;
        IstatikselCerceve instance = null;
        instance.addPacket(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class IstatikselCerceve.
     */
    public void testClear() {
        System.out.println("clear");
        IstatikselCerceve instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guncellemeyeBasla method, of class IstatikselCerceve.
     */
    public void testGuncellemeyeBasla() {
        System.out.println("guncellemeyeBasla");
        IstatikselCerceve instance = null;
        instance.guncellemeyeBasla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guncellemeyiDurdur method, of class IstatikselCerceve.
     */
    public void testGuncellemeyiDurdur() {
        System.out.println("guncellemeyiDurdur");
        IstatikselCerceve instance = null;
        instance.guncellemeyiDurdur();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IstatikselCerceveImpl extends IstatikselCerceve {

        public IstatikselCerceveImpl() {
            super("");
        }

        public void fireUpdate() {
        }

        public void addPacket(Packet p) {
        }

        public void clear() {
        }
    }
    
}
