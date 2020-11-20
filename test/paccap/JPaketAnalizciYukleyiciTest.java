/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap;

import java.util.List;
import junit.framework.TestCase;
import paccap.analizci.JPaketAnalizci;

/**
 *
 * @author muhsin
 */
public class JPaketAnalizciYukleyiciTest extends TestCase {
    
    public JPaketAnalizciYukleyiciTest(String testName) {
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
     * Test of loadDefaultAnalyzer method, of class JPaketAnalizciYukleyici.
     */
    public void testLoadDefaultAnalyzer() {
        System.out.println("loadDefaultAnalyzer");
        JPaketAnalizciYukleyici.loadDefaultAnalyzer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnalyzers method, of class JPaketAnalizciYukleyici.
     */
    public void testGetAnalyzers() {
        System.out.println("getAnalyzers");
        List<JPaketAnalizci> expResult = null;
        List<JPaketAnalizci> result = JPaketAnalizciYukleyici.getAnalyzers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnalyzersOf method, of class JPaketAnalizciYukleyici.
     */
    public void testGetAnalyzersOf() {
        System.out.println("getAnalyzersOf");
        int katman = 0;
        List<JPaketAnalizci> expResult = null;
        List<JPaketAnalizci> result = JPaketAnalizciYukleyici.getAnalyzersOf(katman);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
