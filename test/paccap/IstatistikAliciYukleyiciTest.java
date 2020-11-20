/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap;

import java.util.List;
import junit.framework.TestCase;
import paccap.stat.IstatistikAlici;

/**
 *
 * @author muhsin
 */
public class IstatistikAliciYukleyiciTest extends TestCase {
    
    public IstatistikAliciYukleyiciTest(String testName) {
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
     * Test of istatistikAliciYukle method, of class IstatistikAliciYukleyici.
     */
    public void testIstatistikAliciYukle() {
        System.out.println("istatistikAliciYukle");
        IstatistikAliciYukleyici.istatistikAliciYukle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of istatistikAlicilariGetir method, of class IstatistikAliciYukleyici.
     */
    public void testIstatistikAlicilariGetir() {
        System.out.println("istatistikAlicilariGetir");
        List<IstatistikAlici> expResult = null;
        List<IstatistikAlici> result = IstatistikAliciYukleyici.istatistikAlicilariGetir();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of istatistikAliciyiGetirAt method, of class IstatistikAliciYukleyici.
     */
    public void testIstatistikAliciyiGetirAt() {
        System.out.println("istatistikAliciyiGetirAt");
        int indeks = 0;
        IstatistikAlici expResult = null;
        IstatistikAlici result = IstatistikAliciYukleyici.istatistikAliciyiGetirAt(indeks);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
