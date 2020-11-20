/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap.ui;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;
import junit.framework.TestCase;

/**
 *
 * @author muhsin
 */
public class TabloSiralayiciTest extends TestCase {
    
    public TabloSiralayiciTest(String testName) {
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
     * Test of setModel method, of class TabloSiralayici.
     */
    public void testSetModel() {
        System.out.println("setModel");
        TableModel model = null;
        TabloSiralayici instance = new TabloSiralayici();
        instance.setModel(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sutunlaSatiriKarsilastir method, of class TabloSiralayici.
     */
    public void testSutunlaSatiriKarsilastir() {
        System.out.println("sutunlaSatiriKarsilastir");
        int satir1 = 0;
        int satir2 = 0;
        int sutun = 0;
        TabloSiralayici instance = new TabloSiralayici();
        int expResult = 0;
        int result = instance.sutunlaSatiriKarsilastir(satir1, satir2, sutun);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of karsilastir method, of class TabloSiralayici.
     */
    public void testKarsilastir() {
        System.out.println("karsilastir");
        int satir1 = 0;
        int satir2 = 0;
        TabloSiralayici instance = new TabloSiralayici();
        int expResult = 0;
        int result = instance.karsilastir(satir1, satir2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indeksleriTekrarTahsisEt method, of class TabloSiralayici.
     */
    public void testIndeksleriTekrarTahsisEt() {
        System.out.println("indeksleriTekrarTahsisEt");
        TabloSiralayici instance = new TabloSiralayici();
        instance.indeksleriTekrarTahsisEt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tableChanged method, of class TabloSiralayici.
     */
    public void testTableChanged() {
        System.out.println("tableChanged");
        TableModelEvent e = null;
        TabloSiralayici instance = new TabloSiralayici();
        instance.tableChanged(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modeliKontrolEt method, of class TabloSiralayici.
     */
    public void testModeliKontrolEt() {
        System.out.println("modeliKontrolEt");
        TabloSiralayici instance = new TabloSiralayici();
        instance.modeliKontrolEt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sirala method, of class TabloSiralayici.
     */
    public void testSirala() {
        System.out.println("sirala");
        Object sender = null;
        TabloSiralayici instance = new TabloSiralayici();
        instance.sirala(sender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of n2sort method, of class TabloSiralayici.
     */
    public void testN2sort() {
        System.out.println("n2sort");
        TabloSiralayici instance = new TabloSiralayici();
        instance.n2sort();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuttlesort method, of class TabloSiralayici.
     */
    public void testShuttlesort() {
        System.out.println("shuttlesort");
        int[] from = null;
        int[] to = null;
        int low = 0;
        int high = 0;
        TabloSiralayici instance = new TabloSiralayici();
        instance.shuttlesort(from, to, low, high);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takas method, of class TabloSiralayici.
     */
    public void testTakas() {
        System.out.println("takas");
        int i = 0;
        int j = 0;
        TabloSiralayici instance = new TabloSiralayici();
        instance.takas(i, j);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class TabloSiralayici.
     */
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int aRow = 0;
        int aColumn = 0;
        TabloSiralayici instance = new TabloSiralayici();
        Object expResult = null;
        Object result = instance.getValueAt(aRow, aColumn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValueAt method, of class TabloSiralayici.
     */
    public void testSetValueAt() {
        System.out.println("setValueAt");
        Object aValue = null;
        int aRow = 0;
        int aColumn = 0;
        TabloSiralayici instance = new TabloSiralayici();
        instance.setValueAt(aValue, aRow, aColumn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sutunlaSirala method, of class TabloSiralayici.
     */
    public void testSutunlaSirala_int() {
        System.out.println("sutunlaSirala");
        int sutun = 0;
        TabloSiralayici instance = new TabloSiralayici();
        instance.sutunlaSirala(sutun);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrijinalIndeks method, of class TabloSiralayici.
     */
    public void testGetOrijinalIndeks() {
        System.out.println("getOrijinalIndeks");
        int indeks = 0;
        TabloSiralayici instance = new TabloSiralayici();
        int expResult = 0;
        int result = instance.getOrijinalIndeks(indeks);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sutunlaSirala method, of class TabloSiralayici.
     */
    public void testSutunlaSirala_int_boolean() {
        System.out.println("sutunlaSirala");
        int sutun = 0;
        boolean ascending = false;
        TabloSiralayici instance = new TabloSiralayici();
        instance.sutunlaSirala(sutun, ascending);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMouseListenerToHeaderInTable method, of class TabloSiralayici.
     */
    public void testAddMouseListenerToHeaderInTable() {
        System.out.println("addMouseListenerToHeaderInTable");
        JTable table = null;
        TabloSiralayici instance = new TabloSiralayici();
        instance.addMouseListenerToHeaderInTable(table);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
