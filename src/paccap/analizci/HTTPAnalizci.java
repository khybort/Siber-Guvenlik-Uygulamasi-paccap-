package paccap.analizci;
import jpcap.packet.*;
import java.util.*;
import java.io.*;

public class HTTPAnalizci extends JPaketAnalizci
{
	private static final String[] degerAdlari={
		"Metod",
		"Başlık"
	};
	String metot;
	Vector basliklar=new Vector();
	
	public HTTPAnalizci(){
		katman=APPLICATION_LAYER;
	}
	
	public boolean isAnalyzable(Packet p){
		if(p instanceof TCPPacket &&
		   (((TCPPacket)p).src_port==80 || ((TCPPacket)p).dst_port==80))
			return true;
		else return false;
	}
	
	public String getProtocolName(){
		return "HTTP";
	}
	
	public String[] getValueNames(){
		return degerAdlari;
	}
	
	public void analyze(Packet p){
		metot="";
		basliklar.removeAllElements();
		if(!isAnalyzable(p)) return;
		
		try{
			BufferedReader in=new BufferedReader(new StringReader(new String(p.data)));
			
			metot=in.readLine();
			if(metot==null || metot.indexOf("HTTP")==-1){
				// this packet doesn't contain HTTP header
				metot="HTTP başlığı değil";
				return;
			}
			
			String l;
			//read headers
			while((l=in.readLine()).length()>0)
				basliklar.addElement(l);
		}catch(IOException e){}
	}
	
	public Object getValue(String degerAdi){
		if(degerAdlari[0].equals(degerAdi)) return metot;
		if(degerAdlari[1].equals(degerAdi)) return basliklar;
		return null;
	}
	
	Object getValueAt(int indeks){
		if(indeks==0) return metot;
		if(indeks==1) return basliklar;
		return null;
	}
	
	public Object[] getValues(){
		Object[] values=new Object[2];
		values[0]=metot;
		values[1]=basliklar;
		
		return values;
	}
}
