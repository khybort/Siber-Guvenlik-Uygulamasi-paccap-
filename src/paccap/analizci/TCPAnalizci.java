package paccap.analizci;
import jpcap.packet.*;
import java.util.*;

public class TCPAnalizci extends JPaketAnalizci
{
	private static final String[] degerAdlari={
		"Kaynak Port",
		"Hedef Port",
		"Sequence Number",
		"Ack Number",
		"URG Flag",
		"ACK Flag",
		"PSH Flag",
		"RST Flag",
		"SYN Flag",
		"FIN Flag",
		"Window Size"};
	Hashtable degerler=new Hashtable();
	
	public TCPAnalizci(){
		katman=TRANSPORT_LAYER;
	}
	
	public boolean isAnalyzable(Packet p){
		return (p instanceof TCPPacket);
	}
	
	public String getProtocolName(){
		return "TCP";
	}
	
	public String[] getValueNames(){
		return degerAdlari;
	}
	
	public void analyze(Packet p){
		degerler.clear();
		if(!isAnalyzable(p)) return;
		TCPPacket tcp=(TCPPacket)p;
		degerler.put(degerAdlari[0],new Integer(tcp.src_port));
		degerler.put(degerAdlari[1],new Integer(tcp.dst_port));
		degerler.put(degerAdlari[2],new Long(tcp.sequence));
		degerler.put(degerAdlari[3],new Long(tcp.ack_num));
		degerler.put(degerAdlari[4],new Boolean(tcp.urg));
		degerler.put(degerAdlari[5],new Boolean(tcp.ack));
		degerler.put(degerAdlari[6],new Boolean(tcp.psh));
		degerler.put(degerAdlari[7],new Boolean(tcp.rst));
		degerler.put(degerAdlari[8],new Boolean(tcp.syn));
		degerler.put(degerAdlari[9],new Boolean(tcp.fin));
		degerler.put(degerAdlari[10],new Integer(tcp.window));
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
