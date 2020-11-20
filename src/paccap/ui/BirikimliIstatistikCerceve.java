package paccap.ui;
import jpcap.packet.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import paccap.stat.IstatistikAlici;
import paccap.ui.graph.CizgiGraf;
//Birikimli grafiksel değer oluşturma
public class BirikimliIstatistikCerceve extends IstatikselCerceve
{
	CizgiGraf cizgiGrafigi;
	
	IstatistikAlici staker;
	int istatistikTipi;
	boolean zamanOlcegiCiz; //true-> time, false->packet#
	int sayi,mevcutSayi=0;
	long currentSec=0;
	
	public static BirikimliIstatistikCerceve openWindow(List<Packet> packets,IstatistikAlici staker){
		BirikimliIstatistikCerceve frame=new BirikimliIstatistikCerceve(packets,5,true,staker,0);
		frame.setVisible(true);
		return frame;
	}
	
	BirikimliIstatistikCerceve(List<Packet> paketler,int sayi,boolean isTime,IstatistikAlici staker,int tip){
		super(staker.getName()+" ["+staker.getStatTypes()[tip]+"]");
		this.staker=staker;
		this.zamanOlcegiCiz=isTime;this.sayi=sayi;
		istatistikTipi=tip;
		
		cizgiGrafigi=new CizgiGraf(staker.getLabels());
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(cizgiGrafigi,BorderLayout.CENTER);
		setSize(400,400);
		
		if(paketler==null || paketler.size()==0) return;
		
		Iterator it=paketler.iterator();
		currentSec=((Packet)paketler.get(0)).sec;
		mevcutSayi=0;
		int index=0;
		if(isTime){
			while(index<paketler.size()){
				Packet p=(Packet)paketler.get(index++);
				
				while(index<paketler.size() && p.sec-currentSec<=sayi){
					staker.addPacket(p);
					p=(Packet)paketler.get(index++);
				}
				if(index==paketler.size()) break;
				currentSec+=sayi;
				index--;
				cizgiGrafigi.addValue(staker.getValues(tip));
				staker.clear();
			}
		}else{
			while(it.hasNext()){
				for(int i=0;it.hasNext() && i<sayi;i++,mevcutSayi++)
					staker.addPacket((Packet)it.next());
				if(!it.hasNext()) break;
				mevcutSayi=0;
				cizgiGrafigi.addValue(staker.getValues(tip));
				staker.clear();
			}
		}
	}
	
	public void addPacket(Packet p){
		staker.addPacket(p);
		if(zamanOlcegiCiz){
			if(currentSec==0) currentSec=p.sec;
			if(p.sec-currentSec>sayi){
				cizgiGrafigi.addValue(staker.getValues(istatistikTipi));
				staker.clear();
				currentSec+=sayi;
				if(p.sec-currentSec>sayi)
					for(long s=p.sec-currentSec-sayi;s>sayi;s-=sayi){
						cizgiGrafigi.addValue(staker.getValues(istatistikTipi));
					}
			}
		}else{
			mevcutSayi++;
			if(mevcutSayi==sayi){
				cizgiGrafigi.addValue(staker.getValues(istatistikTipi));
				staker.clear();
				mevcutSayi=0;
			}
		}
	}
	
	public void clear(){
		mevcutSayi=0;
		currentSec=0;
		cizgiGrafigi.clear();
	}

	void fireUpdate(){
		repaint();//Applet, Ekrandaki değişimi göstermek için kullanılır
	}
}
