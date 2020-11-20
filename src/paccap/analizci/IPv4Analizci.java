package paccap.analizci;
import java.net.InetAddress;
import java.util.Hashtable;

import paccap.Yakalayici;

import jpcap.packet.IPPacket;
import jpcap.packet.Packet;

public class IPv4Analizci extends JPaketAnalizci
{
	private static final String[] degerAdlari={"Versiyon",
		"TOS: Oncelik",
		"TOS: Cikti",
		"TOS: Guvenilirlik",
		"Uzunluk",
		"Identification",
		"Fragment: Don't Fragment",
		"Fragment: More Fragment",
		"Fragment Offset",
		"Yasam degeri",
		"Protokol",
		"Kaynak IP",
		"Hedef IP",
		"Kaynak Host Name",
		"Hedef Host Name"};
	private Hashtable degerler=new Hashtable();
	
	public IPv4Analizci(){
		katman=NETWORK_LAYER;
	}
	
	public boolean isAnalyzable(Packet p){
		if(p instanceof IPPacket && ((IPPacket)p).version==4) return true;
		else return false;
	}
	
	public String getProtocolName(){
		return "IPv4";
	}
	
	public String[] getValueNames(){
		return degerAdlari;
	}
	
	public void analyze(Packet packet){
		degerler.clear();
		if(!isAnalyzable(packet))	return;
		final IPPacket ip=(IPPacket)packet;
		degerler.put(degerAdlari[0],new Integer(4));
		degerler.put(degerAdlari[1],new Integer(ip.priority));
		degerler.put(degerAdlari[2],new Boolean(ip.t_flag));
		degerler.put(degerAdlari[3],new Boolean(ip.r_flag));
		degerler.put(degerAdlari[4],new Integer(ip.length));
		degerler.put(degerAdlari[5],new Integer(ip.ident));
		degerler.put(degerAdlari[6],new Boolean(ip.dont_frag));
		degerler.put(degerAdlari[7],new Boolean(ip.more_frag));
		degerler.put(degerAdlari[8],new Integer(ip.offset));
		degerler.put(degerAdlari[9],new Integer(ip.hop_limit));
		degerler.put(degerAdlari[10],new Integer(ip.protocol));
		degerler.put(degerAdlari[11],ip.src_ip.getHostAddress());
		degerler.put(degerAdlari[12],ip.dst_ip.getHostAddress());
		degerler.put(degerAdlari[13],ip.src_ip);
		degerler.put(degerAdlari[14],ip.dst_ip);
	}
	
	public Object getValue(String degerAdi){
		if((degerAdlari[13].equals(degerAdi) && degerler.get(degerAdi) instanceof InetAddress) ||
		   (degerAdlari[14].equals(degerAdi) && degerler.get(degerAdi) instanceof InetAddress)){
			
			InetAddress addr=(InetAddress)degerler.get(degerAdi);
			if(Yakalayici.hostnameOnbellegi.containsKey(addr))
				degerler.put(degerAdi,Yakalayici.hostnameOnbellegi.get(addr));
			else{
				degerler.put(degerAdi,addr.getHostName());
				System.out.println("miss");
			}
		}

		return degerler.get(degerAdi);
	}
	
	Object getValueAt(int index){
		if(index<0 || index>=degerAdlari.length) return null;
		
		return getValue(degerAdlari[index]);
	}
	
	public Object[] getValues(){
		Object[] v=new Object[degerAdlari.length];
		
		for(int i=0;i<degerAdlari.length;i++)
			v[i]=getValueAt(i);
		
		return v;
	}
}
