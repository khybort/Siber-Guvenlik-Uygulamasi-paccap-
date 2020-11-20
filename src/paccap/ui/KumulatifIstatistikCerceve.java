package paccap.ui;
import jpcap.packet.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.Vector;

import paccap.stat.IstatistikAlici;
import paccap.ui.graph.TabloGraf;

public class KumulatifIstatistikCerceve extends IstatikselCerceve implements ListSelectionListener
{
	JTable tablo;
	TableModel model=null;
	TabloGraf tabloGrafigi=null;
	
	IstatistikAlici staker;
	int istatistikTipi=0;
	
	public static KumulatifIstatistikCerceve openWindow(java.util.List<Packet> packets,IstatistikAlici staker){
		KumulatifIstatistikCerceve frame=new KumulatifIstatistikCerceve(packets,staker);
		frame.setVisible(true);
		return frame;
	}
	
	KumulatifIstatistikCerceve(java.util.List<Packet> packets,IstatistikAlici staker){
		super(staker.getName());
		this.staker=staker;
		staker.analyze(packets);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

		model=new TableModel();
		tablo=new JTable(model);
		tablo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JTableHeader header = tablo.getTableHeader();
		Dimension dim = header.getPreferredSize();
		dim.height=20;
		header.setPreferredSize(dim);
		JScrollPane tablePane=new JScrollPane(tablo);
		dim=tablo.getMinimumSize();
		dim.height+=25;
		tablePane.setPreferredSize(dim);
		
		if(staker.getLabels().length>1){
			tabloGrafigi=new TabloGraf(staker.getLabels(),staker.getValues(0));
			JSplitPane splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			splitPane.setTopComponent(tablePane);
			splitPane.setBottomComponent(tabloGrafigi);
			
			getContentPane().add(splitPane);
			
			tablo.getSelectionModel().addListSelectionListener(this);
		}else{
			getContentPane().add(tablePane);
		}
		
		setSize(400,400);

		/*addInternalFrameListener(new InternalFrameAdapter(){
			public void internalFrameClosing(InternalFrameEvent evt){
				setVisible(false);
			}
		});*/
		
	}
	
	void fireUpdate(){//Anlık günceller
		int sel=tablo.getSelectedRow();
		if(tabloGrafigi!=null) tabloGrafigi.changeValue(staker.getValues(istatistikTipi));
		if(model!=null) model.guncelle();
		if(sel>=0) tablo.setRowSelectionInterval(sel,sel);
		repaint();
	}
	
	public void addPacket(Packet p){
		staker.addPacket(p);
	}
	
	public void clear(){
		staker.clear();
		if(tabloGrafigi!=null) tabloGrafigi.changeValue(staker.getValues(istatistikTipi));
		if(model!=null) model.guncelle();
	}
	
	public void valueChanged(ListSelectionEvent evt){
		if(evt.getValueIsAdjusting()) return;
		
		ListSelectionModel lsm=(ListSelectionModel)evt.getSource();
		if(lsm.isSelectionEmpty()) istatistikTipi=0;
		else istatistikTipi=lsm.getMinSelectionIndex();
		tabloGrafigi.changeValue(staker.getValues(istatistikTipi));
	}
	
	class TableModel extends AbstractTableModel{
		String[] etiketler;
		Object[][] degerler;
		TableModel(){
			etiketler=new String[staker.getLabels().length+1];
			etiketler[0]=new String();
			System.arraycopy(staker.getLabels(),0,etiketler,1,staker.getLabels().length);
			
			String[] types=staker.getStatTypes();
			degerler=new Object[types.length][staker.getLabels().length+1];
			for(int i=0;i<degerler.length;i++){
				degerler[i][0]=types[i];
				long[] v=staker.getValues(i);
				for(int j=0;j<v.length;j++)
					degerler[i][j+1]=new Long(v[j]);
			}
		}
		public String getColumnName(int c){return etiketler[c];}
		public int getColumnCount(){ return etiketler.length; }
		public int getRowCount(){ return degerler.length; }
		public Object getValueAt(int row,int column){ return degerler[row][column]; }
		void guncelle(){
			String[] types=staker.getStatTypes();
			degerler=new Object[types.length][staker.getLabels().length+1];
			for(int i=0;i<degerler.length;i++){
				degerler[i][0]=types[i];
				long[] v=staker.getValues(i);
				for(int j=0;j<v.length;j++)
					degerler[i][j+1]=new Long(v[j]);
			}
			fireTableDataChanged();
		}
	}
}
