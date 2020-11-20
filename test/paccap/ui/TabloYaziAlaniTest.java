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
public class TabloYaziAlaniTest extends TestCase {
    
    public TabloYaziAlaniTest(String testName) {
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
     * Test of paketiGoster method, of class TabloYaziAlani.
     */
    public void testPaketiGoster() {
        System.out.println("paketiGoster");
        Packet p = null;
        TabloYaziAlani instance = new TabloYaziAlani();
        instance.paketiGoster(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
