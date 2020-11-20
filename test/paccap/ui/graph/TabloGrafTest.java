/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui.graph;

import java.awt.Dimension;
import java.awt.Graphics;
import junit.framework.TestCase;

/**
 *
 * @author muhsin
 */
public class TabloGrafTest extends TestCase {
    
    public TabloGrafTest(String testName) {
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
     * Test of changeValue method, of class TabloGraf.
     */
    public void testChangeValue() {
        System.out.println("changeValue");
        long[] values = null;
        TabloGraf instance = null;
        instance.changeValue(values);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class TabloGraf.
     */
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        TabloGraf instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreferredSize method, of class TabloGraf.
     */
    public void testGetPreferredSize() {
        System.out.println("getPreferredSize");
        TabloGraf instance = null;
        Dimension expResult = null;
        Dimension result = instance.getPreferredSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
