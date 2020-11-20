package paccap.stat;
import jpcap.packet.*;
import java.util.*;

import paccap.JPaketAnalizciYukleyici;
import paccap.analizci.JPaketAnalizci;

public class TasimaProtokoluIstatistigi extends IstatistikAlici
{
	List<JPaketAnalizci> analizciler;
	long[] paketSayisi;
	long[] paketBoyutu;
	long toplamPaket,toplamBoyut;
	String[] etiketler;
	static final String[] tipler={"# of packets","% of packets","total packet size","% of size"};
	
	public TasimaProtokoluIstatistigi(){
		analizciler=JPaketAnalizciYukleyici.getAnalyzersOf(JPaketAnalizci.TRANSPORT_LAYER);
		paketSayisi=new long[analizciler.size()+1];
		paketBoyutu=new long[analizciler.size()+1];
		
		etiketler=new String[analizciler.size()+1];
		for(int i=0;i<analizciler.size();i++)
			etiketler[i]=analizciler.get(i).getProtocolName();
		etiketler[analizciler.size()]="Other";
	}
	
	public String getName(){
		return "Taşıma katmanı protokolü oranı";
	}
	
	public void analyze(List<Packet> packets){
		for(int i=0;i<packets.size();i++){
			Packet p=(Packet)packets.get(i);
			toplamPaket++;
			
			boolean flag=false;
			for(int j=0;j<analizciler.size();j++)
				if(analizciler.get(j).isAnalyzable(p)){
					paketSayisi[j]++;
					paketBoyutu[j]+=((IPPacket)p).length;
					toplamBoyut+=((IPPacket)p).length;
					flag=true;
					break;
				}
			if(!flag){
				paketSayisi[paketSayisi.length-1]++;
				paketBoyutu[paketBoyutu.length-1]+=p.len-12;
				toplamBoyut+=p.len-12;
			}
		}
	}
	
	public void addPacket(Packet p){
		boolean flag=false;
		toplamPaket++;
		for(int j=0;j<analizciler.size();j++)
			if(analizciler.get(j).isAnalyzable(p)){
				paketSayisi[j]++;
				paketBoyutu[j]+=((IPPacket)p).length;
				toplamBoyut+=((IPPacket)p).length;
				flag=true;
				break;
			}
		if(!flag){
			paketSayisi[paketSayisi.length-1]++;
			paketBoyutu[paketBoyutu.length-1]+=p.len-12;
			toplamBoyut+=p.len-12;
		}
	}
	
	public String[] getLabels(){
		return etiketler;
	}
	
	public String[] getStatTypes(){
		return tipler;
	}
	
	public long[] getValues(int indeks){
		switch(indeks){
			case 0: //# of packets
				if(paketSayisi==null) return new long[0];
				return paketSayisi;
			case 1: //% of packets
				long[] yuzdeler=new long[paketSayisi.length];
				if(toplamPaket==0) return yuzdeler;
				for(int i=0;i<paketSayisi.length;i++)
					yuzdeler[i]=paketSayisi[i]*100/toplamPaket;
				return yuzdeler;
			case 2: //total packet size
				if(paketBoyutu==null) return new long[0];
				return paketBoyutu;
			case 3: //% of size
				long[] yuzdeler2 =new long[paketBoyutu.length];
				if(toplamBoyut==0) return yuzdeler2;
				for(int i=0;i<paketBoyutu.length;i++)
					yuzdeler2[i]=paketBoyutu[i]*100/toplamBoyut;
				return yuzdeler2;
			default:
				return null;
		}
	}
/*	int[] getValues(){
		return numOfPs;
	}
	
	String[] getTableLabels(){
		String[] ls=new String[labels.length+1];
		ls[0]=new String();
		System.arraycopy(labels,0,ls,1,labels.length);
		
		return ls;
	}
	
	Object[][] getTableValues(){
		if(numOfPs==null) return new Object[0][0];
		long sum=0;
		Object[][] obj=new Object[4][labels.length+1];
		
		obj[0][0]="# of packets";
		for(int i=0;i<numOfPs.length;i++){
			obj[0][i+1]=new Long(numOfPs[i]);
			sum+=numOfPs[i];
		}
		
		obj[1][0]="% of packet #";
		for(int i=0;i<numOfPs.length;i++){
			if(sum==0) obj[1][i+1]=new Integer(0);
			else obj[1][i+1]=new Integer(numOfPs[i]*100/(int)sum);
		}
		
		sum=0;
		obj[2][0]="size of packets";
		for(int i=0;i<sizeOfPs.length;i++){
			obj[2][i+1]=new Long(sizeOfPs[i]);
			sum+=sizeOfPs[i];
		}
		
		obj[3][0]="% of size";
		for(int i=0;i<sizeOfPs.length;i++){
			if(sum==0) obj[3][i+1]=new Long(0);
			else obj[3][i+1]=new Long(sizeOfPs[i]*100/sum);
		}
		
		return obj;
	}
	*/
	public void clear(){
		paketSayisi=new long[analizciler.size()+1];
		paketBoyutu=new long[analizciler.size()+1];
		toplamPaket=0;
		toplamBoyut=0;
	}
}
