package paccap.stat;
import jpcap.packet.*;
import java.util.*;

public class PaketIstatistigi extends IstatistikAlici
{
	static final String[] tipler={
		"Toplam paket #",
		"Toplam paket boyutu",
		"Ortalama paket boyutu",
		"bits/s",
		"pkts/s"
	};
	static final String[] etiket={"Değer"};
	
	long paketSayisi,paketBoyutu;
	Date ilk,son;
	
	public String getName(){
		return "Genel Bilgi";
	}
	
	public void analyze(List<Packet> paketler){
		if(paketler.size()>0){
			Packet fp=(Packet)paketler.get(0),lp=(Packet)paketler.get(paketler.size()-1);
			ilk=new Date(fp.sec*1000+fp.usec/1000);
			son=new Date(lp.sec*1000+lp.usec/1000);
		}
		
		for(int i=0;i<paketler.size();i++){
			paketSayisi++;
			paketBoyutu+=((Packet)paketler.get(i)).len;
		}
	}
	
	public void addPacket(Packet p){
		if(ilk==null){
			ilk=new Date(p.sec*1000+p.usec/1000);
		}
		son=new Date(p.sec*1000+p.usec/1000);
		
		paketSayisi++;
		paketBoyutu+=p.len;
	}
	
	public String[] getLabels(){return etiket;}
	public String[] getStatTypes(){return tipler;}
	
	public long[] getValues(int index){
		long[] ret=new long[1];
		switch(index){
			case 0: //Total packet #
				 ret[0]=paketSayisi;
				 return ret;
			case 1: //Total packet size
				ret[0]=paketBoyutu;
				return ret;
			case 2: //Avecage packet size
				if(paketSayisi==0) ret[0]=0;
				else ret[0]=paketBoyutu/paketSayisi;
				return ret;
			case 3: //bits/s
			case 4: //pkts/s
				if(ilk==null) ret[0]=0;
				else{
					long sec=(son.getTime()-ilk.getTime())*1000;
					if(sec==0) ret[0]=0;
					else
						if(index==3) ret[0]=paketBoyutu*8/sec;
						else ret[0]=paketSayisi/sec;
				}
				return ret;
			default:
				return null;
		}
	}
	/*
	String[] getTableLabels(){
		return labels;
	}
	
	Object[][] getTableValues(){
		Object[][] obj=new Object[1][5];
		
		obj[0][0]=new Long(numOfPs);
		obj[0][1]=new Long(sizeOfPs);
		obj[0][2]=new Long(sizeOfPs/numOfPs);
		if(first==null){
			obj[0][3]=new Long(0);
			obj[0][4]=new Long(0);
		}else{
			long sec=(last.getTime()-first.getTime())*1000;
			if(sec==0){
				obj[0][3]=new Long(0);
				obj[0][4]=new Long(0);
			}else{
				obj[0][3]=new Double((double)sizeOfPs*8.0/sec);
				obj[0][4]=new Double((double)numOfPs/sec);
			}
		}
		
		return obj;
	}
	*/
	public void clear(){
		paketSayisi=0;paketBoyutu=0;
		ilk=null;son=null;
	}
}
