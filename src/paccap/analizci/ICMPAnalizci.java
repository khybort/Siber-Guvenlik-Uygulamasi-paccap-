package paccap.analizci;
import jpcap.packet.*;
import java.util.*;

public class ICMPAnalizci extends JPaketAnalizci
{
	private static final String[] degerAdlari={
		"Tip",
		"Kod",
		"ID",
		"Sequence",
		"Yönlendirme Adresi",
		"Maskeleme Adresi",
		"Orijinal tarih bilgisi",
		"Alış tarih bilgisi",
		"İletiliş tarih bilgisi"
	};
	
	private static final String[] tipAdlari={
		"Echo Reply(0)",
		"Unknown(1)",
		"Unknown(2)",
		"Destination Unreachable(3)",
		"Source Quench(4)",
		"Redirect(5)",
		"Unknown(6)",
		"Unknown(7)",
		"Echo(8)",
		"Unknown(9)",
		"Unknown(10)",
		"Time Exceeded(11)",
		"Parameter Problem(12)",
		"Timestamp(13)",
		"Timestamp Reply(14)",
		"Unknown(15)",
		"Unknown(16)",
		"Address Mask Request(17)",
		"Address Mask Reply(18)"
	};
	
	private Hashtable degerler=new Hashtable();
	
	public ICMPAnalizci(){
		katman=TRANSPORT_LAYER;
	}
	
	public boolean isAnalyzable(Packet p){
		return (p instanceof ICMPPacket);
	}
	
	public String getProtocolName(){
		return "ICMP";
	}
	
	public String[] getValueNames(){
		return degerAdlari;
	}
	
	public void analyze(Packet p){
		if(!isAnalyzable(p)) return;
		degerler.clear();
		
		ICMPPacket icmp=(ICMPPacket)p;
		if(icmp.type>=tipAdlari.length){
			degerler.put(degerAdlari[0],String.valueOf(icmp.type));
		}else{
			degerler.put(degerAdlari[0],tipAdlari[icmp.type]);
		}
		degerler.put(degerAdlari[1],new Integer(icmp.code));
		
		if(icmp.type==0 || icmp.type==8 || (icmp.type>=13 && icmp.type<=18)){
			degerler.put(degerAdlari[2],new Integer(icmp.id));
			degerler.put(degerAdlari[3],new Integer(icmp.seq));
		}
		
		if(icmp.type==5)
			degerler.put(degerAdlari[4],icmp.redir_ip);
		
		if(icmp.type==17 || icmp.type==18)
			degerler.put(degerAdlari[5],(icmp.subnetmask>>12)+"."+
			                         ((icmp.subnetmask>>8)&0xff)+"."+
			                         ((icmp.subnetmask>>4)&0xff)+"."+
			                         (icmp.subnetmask&0xff)+".");
		
		if(icmp.type==13 || icmp.type==14){
			degerler.put(degerAdlari[6],new Long(icmp.orig_timestamp));
			degerler.put(degerAdlari[7],new Long(icmp.recv_timestamp));
			degerler.put(degerAdlari[8],new Long(icmp.trans_timestamp));
		}
	}
	
	public Object getValue(String valueName){
		return degerler.get(valueName);
	}
	
	public Object getValueAt(int index){
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
