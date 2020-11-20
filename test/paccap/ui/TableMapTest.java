/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui;

import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;
import junit.framework.TestCase;

/**
 *
 * @author muhsin
 */
public class TableMapTest extends TestCase {
    
    public TableMapTest(String testName) {
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
     * Test of getModel method, of class TableMap.
     */
    public void testGetModel() {
        System.out.println("getModel");
        TableMap instance = new TableMap();
        TableModel expResult = null;
        TableModel result = instance.getModel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModel method, of class TableMap.
     */
    public void testSetModel() {
        System.out.println("setModel");
        TableModel model = null;
        TableMap instance = new TableMap();
        instance.setModel(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class TableMap.
     */
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int aRow = 0;
        int aColumn = 0;
        TableMap instance = new TableMap();
        Object expResult = null;
        Object result = instance.getValueAt(aRow, aColumn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValueAt method, of class TableMap.
     */
    public void testSetValueAt() {
        System.out.println("setValueAt");
        Object aValue = null;
        int aRow = 0;
        int aColumn = 0;
        TableMap instance = new TableMap();
        instance.setValueAt(aValue, aRow, aColumn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowCount method, of class TableMap.
     */
    public void testGetRowCount() {
        System.out.println("getRowCount");
        TableMap instance = new TableMap();
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class TableMap.
     */
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        TableMap instance = new TableMap();
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class TableMap.
     */
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int aSutun = 0;
        TableMap instance = new TableMap();
        String expResult = "";
        String result = instance.getColumnName(aSutun);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnClass method, of class TableMap.
     */
    public void testGetColumnClass() {
        System.out.println("getColumnClass");
        int aColumn = 0;
        TableMap instance = new TableMap();
        Class expResult = null;
        Class result = instance.getColumnClass(aColumn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCellEditable method, of class TableMap.
     */
    public void testIsCellEditable() {
        System.out.println("isCellEditable");
        int satir = 0;
        int sutun = 0;
        TableMap instance = new TableMap();
        boolean expResult = false;
        boolean result = instance.isCellEditable(satir, sutun);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tableChanged method, of class TableMap.
     */
    public void testTableChanged() {
        System.out.println("tableChanged");
        TableModelEvent e = null;
        TableMap instance = new TableMap();
        instance.tableChanged(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
