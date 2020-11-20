package paccap.stat;
import java.util.*;

import jpcap.packet.Packet;

public class BosBellekIstatistigi extends IstatistikAlici
{
	String[] etiketler={"Boş bellek"};
	String[] tipler={"Bytes"};

	public String getName(){
		return "Boş bellek";
	}

	public void analyze(List<Packet> paketler){}
	public void addPacket(jpcap.packet.Packet p){}

	public String[] getLabels(){
		return etiketler;
	}

	public String[] getStatTypes(){
		return tipler;
	}

	public long[] getValues(int index){
		long[] ret=new long[1];
		ret[0]=Runtime.getRuntime().freeMemory();//Runtime
		return ret;
	}
	public void clear(){}
}
