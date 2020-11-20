/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap;

import javax.swing.JFrame;
import junit.framework.TestCase;
import static paccap.PacCap.closeWindow;
import static paccap.PacCap.nitelikleriKaydet;
import static paccap.PacCap.openNewWindow;
import paccap.ui.Cerceve;
import paccap.ui.YakalamaPenceresi;

/**
 *
 * @author muhsin
 */
public class PacCapTest extends TestCase {
    
    public PacCapTest(String testName) {
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
     * Test of main method, of class PacCap.
     */
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        PacCap.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nitelikleriKaydet method, of class PacCap.
     */
    public void testNitelikleriKaydet() {
        System.out.println("nitelikleriKaydet");
        PacCap.nitelikleriKaydet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openNewWindow method, of class PacCap.
     */
    public void testOpenNewWindow() {
        System.out.println("openNewWindow");
        PacCap p=new PacCap();
        PacCap.openNewWindow();
        assertNull(p);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of closeWindow method, of class PacCap.
     */
    public void testCloseWindow() {
        System.out.println("closeWindow");
        Yakalayici y=new Yakalayici();
        PacCap instance=new PacCap();
        int a=1;
        System.out.println(y.getPackets().size());
        assertEquals(a,y.getPackets().size());
    }

    /**
     * Test of finalize method, of class PacCap.
     */
    public void testFinalize() throws Exception, Throwable {
        System.out.println("finalize");
        PacCap instance = new PacCap();
        finalize();
        String a="paccap.PacCap@1d251891";
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(a,instance.toString());
    }
    
}
