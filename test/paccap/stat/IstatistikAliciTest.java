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
public class IstatistikAliciTest extends TestCase {
    
    public IstatistikAliciTest(String testName) {
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
     * Test of getName method, of class IstatistikAlici.
     */
    public void testGetName() {
        System.out.println("getName");
        IstatistikAlici instance = new IstatistikAliciImpl();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class IstatistikAlici.
     */
    public void testAnalyze() {
        System.out.println("analyze");
        List<Packet> paketler = null;
        IstatistikAlici instance = new IstatistikAliciImpl();
        instance.analyze(paketler);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPacket method, of class IstatistikAlici.
     */
    public void testAddPacket() {
        System.out.println("addPacket");
        Packet p = null;
        IstatistikAlici instance = new IstatistikAliciImpl();
        instance.addPacket(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLabels method, of class IstatistikAlici.
     */
    public void testGetLabels() {
        System.out.println("getLabels");
        IstatistikAlici instance = new IstatistikAliciImpl();
        String[] expResult = null;
        String[] result = instance.getLabels();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatTypes method, of class IstatistikAlici.
     */
    public void testGetStatTypes() {
        System.out.println("getStatTypes");
        IstatistikAlici instance = new IstatistikAliciImpl();
        String[] expResult = null;
        String[] result = instance.getStatTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class IstatistikAlici.
     */
    public void testGetValues() {
        System.out.println("getValues");
        int indeks = 0;
        IstatistikAlici instance = new IstatistikAliciImpl();
        long[] expResult = null;
        long[] result = instance.getValues(indeks);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class IstatistikAlici.
     */
    public void testClear() {
        System.out.println("clear");
        IstatistikAlici instance = new IstatistikAliciImpl();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newInstance method, of class IstatistikAlici.
     */
    public void testNewInstance() {
        System.out.println("newInstance");
        IstatistikAlici instance = new IstatistikAliciImpl();
        IstatistikAlici expResult = null;
        IstatistikAlici result = instance.newInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IstatistikAliciImpl extends IstatistikAlici {

        public String getName() {
            return "";
        }

        public void analyze(List<Packet> paketler) {
        }

        public void addPacket(Packet p) {
        }

        public String[] getLabels() {
            return null;
        }

        public String[] getStatTypes() {
            return null;
        }

        public long[] getValues(int indeks) {
            return null;
        }

        public void clear() {
        }
    }
    
}
