package paccap.analizci;
import jpcap.packet.*;

public class PaketAnalizci extends JPaketAnalizci
{
	private static final String[] degerAdlari={"Yakalama Süresi","Yakalama Uzunluğu"};
	private Packet paket;
	
	public boolean isAnalyzable(Packet packet){
		return true;
	}
	
	public String getProtocolName(){
		return "Paket Bilgisi";
	}
	
	public String[] getValueNames(){
		  return degerAdlari;
	}
	
	public void analyze(Packet p){
		paket=p;
	}
	
	public Object getValue(String name){
		if(name.equals(degerAdlari[0]))
			return new java.util.Date(paket.sec*1000+paket.usec/1000).toString();
		else if(name.equals(degerAdlari[1]))
			return new Integer(paket.caplen);
		else return null;
	}
	
	Object getValueAt(int index){
		switch(index){
			case 0: return new java.util.Date(paket.sec*1000+paket.usec/1000).toString();
			case 1: return new Integer(paket.caplen);
			default: return null;
		}
	}
	
	public Object[] getValues(){
		Object[] v=new Object[2];
		v[0]=new java.util.Date(paket.sec*1000+paket.usec/1000).toString();
		v[1]=new Integer(paket.caplen);
		
		return v;
	}
}