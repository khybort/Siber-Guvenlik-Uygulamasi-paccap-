/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paccap;

import java.util.List;
import jpcap.packet.Packet;
import junit.framework.TestCase;
import paccap.stat.IstatistikAlici;
import paccap.ui.Cerceve;

/**
 *
 * @author muhsin
 */
public class YakalayiciTest extends TestCase {
    
    public YakalayiciTest(String testName) {
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
     * Test of setFrame method, of class Yakalayici.
     */
    public void testSetFrame() {
        System.out.println("setFrame");
        Cerceve cerceve = null;
        Yakalayici instance = new Yakalayici();
        instance.setFrame(cerceve);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPackets method, of class Yakalayici.
     */
    public void testGetPackets() {
        System.out.println("getPackets");
        Yakalayici instance = new Yakalayici();
        List<Packet> expResult = null;
        List<Packet> result = instance.getPackets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cihazdanPaketleriYakala method, of class Yakalayici.
     */
    public void testCihazdanPaketleriYakala() {
        System.out.println("cihazdanPaketleriYakala");
        Yakalayici instance = new Yakalayici();
        instance.cihazdanPaketleriYakala();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dosyadanPaketleriYukle method, of class Yakalayici.
     */
    public void testDosyadanPaketleriYukle() {
        System.out.println("dosyadanPaketleriYukle");
        Yakalayici instance = new Yakalayici();
        instance.dosyadanPaketleriYukle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dosyayaKaydet method, of class Yakalayici.
     */
    public void testDosyayaKaydet() {
        System.out.println("dosyayaKaydet");
        Yakalayici instance = new Yakalayici();
        instance.dosyayaKaydet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of yakalamayiDurdur method, of class Yakalayici.
     */
    public void testYakalamayiDurdur() {
        System.out.println("yakalamayiDurdur");
        Yakalayici instance = new Yakalayici();
        instance.yakalamayiDurdur();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kaydedilmediyseKaydet method, of class Yakalayici.
     */
    public void testKaydedilmediyseKaydet() {
        System.out.println("kaydedilmediyseKaydet");
        Yakalayici instance = new Yakalayici();
        instance.kaydedilmediyseKaydet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kumulatifIstatistikCercevesiEkle method, of class Yakalayici.
     */
    public void testKumulatifIstatistikCercevesiEkle() {
        System.out.println("kumulatifIstatistikCercevesiEkle");
        IstatistikAlici istatistikAlici = null;
        Yakalayici instance = new Yakalayici();
        instance.kumulatifIstatistikCercevesiEkle(istatistikAlici);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of birikimliIstatistikCercevesiEkle method, of class Yakalayici.
     */
    public void testBirikimliIstatistikCercevesiEkle() {
        System.out.println("birikimliIstatistikCercevesiEkle");
        IstatistikAlici istatistikAlici = null;
        Yakalayici instance = new Yakalayici();
        instance.birikimliIstatistikCercevesiEkle(istatistikAlici);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tumPencereleriKapat method, of class Yakalayici.
     */
    public void testTumPencereleriKapat() {
        System.out.println("tumPencereleriKapat");
        Yakalayici instance = new Yakalayici();
        instance.tumPencereleriKapat();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of yakalamaThreadiniDurdur method, of class Yakalayici.
     */
    public void testYakalamaThreadiniDurdur() {
        System.out.println("yakalamaThreadiniDurdur");
        Yakalayici instance = new Yakalayici();
        instance.yakalamaThreadiniDurdur();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
