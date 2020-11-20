package paccap.stat;
import java.util.List;
import java.util.Vector;
import jpcap.packet.Packet;

public abstract class IstatistikAlici
{
	public abstract String getName();

	public abstract void analyze(List<Packet> paketler);
	public abstract void addPacket(Packet p);
	
	public abstract String[] getLabels();
	public abstract String[] getStatTypes();
	public abstract long[] getValues(int indeks);
	
	public abstract void clear();
	
	public IstatistikAlici newInstance(){//Yeni örnek oluşturur
		try{
			return (IstatistikAlici)this.getClass().newInstance();
		}catch(Exception e){
			return null;
		}
	}
}