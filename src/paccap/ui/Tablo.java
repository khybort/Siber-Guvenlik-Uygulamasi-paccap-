package paccap.ui;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;

import jpcap.packet.*;

import paccap.Yakalayici;
import paccap.analizci.JPaketAnalizci;

class Tablo extends JComponent
{
	TableModel model;
	TabloSiralayici siralayici;
	Vector gorunumler=new Vector();
	Yakalayici yakalayici;
	
	Tablo(TabloPaneli parent,Yakalayici yakalayici){
		this.yakalayici=yakalayici;
		model=new TableModel();
		siralayici = new TabloSiralayici(model);
		//JTable table=new JTable(model);
		JTable tablo = new JTable(siralayici);
		siralayici.addMouseListenerToHeaderInTable(tablo); //ADDED THIS
		
		tablo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablo.getSelectionModel().addListSelectionListener(parent);
		tablo.setDefaultRenderer(Object.class,new TabloIsleyici());
		JScrollPane tableView=new JScrollPane(tablo);
		
		setLayout(new BorderLayout());
		add(tableView,BorderLayout.CENTER);
	}
	
	/*void setPackets(Vector packets){
		if(packets==null) return;
		this.packets=packets;
		model.fireTableStructureChanged();
		model.fireTableDataChanged();
	}*/
	
	void fireTableChanged(){
		/*model.fireTableStructureChanged();
		model.fireTableDataChanged();*/
		model.fireTableRowsInserted(yakalayici.getPackets().size()-1,yakalayici.getPackets().size()-1);
	}
	
	void temizle(){
		model.fireTableStructureChanged();
		model.fireTableDataChanged();
	}
	
	void setTableView(JPaketAnalizci analizci,String ad,boolean set){
		if(set){
			gorunumler.addElement(new tabloGorunumu(analizci,ad));
		}else{
			for(int i=0;i<gorunumler.size();i++){
				tabloGorunumu view=(tabloGorunumu)gorunumler.elementAt(i);
				if(view.analizci==analizci && view.degerAdi.equals(ad))
					gorunumler.removeElement(view);
			}
		}
		model.fireTableStructureChanged();
	}
	
	String[] tabloGorunumDurumunuGetir(){
		String[] durum=new String[gorunumler.size()];
		
		for(int i=0;i<durum.length;i++){
			tabloGorunumu gorunum=(tabloGorunumu)gorunumler.elementAt(i);
			durum[i]=gorunum.analizci.getProtocolName()+":"+gorunum.degerAdi;
		}
		
		return durum;
	}
	
	class tabloGorunumu{
		JPaketAnalizci analizci;
		String degerAdi;
		
		tabloGorunumu(JPaketAnalizci analizci,String ad){
			this.analizci=analizci;degerAdi=ad;
		}
	}
	
	class TableModel extends AbstractTableModel
	{
		public int getRowCount(){
			return yakalayici.getPackets().size();
		}
		
		public int getColumnCount(){
			return gorunumler.size()+1;
		}
		
		public Object getValueAt(int satir,int sutun){
			if(yakalayici.getPackets().size()<=satir) return "";
			Packet paket=(Packet)(yakalayici.getPackets().get(satir));
			
			if(sutun==0)	return new Integer(satir);
			tabloGorunumu gorunum=(tabloGorunumu)gorunumler.elementAt(sutun-1);
			
			if(gorunum.analizci.isAnalyzable(paket)){
				synchronized(gorunum.analizci){
					gorunum.analizci.analyze(paket);
					Object obj=gorunum.analizci.getValue(gorunum.degerAdi);
					
					if(obj instanceof Vector)
						if(((Vector)obj).size()>0)
							return ((Vector)obj).elementAt(0);
						else
							return null;
					else
						return obj;
				}
			}else{
				return null;
			}
		}
		
    /*public Class getColumnClass(int c) {
			for(int i=0;i<getRowCount();i++){
				if(getValueAt(i,c)!=null && !"Not available".equals(getValueAt(i,c)))
					return getValueAt(i, c).getClass();
			}
			
			return String.class;
    }*/
		
		public boolean isCellEditable(int row,int column){
			return false;
		}
		
		public String getColumnName(int column){
			if(column==0) return "No.";
			
			return ((tabloGorunumu)gorunumler.elementAt(column-1)).degerAdi;
		}

    
}
}
