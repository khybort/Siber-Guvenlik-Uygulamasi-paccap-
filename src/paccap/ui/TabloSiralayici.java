
package paccap.ui;
import java.util.*;

import javax.swing.table.TableModel;
import javax.swing.event.TableModelEvent;

// Imports for picking up mouse events from the JTable. 

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputEvent;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class TabloSiralayici extends TableMap {
    int             indeksler[];
    Vector          siralamaSutunlari = new Vector();
    boolean         ascending = true;
    int karsilastir;

    public TabloSiralayici() {
        indeksler = new int[0]; // for consistency
    }

    public TabloSiralayici(TableModel model) {
        setModel(model);
    }

    public void setModel(TableModel model) {
        super.setModel(model); 
        indeksleriTekrarTahsisEt(); 
    }

    public int sutunlaSatiriKarsilastir(int satir1, int satir2, int sutun) {
        TableModel veri = model;  

        Object o1 = veri.getValueAt(satir1, sutun);
        Object o2 = veri.getValueAt(satir2, sutun); 


        if (o1 == null && o2 == null) {
            return 0; 
        } else if (o1 == null) { 
            return -1; 
        } else if (o2 == null) { 
            return 1; 
        }
        
        if(o1.getClass() != o2.getClass())
        	return -1;
        Class tip=o1.getClass();
				
        

        if (tip.getSuperclass() == java.lang.Number.class) {
            Number n1 = (Number)veri.getValueAt(satir1, sutun);
            double d1 = n1.doubleValue();
            Number n2 = (Number)veri.getValueAt(satir2, sutun);
            double d2 = n2.doubleValue();

            if (d1 < d2) {
                return -1;
            } else if (d1 > d2) {
                return 1;
            } else {
                return 0;
            }
        } else if (tip == java.util.Date.class) {
            Date d1 = (Date)veri.getValueAt(satir1, sutun);
            long n1 = d1.getTime();
            Date d2 = (Date)veri.getValueAt(satir2, sutun);
            long n2 = d2.getTime();

            if (n1 < n2) {
                return -1;
            } else if (n1 > n2) {
                return 1;
            } else {
                return 0;
            }
        } else if (tip == String.class) {
            String s1 = (String)veri.getValueAt(satir1, sutun);
            String s2    = (String)veri.getValueAt(satir2, sutun);
            int sonuc = s1.compareTo(s2);

            if (sonuc < 0) {
                return -1;
            } else if (sonuc > 0) {
                return 1;
            } else {
                return 0;
            }
        } else if (tip == Boolean.class) {
            Boolean bool1 = (Boolean)veri.getValueAt(satir1, sutun);
            boolean b1 = bool1.booleanValue();
            Boolean bool2 = (Boolean)veri.getValueAt(satir2, sutun);
            boolean b2 = bool2.booleanValue();

            if (b1 == b2) {
                return 0;
            } else if (b1) { 
                return 1;
            } else {
                return -1;
            }
        } else {
            Object v1 = veri.getValueAt(satir1, sutun);
            String s1 = v1.toString();
            Object v2 = veri.getValueAt(satir2, sutun);
            String s2 = v2.toString();
            int sonuc = s1.compareTo(s2);

            if (sonuc < 0) {
                return -1;
            } else if (sonuc > 0) {
                return 1;
            } else {
        	return 0;
            }
        }
    }

    public int karsilastir(int satir1, int satir2) {
        karsilastir++;
        for (int seviye = 0; seviye < siralamaSutunlari.size(); seviye++) {
            Integer sutun = (Integer)siralamaSutunlari.elementAt(seviye);
            int sonuc = sutunlaSatiriKarsilastir(satir1, satir2, sutun.intValue());
            if (sonuc != 0) {
                return ascending ? sonuc : -sonuc;
            }
        }
        return 0;
    }

    public void indeksleriTekrarTahsisEt() {
        int satirSayisi = model.getRowCount();

        indeksler = new int[satirSayisi];

        for (int satir = 0; satir < satirSayisi; satir++) {
            indeksler[satir] = satir;
        }
    }

    public void tableChanged(TableModelEvent e) {

        indeksleriTekrarTahsisEt();

        super.tableChanged(e);
    }

    public void modeliKontrolEt() {
        if (indeksler.length != model.getRowCount()) {
				    indeksleriTekrarTahsisEt();
            //System.err.println("Siralayici bir model taradından bilgilendirilmedi");
        }
    }

    public void sirala(Object sender) {
        modeliKontrolEt();

        karsilastir = 0;
        // n2sort();
        // qsort(0, indexes.length-1);
        shuttlesort((int[])indeksler.clone(), indeksler, 0, indeksler.length);
        //System.out.println("Compares: "+compares);
    }

    public void n2sort() {
        for (int i = 0; i < getRowCount(); i++) {
            for (int j = i+1; j < getRowCount(); j++) {
                if (karsilastir(indeksler[i], indeksler[j]) == -1) {
                    takas(i, j);
                }
            }
        }
    }

    public void shuttlesort(int from[], int to[], int low, int high) {
        if (high - low < 2) {
            return;
        }
        int middle = (low + high)/2;
        shuttlesort(to, from, low, middle);
        shuttlesort(to, from, middle, high);

        int p = low;
        int q = middle;


        if (high - low >= 4 && karsilastir(from[middle-1], from[middle]) <= 0) {
            for (int i = low; i < high; i++) {
                to[i] = from[i];
            }
            return;
        }

        // A normal merge. 

        for (int i = low; i < high; i++) {
            if (q >= high || (p < middle && karsilastir(from[p], from[q]) <= 0)) {
                to[i] = from[p++];
            }
            else {
                to[i] = from[q++];
            }
        }
    }

    public void takas(int i, int j) {
        int gecici = indeksler[i];
        indeksler[i] = indeksler[j];
        indeksler[j] = gecici;
    }

    // The mapping only affects the contents of the data rows.
    // Pass all requests to these rows through the mapping array: "indexes".

    public Object getValueAt(int aRow, int aColumn) {
        modeliKontrolEt();
        return model.getValueAt(indeksler[aRow], aColumn);
    }

    public void setValueAt(Object aValue, int aRow, int aColumn) {
        modeliKontrolEt();
        model.setValueAt(aValue, indeksler[aRow], aColumn);
    }

    public void sutunlaSirala(int sutun) {
        sutunlaSirala(sutun, true);
    }
    
    public int getOrijinalIndeks(int indeks){
			return indeksler[indeks];
		}

    public void sutunlaSirala(int sutun, boolean ascending) {
        this.ascending = ascending;
        siralamaSutunlari.removeAllElements();
        siralamaSutunlari.addElement(new Integer(sutun));
        sirala(this);
        super.tableChanged(new TableModelEvent(this)); 
    }

    public void addMouseListenerToHeaderInTable(JTable table) { 
        final TabloSiralayici siralayici = this; 
        final JTable tabloGorunumu = table; 
        tabloGorunumu.setColumnSelectionAllowed(false); 
        MouseAdapter mouseListenerListesi = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                TableColumnModel columnModel = tabloGorunumu.getColumnModel();
                int sutunGorunumu = columnModel.getColumnIndexAtX(e.getX()); 
                int sutun = tabloGorunumu.convertColumnIndexToModel(sutunGorunumu); 
                if (e.getClickCount() == 1 && sutun != -1) {
                    //System.out.println("Sıraliyor ..."); 
                    int shiftPressed = e.getModifiers()&InputEvent.SHIFT_MASK; 
                    boolean ascending = (shiftPressed == 0); 
                    siralayici.sutunlaSirala(sutun, ascending); 
                }
            }
        };
        JTableHeader th = tabloGorunumu.getTableHeader(); 
        th.addMouseListener(mouseListenerListesi); 
    }
}
