package paccap.ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import paccap.Yakalayici;
import paccap.IstatistikAliciYukleyici;
import paccap.PacCap;
import paccap.stat.IstatistikAlici;

public class Cerceve extends JFrame implements ActionListener
{
	public Yakalayici yakalayici;
	
	JLabel durumCubugu;
	JMenuItem acmaMenusu,kaydetmeMenusu,yakalamaMenusu,durdurmaMenusu;
	JMenu istatistikMenusu;
	JButton acmaButonu,kaydetmeButonu,yakalamaButonu,durdurmaButonu;
	
	public TabloPaneli tabloPaneli;

	public static Cerceve openNewWindow(Yakalayici yakalayici){
		Cerceve cerceve=new Cerceve(yakalayici);
		cerceve.setVisible(true);
		
		return cerceve;
	}

	public Cerceve(Yakalayici yakalayici){
		this.yakalayici=yakalayici;
		tabloPaneli=new TabloPaneli(yakalayici);
		yakalayici.setFrame(this);
		
		setTitle("PacCap Ana Pencere");

		// Create Menu
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		//System Menu
		JMenu menu=new JMenu("Sistem");
		menuBar.add(menu);
		JMenuItem item=new JMenuItem("Yeni Pencere");
		item.setActionCommand("NewWin");
		item.addActionListener(this);
		menu.add(item);
		item=new JMenuItem("Çıkış");
		item.setActionCommand("Exit");
		item.addActionListener(this);
		menu.add(item);
		
		//File Menu
		menu=new JMenu("Dosya");
		menuBar.add(menu);
		acmaMenusu=new JMenuItem("Aç");
		acmaMenusu.setIcon(getImageIcon("/image/ac (2).png"));
		acmaMenusu.setActionCommand("Open");
		acmaMenusu.addActionListener(this);
		menu.add(acmaMenusu);
		kaydetmeMenusu=new JMenuItem("Kaydet");
		kaydetmeMenusu.setIcon(getImageIcon("/image/kaydet (2).png"));
		kaydetmeMenusu.setActionCommand("Save");
		kaydetmeMenusu.addActionListener(this);
		kaydetmeMenusu.setEnabled(false);
		menu.add(kaydetmeMenusu);

		//Capture Menu
		menu=new JMenu("Yakala");
		menuBar.add(menu);
		yakalamaMenusu=new JMenuItem("Başla");
		yakalamaMenusu.setIcon(getImageIcon("/image/yakalama (2).png"));
		yakalamaMenusu.setActionCommand("Start");
		yakalamaMenusu.addActionListener(this);
		menu.add(yakalamaMenusu);
                
		durdurmaMenusu=new JMenuItem("Dur");
		durdurmaMenusu.setIcon(getImageIcon("/image/durdur (2).png"));
		durdurmaMenusu.setActionCommand("Stop");
		durdurmaMenusu.addActionListener(this);
		durdurmaMenusu.setEnabled(false);
		menu.add(durdurmaMenusu);
		
		//Stat Menu
		istatistikMenusu=new JMenu("İstatiksel");
		menuBar.add(istatistikMenusu);
		menu=new JMenu("Kümülatif");
		istatistikMenusu.add(menu);
		java.util.List<IstatistikAlici> stakers=IstatistikAliciYukleyici.istatistikAlicilariGetir();
		for(int i=0;i<stakers.size();i++){
			item=new JMenuItem(stakers.get(i).getName());
			item.setActionCommand("CUMSTAT"+i);
			item.addActionListener(this);
			menu.add(item);
		}
		menu=new JMenu("Sürekli");
		istatistikMenusu.add(menu);
		for(int i=0;i<stakers.size();i++){
			item=new JMenuItem(stakers.get(i).getName());
			item.setActionCommand("CONSTAT"+i);
			item.addActionListener(this);
			menu.add(item);
		}

		//View menu
		menu=new JMenu("Görünüm");
		menuBar.add(menu);
		tabloPaneli.tabloGorunumMenusunuYerlestir(menu);
		
		//L&F Menu
		/*menu=new JMenu("Look&Feel");
		menuBar.add(menu);
		item=createLaFMenuItem("Metal","javax.swing.plaf.metal.MetalLookAndFeel");
		menu.add(item);
		item.setSelected(true);
		menu.add(createLaFMenuItem("Windows","com.sun.java.swing.plaf.windows.WindowsLookAndFeel"));
		menu.add(createLaFMenuItem("Motif","com.sun.java.swing.plaf.motif.MotifLookAndFeel"));
		menu.add(createLaFMenuItem("Mac","com.sun.java.swing.plaf.mac.MacLookAndFeel"));*/
		
		
		//Create Toolbar
		JToolBar aracCubugu=new JToolBar();
		aracCubugu.setFloatable(false);
		acmaButonu=new JButton(getImageIcon("/image/ac.png"));
              //  acmaButonu.setPreferredSize(new Dimension(10,10));
		acmaButonu.setActionCommand("Open");
		acmaButonu.addActionListener(this);
		aracCubugu.add(acmaButonu);
		kaydetmeButonu=new JButton(getImageIcon("/image/kaydet.png"));
                //kaydetmeButonu.setPreferredSize(new Dimension(10,10));
		kaydetmeButonu.setActionCommand("Save");
		kaydetmeButonu.addActionListener(this);
		kaydetmeButonu.setEnabled(false);
		aracCubugu.add(kaydetmeButonu);
		aracCubugu.addSeparator();
		yakalamaButonu=new JButton(getImageIcon("/image/yakalama.png"));
                //yakalamaButonu.setPreferredSize(new Dimension(10,10));
		yakalamaButonu.setActionCommand("Start");
		yakalamaButonu.addActionListener(this);
		aracCubugu.add(yakalamaButonu);
		durdurmaButonu=new JButton(getImageIcon("/image/durdur.png"));
                //durdurmaButonu.setPreferredSize(new Dimension(400,400));
		durdurmaButonu.setActionCommand("Stop");
		durdurmaButonu.addActionListener(this);
		durdurmaButonu.setEnabled(false);
		aracCubugu.add(durdurmaButonu);
		
		durumCubugu=new JLabel("PacCap başladı.");
		
		getContentPane().setLayout(new BorderLayout());
		//getContentPane().add(desktop,BorderLayout.CENTER);
		getContentPane().add(durumCubugu,BorderLayout.SOUTH);
		getContentPane().add(tabloPaneli,BorderLayout.CENTER);
		getContentPane().add(aracCubugu,BorderLayout.NORTH);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt){
				nitelikleriKaydet();
				PacCap.closeWindow((Cerceve)evt.getSource());
			}
		});
		
		nitelikleriYukle();
		//pack();
	}
	//Aksiyon komuduna göre yönledirme
	public void actionPerformed(ActionEvent evt){
		String cmd=evt.getActionCommand();
		
		if(cmd.equals("Open")){
			yakalayici.dosyadanPaketleriYukle();
		}else if(cmd.equals("Save")){
			yakalayici.dosyayaKaydet();
		}else if(cmd.equals("NewWin")){
			PacCap.openNewWindow();
		}else if(cmd.equals("Exit")){
			nitelikleriKaydet();
			System.exit(0);
		}else if(cmd.equals("Start")){
			yakalayici.cihazdanPaketleriYakala();
		}else if(cmd.equals("Stop")){
			yakalayici.yakalamayiDurdur();
		}else if(cmd.startsWith("CUMSTAT")){
			int index=Integer.parseInt(cmd.substring(7));
			yakalayici.kumulatifIstatistikCercevesiEkle(IstatistikAliciYukleyici.istatistikAliciyiGetirAt(index));
		}else if(cmd.startsWith("CONSTAT")){
			int index=Integer.parseInt(cmd.substring(7));
			yakalayici.birikimliIstatistikCercevesiEkle(IstatistikAliciYukleyici.istatistikAliciyiGetirAt(index));
		/*}else if(cmd.startsWith("LaF")){
			try{
				UIManager.setLookAndFeel(cmd.substring(3));
				SwingUtilities.updateComponentTreeUI(this);
				SwingUtilities.updateComponentTreeUI(JpcapDumper.chooser);
			}catch(Exception e){}*/
		}
	}
	
	public void temizle(){
		tabloPaneli.temizle();
	}
	/*void initInternalFrames(){
		packets.removeAllElements();
		totalPacketCount=0;
		tableFrame.clear();

		if(sframes!=null)
			for(int i=0;i<sframes.length;i++)
				if(sframes[i]!=null) sframes[i].clear();
	}*/

	public void guncellemeyeBasla(){
		cerceveGuncelleyicisi.setRepeats(true);
		cerceveGuncelleyicisi.start();
	}
	
	public void guncellemeyiDurdur(){
		cerceveGuncelleyicisi.stop();
		cerceveGuncelleyicisi.setRepeats(false);
		cerceveGuncelleyicisi.start();
	}

	javax.swing.Timer cerceveGuncelleyicisi=new javax.swing.Timer(500,new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			tabloPaneli.fireTableChanged();
			durumCubugu.setText(yakalayici.getPackets().size()+"paket yakalandı.");

			repaint();// çerçeve değiştikçe günceller appleti
		}
	});

	void nitelikleriYukle(){
		setSize(Integer.parseInt(PacCap.tercihler.get("WinWidth","640")),
		        Integer.parseInt(PacCap.tercihler.get("WinHeight","480")));
		setLocation(Integer.parseInt(PacCap.tercihler.get("WinX","0")),
			Integer.parseInt(PacCap.tercihler.get("WinY","0")));
	}
	
	void nitelikleriKaydet(){
		//JpcapDumper.JDProperty.setProperty("WinWidth",String.valueOf(getBounds().width));
		//JpcapDumper.JDProperty.setProperty("WinHeight",String.valueOf(getBounds().height));
		PacCap.tercihler.put("WinWidth",String.valueOf(getBounds().width));
		PacCap.tercihler.put("WinHeight",String.valueOf(getBounds().height));
		PacCap.tercihler.put("WinX",String.valueOf(getBounds().x));
		PacCap.tercihler.put("WinY",String.valueOf(getBounds().y));
		
		tabloPaneli.nitelikleriKaydet();
		
		PacCap.nitelikleriKaydet();
	}
	
	public void yakalamaDevrede(){
		acmaMenusu.setEnabled(true);
		acmaButonu.setEnabled(true);
		kaydetmeMenusu.setEnabled(true);
		kaydetmeButonu.setEnabled(true);
		yakalamaMenusu.setEnabled(true);
		yakalamaButonu.setEnabled(true);
		durdurmaMenusu.setEnabled(false);
		durdurmaButonu.setEnabled(false);
	}
	
	public void yakalamaDevredisi(){
		acmaMenusu.setEnabled(false);
		acmaButonu.setEnabled(false);
		yakalamaMenusu.setEnabled(false);
		yakalamaButonu.setEnabled(false);
		kaydetmeMenusu.setEnabled(true);
		kaydetmeButonu.setEnabled(true);
		durdurmaMenusu.setEnabled(true);
		durdurmaButonu.setEnabled(true);
	}
	
	private ImageIcon getImageIcon(String path){
		return new ImageIcon(this.getClass().getResource(path));
	}
	
	/*ButtonGroup lafGroup=new ButtonGroup();
	private JRadioButtonMenuItem createLaFMenuItem(String name,String lafName){
		JRadioButtonMenuItem item=new JRadioButtonMenuItem(name);
		item.setActionCommand("LaF"+lafName);
		item.addActionListener(this);
		lafGroup.add(item);
		
		try {
			Class lnfClass = Class.forName(lafName);
			LookAndFeel newLAF = (LookAndFeel)(lnfClass.newInstance());
			if(!newLAF.isSupportedLookAndFeel()) item.setEnabled(false);
		} catch(Exception e) {
			item.setEnabled(false);
		}
		
		return item;
	}*/
}
