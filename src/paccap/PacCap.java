package paccap;
import java.util.ArrayList;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import paccap.ui.Cerceve;
import jpcap.NetworkInterface;

public class PacCap
{
	public static Preferences tercihler;
	
	public static javax.swing.JFileChooser secici;

	private static ArrayList<Cerceve> cerceveler=new ArrayList<Cerceve>();

	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		secici=new javax.swing.JFileChooser();
		try{
			Class.forName("jpcap.JpcapCaptor");
			NetworkInterface[] devices=jpcap.JpcapCaptor.getDeviceList();
			if(devices.length==0){
				JOptionPane.showMessageDialog(null,"Network arayüzü bulunamadı.\nAdmin olmanız gerek/su paketleri yakalayabiilmeniz için.",
						"Warning",JOptionPane.WARNING_MESSAGE);
			}
		}catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null,"JpCap bulunamadı, Lütfen Jpcap'i yükleyiniz..",
					"Error",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}catch(UnsatisfiedLinkError e){
			JOptionPane.showMessageDialog(null,"JpCap bulunamadı ve/veya libpcap/WinPcap.\n Lütfen Jpcap ve libpcap/WinPcap yükleyiniz.",
					"Error",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		
		tercihler=Preferences.userNodeForPackage(PacCap.class);
		
		JPaketAnalizciYukleyici.loadDefaultAnalyzer();
		IstatistikAliciYukleyici.istatistikAliciYukle();
		
		openNewWindow();
	}
	
	public static void nitelikleriKaydet(){
		try{
			tercihler.flush();//flush() veri akış kanalındaki tüm veriyi gönderir (ve bufferi yeni veri için boşaltır).
		} catch (BackingStoreException e) {
			JOptionPane.showMessageDialog(null,"Tercihler kaydedilmedi.",
					"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void openNewWindow(){
		Yakalayici yakalayici=new Yakalayici();
		cerceveler.add(Cerceve.openNewWindow(yakalayici));
	}
	
	public static void closeWindow(Cerceve cerceve){
		cerceve.yakalayici.yakalamayiDurdur();
		cerceve.yakalayici.kaydedilmediyseKaydet();
		cerceve.yakalayici.tumPencereleriKapat();
		cerceveler.remove(cerceve);
		cerceve.dispose();
		if(cerceveler.isEmpty()){
			nitelikleriKaydet();
			System.exit(0);
		}
	}
	
	protected void finalize() throws Throwable{
		nitelikleriKaydet();
	}
}
