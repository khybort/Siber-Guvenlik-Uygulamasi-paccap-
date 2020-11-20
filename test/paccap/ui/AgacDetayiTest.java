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
public class AgacDetayiTest extends TestCase {
    
    public AgacDetayiTest(String testName) {
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
     * Test of analyzePacket method, of class AgacDetayi.
     */
    public void testAnalyzePacket() {
        System.out.println("analyzePacket");
        Packet packet = null;
        AgacDetayi instance = new AgacDetayi();
        instance.analyzePacket(packet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
