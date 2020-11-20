/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import jpcap.JpcapCaptor;
import junit.framework.TestCase;

/**
 *
 * @author muhsin
 */
public class YakalamaPenceresiTest extends TestCase {
    
    public YakalamaPenceresiTest(String testName) {
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
     * Test of actionPerformed method, of class YakalamaPenceresi.
     */
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        YakalamaPenceresi instance = null;
        instance.actionPerformed(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJpcap method, of class YakalamaPenceresi.
     */
    public void testGetJpcap() {
        System.out.println("getJpcap");
        JFrame parent = null;
        JpcapCaptor expResult = null;
        JpcapCaptor result = YakalamaPenceresi.getJpcap(parent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
