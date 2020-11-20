package paccap;
import paccap.analizci.ARPAnalizci;
import paccap.analizci.SMTPAnalizci;
import paccap.analizci.HTTPAnalizci;
import paccap.analizci.TCPAnalizci;
import paccap.analizci.EthernetAnalizci;
import paccap.analizci.TelnetAnalizci;
import paccap.analizci.ICMPAnalizci;
import paccap.analizci.SSHAnalizci;
import paccap.analizci.IPv6Analizci;
import paccap.analizci.IPv4Analizci;
import paccap.analizci.JPaketAnalizci;
import paccap.analizci.UDPAnalizci;
import paccap.analizci.PaketAnalizci;
import paccap.analizci.POP3Analizci;
import paccap.analizci.FTPAnalizci;
import java.util.*;


public class JPaketAnalizciYukleyici
{
	static List<JPaketAnalizci> analizciler=new ArrayList<JPaketAnalizci>();
	static List<List<JPaketAnalizci>> katmanAnalizcileri=new ArrayList<List<JPaketAnalizci>>();
	
	static void loadDefaultAnalyzer(){
		analizciler.add(new PaketAnalizci());
		analizciler.add(new EthernetAnalizci());
		analizciler.add(new IPv4Analizci());
		analizciler.add(new IPv6Analizci());
		analizciler.add(new TCPAnalizci());
		analizciler.add(new UDPAnalizci());
		analizciler.add(new ICMPAnalizci());
		analizciler.add(new HTTPAnalizci());
		analizciler.add(new FTPAnalizci());
		analizciler.add(new TelnetAnalizci());
		analizciler.add(new SSHAnalizci());
		analizciler.add(new SMTPAnalizci());
		analizciler.add(new POP3Analizci());
		analizciler.add(new ARPAnalizci());
		
		for(int i=0;i<10;i++)
			katmanAnalizcileri.add(new ArrayList<JPaketAnalizci>());
		
		for(JPaketAnalizci a:analizciler)
			katmanAnalizcileri.get(a.katman).add(a);
	}
	
	public static List<JPaketAnalizci> getAnalyzers(){
		return analizciler;
	}
	
	public static List<JPaketAnalizci> getAnalyzersOf(int katman){
		return katmanAnalizcileri.get(katman);
	}
}
