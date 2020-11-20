/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui.graph;

import java.awt.Dimension;
import junit.framework.TestCase;

/**
 *
 * @author muhsin
 */
public class CizgiGrafTest extends TestCase {
    
    public CizgiGrafTest(String testName) {
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
     * Test of addValue method, of class CizgiGraf.
     */
    public void testAddValue() {
        System.out.println("addValue");
        long[] values = null;
        CizgiGraf instance = null;
        instance.addValue(values);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class CizgiGraf.
     */
    public void testClear() {
        System.out.println("clear");
        CizgiGraf instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMinValue method, of class CizgiGraf.
     */
    public void testSetMinValue() {
        System.out.println("setMinValue");
        int minValue = 0;
        CizgiGraf instance = null;
        instance.setMinValue(minValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxValue method, of class CizgiGraf.
     */
    public void testSetMaxValue() {
        System.out.println("setMaxValue");
        int maxValue = 0;
        CizgiGraf instance = null;
        instance.setMaxValue(maxValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMinValueAutoSet method, of class CizgiGraf.
     */
    public void testSetMinValueAutoSet() {
        System.out.println("setMinValueAutoSet");
        boolean autoMin = false;
        CizgiGraf instance = null;
        instance.setMinValueAutoSet(autoMin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxValueAutoSet method, of class CizgiGraf.
     */
    public void testSetMaxValueAutoSet() {
        System.out.println("setMaxValueAutoSet");
        boolean autoMax = false;
        CizgiGraf instance = null;
        instance.setMaxValueAutoSet(autoMax);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreferredSize method, of class CizgiGraf.
     */
    public void testGetPreferredSize() {
        System.out.println("getPreferredSize");
        CizgiGraf instance = null;
        Dimension expResult = null;
        Dimension result = instance.getPreferredSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CizgiGraf.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CizgiGraf.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
