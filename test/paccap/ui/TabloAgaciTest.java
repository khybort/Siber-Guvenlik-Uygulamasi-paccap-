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
public class TabloAgaciTest extends TestCase {
    
    public TabloAgaciTest(String testName) {
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
     * Test of paketiAnalizEt method, of class TabloAgaci.
     */
    public void testPaketiAnalizEt() {
        System.out.println("paketiAnalizEt");
        Packet paket = null;
        TabloAgaci instance = new TabloAgaci();
        instance.paketiAnalizEt(paket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
