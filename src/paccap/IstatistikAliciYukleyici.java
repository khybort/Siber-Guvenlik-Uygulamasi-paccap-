package paccap;
import java.util.*;

import paccap.stat.UygulamaProtokolIstatistigi;
import paccap.stat.BosBellekIstatistigi;
import paccap.stat.IstatistikAlici;
import paccap.stat.AgProtokoluIstatistigi;
import paccap.stat.PaketIstatistigi;
import paccap.stat.TasimaProtokoluIstatistigi;

public class IstatistikAliciYukleyici//staker=istatistik alıcı
{
	static ArrayList<IstatistikAlici> stakers=new ArrayList<IstatistikAlici>();
	
	static void istatistikAliciYukle(){
		stakers.add(new PaketIstatistigi());
		stakers.add(new AgProtokoluIstatistigi());
		stakers.add(new TasimaProtokoluIstatistigi());
		stakers.add(new UygulamaProtokolIstatistigi());
		stakers.add(new BosBellekIstatistigi());
	}
	
	public static List<IstatistikAlici> istatistikAlicilariGetir(){
		return stakers;
	}
	
	public static IstatistikAlici istatistikAliciyiGetirAt(int indeks){
		return stakers.get(indeks);
	}
}
