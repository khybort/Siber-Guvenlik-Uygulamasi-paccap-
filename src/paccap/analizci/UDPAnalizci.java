package paccap.analizci;
import jpcap.packet.*;

public class UDPAnalizci extends JPaketAnalizci
{
	private static final String[] degerAdlari={
		"Kaynak Port",
		"Hedef Port",
		"Paket Uzunluğu"
	};
	private UDPPacket udp;
	
	public UDPAnalizci(){
		katman=TRANSPORT_LAYER;
	}
	
	public boolean isAnalyzable(Packet p){
		return (p instanceof UDPPacket);
	}
	
	public String getProtocolName(){
		return "UDP";
	}
	
	public String[] getValueNames(){
		return degerAdlari;
	}
	
	public void analyze(Packet p){
		if(!isAnalyzable(p)) return;
		udp=(UDPPacket)p;
	}
	
	public Object getValue(String valueName){
		for(int i=0;i<degerAdlari.length;i++)
			if(degerAdlari[i].equals(valueName))
				return getValueAt(i);
		
		return null;
	}
	
	public Object getValueAt(int index){
		switch(index){
			case 0: return new Integer(udp.src_port);
			case 1: return new Integer(udp.dst_port);
			case 2: return new Integer(udp.length);
			default: return null;
		}
	}
	
	public Object[] getValues(){
		Object[] v=new Object[3];
		for(int i=0;i<3;i++)
			v[i]=getValueAt(i);
		
		return v;
	}
}
