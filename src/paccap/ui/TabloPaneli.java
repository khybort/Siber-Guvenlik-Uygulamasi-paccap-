package paccap.ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.List;

import paccap.Yakalayici;
import paccap.JPaketAnalizciYukleyici;
import paccap.PacCap;
import paccap.analizci.JPaketAnalizci;
import jpcap.packet.*;

class TabloPaneli extends JPanel implements ActionListener,ListSelectionListener
{
	Tablo tablo;
	TabloAgaci agac;
	TabloYaziAlani yazi;
	Yakalayici yakalayici;
	List<JPaketAnalizci> analizciler;
	
	JMenu[] tabloGorunumMenusu=new JMenu[4];
	TabloPaneli(Yakalayici yakalayici){
		this.yakalayici=yakalayici;
		tablo=new Tablo(this,yakalayici);
		agac=new TabloAgaci();
		yazi=new TabloYaziAlani();
		
		JSplitPane ayirmaPaneli=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JSplitPane ayirmaPaneli2=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		ayirmaPaneli.setTopComponent(tablo);
		ayirmaPaneli2.setTopComponent(agac);
		ayirmaPaneli2.setBottomComponent(new JScrollPane(yazi));
		ayirmaPaneli.setBottomComponent(ayirmaPaneli2);
		ayirmaPaneli.setDividerLocation(200);
		ayirmaPaneli2.setDividerLocation(200);
		
		tabloGorunumMenusu[0]=new JMenu("Veri bağı katmanı");
		tabloGorunumMenusu[1]=new JMenu("Ağ katmanı");
		tabloGorunumMenusu[2]=new JMenu("Taşıma katmanı");
		tabloGorunumMenusu[3]=new JMenu("Uygulama katmanı");
		analizciler=JPaketAnalizciYukleyici.getAnalyzers();
		JMenuItem oge,altOge;
		
		for(int i=0;i<analizciler.size();i++){
			JPaketAnalizci analizci=analizciler.get(i);
			oge=new JMenu(analizci.getProtocolName());
			String[] degerAdlari=analizci.getValueNames();
			if(degerAdlari==null) continue;
			for(int j=0;j<degerAdlari.length;j++){
				altOge=new JCheckBoxMenuItem(degerAdlari[j]);
				altOge.setActionCommand("TableView"+i);
				altOge.addActionListener(this);
				oge.add(altOge);
			}
			tabloGorunumMenusu[analizci.katman].add(oge);
		}

		setLayout(new BorderLayout());
		add(ayirmaPaneli,BorderLayout.CENTER);

		nitelikleriYukle();
		setSize(400,200);
	}
	
	void fireTableChanged(){
		tablo.fireTableChanged();
	}
	
	void temizle(){
		tablo.temizle();
	}
	
	public void tabloGorunumMenusunuYerlestir(JMenu menu){
		menu.add(tabloGorunumMenusu[0]);
		menu.add(tabloGorunumMenusu[1]);
		menu.add(tabloGorunumMenusu[2]);
		menu.add(tabloGorunumMenusu[3]);
	}
	
	public void actionPerformed(ActionEvent evt){
		String cmd=evt.getActionCommand();
		
		if(cmd.startsWith("TableView")){
			int indeks=Integer.parseInt(cmd.substring(9));
			JCheckBoxMenuItem item=(JCheckBoxMenuItem)evt.getSource();
			tablo.setTableView(analizciler.get(indeks),item.getText(),item.isSelected());
		}
	}
	
	public void valueChanged(ListSelectionEvent evt){
		if(evt.getValueIsAdjusting()) return;
		
		int indeks=((ListSelectionModel)evt.getSource()).getMinSelectionIndex();
		if(indeks>=0){
			Packet p=(Packet)yakalayici.getPackets().get(tablo.siralayici.getOrijinalIndeks(indeks));
			agac.paketiAnalizEt(p);
			yazi.paketiGoster(p);
		}
	}
	
	void nitelikleriYukle(){
		Component[] menus=new Component[analizciler.size()];
		int k=0;
		for(int j=0;j<tabloGorunumMenusu[0].getMenuComponents().length;j++)
			menus[k++]=tabloGorunumMenusu[0].getMenuComponents()[j];
		for(int j=0;j<tabloGorunumMenusu[1].getMenuComponents().length;j++)
			menus[k++]=tabloGorunumMenusu[1].getMenuComponents()[j];
		for(int j=0;j<tabloGorunumMenusu[2].getMenuComponents().length;j++)
			menus[k++]=tabloGorunumMenusu[2].getMenuComponents()[j];
		for(int j=0;j<tabloGorunumMenusu[3].getMenuComponents().length;j++)
			menus[k++]=tabloGorunumMenusu[3].getMenuComponents()[j];
		

		StringTokenizer status=new StringTokenizer(PacCap.tercihler.get("TableView",
				"Ethernet Frame:Source MAC,Ethernet Frame:Destination MAC,IPv4:Source IP,IPv4:Destination IP"),",");
		
		while(status.hasMoreTokens()){
			StringTokenizer s=new StringTokenizer(status.nextToken(),":");
			if(s.countTokens()==2){
				String adi=s.nextToken(),degerAdi=s.nextToken();//String Tokenizer Java
				//for(int i=0;i<analyzers.length;i++)
					//if(analyzers[i].getProtocolName().equals(name)){
				for(int i=0;i<menus.length;i++){
					if(((JMenu)menus[i]).getText()==null || adi==null) continue;
					if(((JMenu)menus[i]).getText().equals(adi)){
						Component[] vn=((JMenu)menus[i]).getMenuComponents();
						//table.setTableView(analyzers[i],n,true);
						for(int j=0;j<vn.length;j++)
							if(degerAdi.equals(((JCheckBoxMenuItem)vn[j]).getText())){
								((JCheckBoxMenuItem)vn[j]).setState(true);
								break;
							}
						break;
					}
				}
				
				for(JPaketAnalizci analizci:analizciler)
					if(analizci.getProtocolName().equals(adi)){
						tablo.setTableView(analizci,degerAdi,true);
						break;
					}
			}
		}
	}
	
	void nitelikleriKaydet(){
		String[] gorunumDurumu=tablo.tabloGorunumDurumunuGetir();
		if(gorunumDurumu.length>0){
			StringBuffer buf=new StringBuffer(gorunumDurumu[0]);
			for(int i=1;i<gorunumDurumu.length;i++)
				buf.append(","+gorunumDurumu[i]);
			PacCap.tercihler.put("TableView",buf.toString());
		}
	}
}
