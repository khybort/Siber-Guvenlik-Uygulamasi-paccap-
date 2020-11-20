package paccap.analizci;
import jpcap.packet.*;

public class EthernetAnalizci extends JPaketAnalizci
{
	private static final String[] degerAdlari={
		"Çerçeve Tipi",
		"Kaynak  MAC",
		"Hedef MAC"
	};
	private EthernetPacket eth;

	public EthernetAnalizci(){
		katman=DATALINK_LAYER;
	}
	
	public boolean isAnalyzable(Packet p){
		return (p.datalink!=null && p.datalink instanceof EthernetPacket);
	}

	public String getProtocolName(){
		return "Ethernet Frame";
	}

	public String[] getValueNames(){
		return degerAdlari;
	}

	public void analyze(Packet p){
		if(!isAnalyzable(p)) return;
		eth=(EthernetPacket)p.datalink;
	}

	public Object getValue(String degerAdi){
		for(int i=0;i<degerAdlari.length;i++)
			if(degerAdlari[i].equals(degerAdi))
				return getValueAt(i);

		return null;
	}

	Object getValueAt(int index){
		switch(index){
		case 0: return new Integer(eth.frametype);
		case 1: return eth.getSourceAddress();
		case 2: return eth.getDestinationAddress();
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
