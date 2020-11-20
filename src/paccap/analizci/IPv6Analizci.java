package paccap.analizci;
import jpcap.packet.*;
import java.util.*;

public class IPv6Analizci extends JPaketAnalizci
{
	private static final String[] degerAdlari={
		"Versiyon",
		"Sınıf",
		"Akış Etiketi",
		"Uzunluk",
		"Protokol",
		"Hop Limit",
		"Kaynak IP",
		"Hedef IP",
		"Kaynak Host Name",
		"Hedef Host Name"};
	
	Hashtable degerler=new Hashtable();
	
	public IPv6Analizci(){
		katman=NETWORK_LAYER;
	}
	
	public boolean isAnalyzable(Packet p){
		if(p instanceof IPPacket && ((IPPacket)p).version==6) return true;
		else return false;
	}
	
	public String getProtocolName(){
		return "IPv6";
	}
	
	public String[] getValueNames(){
		return degerAdlari;
	}
	
	public void analyze(Packet packet){
		degerler.clear();
		if(!isAnalyzable(packet))	return;
		IPPacket ip=(IPPacket)packet;
		degerler.put(degerAdlari[0],new Integer(6));
		degerler.put(degerAdlari[1],new Integer(ip.priority));
		degerler.put(degerAdlari[2],new Integer(ip.flow_label));
		degerler.put(degerAdlari[3],new Integer(ip.length));
		degerler.put(degerAdlari[4],new Integer(ip.protocol));
		degerler.put(degerAdlari[5],new Integer(ip.hop_limit));
		degerler.put(degerAdlari[6],ip.src_ip.getHostAddress());
		degerler.put(degerAdlari[7],ip.dst_ip.getHostAddress());
		degerler.put(degerAdlari[8],ip.src_ip.getHostName());
		degerler.put(degerAdlari[9],ip.dst_ip.getHostName());
	}
	
	public Object getValue(String valueName){
		return degerler.get(valueName);
	}
	
	Object getValueAt(int index){
		if(index<0 || index>=degerAdlari.length) return null;
		return degerler.get(degerAdlari[index]);
	}
	
	public Object[] getValues(){
		Object[] v=new Object[degerAdlari.length];
		
		for(int i=0;i<degerAdlari.length;i++)
			v[i]=degerler.get(degerAdlari[i]);
		
		return v;
	}
}
