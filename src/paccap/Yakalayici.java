/*
 * Created on Apr 4, 2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package paccap;

import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import paccap.stat.IstatistikAlici;
import paccap.ui.YakalamaPenceresi;
import paccap.ui.BirikimliIstatistikCerceve;
import paccap.ui.KumulatifIstatistikCerceve;
import paccap.ui.Cerceve;
import paccap.ui.IstatikselCerceve;

import jpcap.JpcapCaptor;
import jpcap.PacketReceiver;
import jpcap.JpcapWriter;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;

/**
 * @author kfujii
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class Yakalayici {
	long MAX_PACKETS_HOLD=10000;

	static List<Packet> paketler = new ArrayList<Packet>();

	JpcapCaptor jpcap=null;

	boolean isLiveCapture;
	boolean isSaved = false;

	Cerceve cerceve;

	public void setFrame(Cerceve cerceve){
		this.cerceve=cerceve;
	}

	public List<Packet> getPackets(){
            
		return paketler;
	}


	public void cihazdanPaketleriYakala() {
		if(jpcap!=null)
			jpcap.close();
		jpcap = YakalamaPenceresi.getJpcap(cerceve);
		temizle();
		
		if (jpcap != null) {
			isLiveCapture = true;
			cerceve.yakalamaDevredisi();

			yakalamaThreadiniBaslat();
		}
	}

	public void dosyadanPaketleriYukle() {
		isLiveCapture = false;
		temizle();

		int ret = PacCap.secici.showOpenDialog(cerceve);
		if (ret == JFileChooser.APPROVE_OPTION) {
			String path = PacCap.secici.getSelectedFile().getPath();

			try {
				if(jpcap!=null){
					jpcap.close();
				}
				jpcap = JpcapCaptor.openFile(path);
			} catch (java.io.IOException e) {
				JOptionPane.showMessageDialog(
					cerceve,
					"Açılamayan dosya: " + path);
				e.printStackTrace();
				return;
			}

			cerceve.yakalamaDevredisi();

			yakalamaThreadiniBaslat();
		}
	}

	private void temizle(){
		paketler.clear();
		cerceve.temizle();

		for(int i=0;i<statCerceve.size();i++)
			((IstatikselCerceve)statCerceve.get(i)).clear();
	}

	public void dosyayaKaydet() {
		if (paketler == null)
			return;

		int ret = PacCap.secici.showSaveDialog(cerceve);
		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = PacCap.secici.getSelectedFile();

			if (file.exists()) {
				if (JOptionPane
					.showConfirmDialog(
						cerceve,
						"Overwrite " + file.getName() + "?",
						"Overwrite?",
						JOptionPane.YES_NO_OPTION)
					== JOptionPane.NO_OPTION) {
					return;
				}
			}

			try {
				//System.out.println("link:"+info.linktype);
				//System.out.println(lastJpcap);
				JpcapWriter writer = JpcapWriter.openDumpFile(jpcap,file.getPath());

				for (Packet p:paketler) {
					writer.writePacket(p);
				}

				writer.close();
				isSaved = true;
				//JOptionPane.showMessageDialog(frame,file+" was saved correctly.");
			} catch (java.io.IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(
					cerceve,
					"Kaydedilemeyen dosya: " + file.getPath());
			}
		}
	}

	public void yakalamayiDurdur() {
		yakalamaThreadiniDurdur();
	}

	public void kaydedilmediyseKaydet() {
		if (isLiveCapture && !isSaved) {
			int ret =
				JOptionPane.showConfirmDialog(
					null,
					"Save this data?",
					"Save this data?",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION)
				dosyayaKaydet();
		}
	}

	List<IstatikselCerceve> statCerceve=new ArrayList<IstatikselCerceve>();
	public void kumulatifIstatistikCercevesiEkle(IstatistikAlici istatistikAlici) {
		statCerceve.add(KumulatifIstatistikCerceve.openWindow(paketler,istatistikAlici.newInstance()));
	}

	public void birikimliIstatistikCercevesiEkle(IstatistikAlici istatistikAlici) {
		statCerceve.add(BirikimliIstatistikCerceve.openWindow(paketler,istatistikAlici.newInstance()));
	}

	public void tumPencereleriKapat(){
		for(int i=0;i<statCerceve.size();i++)
			((IstatikselCerceve)statCerceve.get(i)).dispose();
	}



	private Thread yakalamaThread;

	private void yakalamaThreadiniBaslat() {
		if (yakalamaThread != null)
			return;

		yakalamaThread = new Thread(new Runnable(){
			//Yakalama Threadinin gövdesi
			public void run() {
				while (yakalamaThread != null) {
					if (jpcap.processPacket(1, denetleyici) == 0 && !isLiveCapture)
						yakalamaThreadiniDurdur();
					Thread.yield();
				}

				jpcap.breakLoop();
				//jpcap = null;
				cerceve.yakalamaDevrede();
			}
		});
		yakalamaThread.setPriority(Thread.MIN_PRIORITY);
		
		cerceve.guncellemeyeBasla();
		for(int i=0;i<statCerceve.size();i++){
			((IstatikselCerceve)statCerceve.get(i)).guncellemeyeBasla();
		}
		
		yakalamaThread.start();
	}

	void yakalamaThreadiniDurdur() {
		yakalamaThread = null;
		cerceve.guncellemeyiDurdur();
		for(int i=0;i<statCerceve.size();i++){
			((IstatikselCerceve)statCerceve.get(i)).guncellemeyiDurdur();
		}
	}

	private ExecutorService exe=Executors.newFixedThreadPool(10);
	public static final Map<InetAddress,String> hostnameOnbellegi=new HashMap<InetAddress, String>();
	
	private PacketReceiver denetleyici=new PacketReceiver(){//handler
		public void receivePacket(final Packet paket) {
			paketler.add(paket);
			while (paketler.size() > MAX_PACKETS_HOLD) {
				paketler.remove(0);
			}
			if (!statCerceve.isEmpty()) {
				for (int i = 0; i < statCerceve.size(); i++)
					((IstatikselCerceve)statCerceve.get(i)).addPacket(paket);
			}
			isSaved = false;
			
			if(paket instanceof IPPacket){
				exe.execute(new Runnable(){
					public void run() {
						IPPacket ip=(IPPacket)paket;
						if(!hostnameOnbellegi.containsKey(ip.src_ip))
							hostnameOnbellegi.put(ip.src_ip,ip.src_ip.getHostName());
						if(!hostnameOnbellegi.containsKey(ip.dst_ip))
							hostnameOnbellegi.put(ip.dst_ip,ip.dst_ip.getHostName());
						//System.out.println(hostnameOnbellegi.size());
					}
				});
			}
		}
	};

}
