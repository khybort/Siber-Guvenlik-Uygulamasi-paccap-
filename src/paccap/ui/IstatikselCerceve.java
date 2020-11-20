package paccap.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jpcap.packet.*;
import javax.swing.*;

public abstract class IstatikselCerceve extends JFrame
{
	IstatikselCerceve(String title){
		super(title);
		istatikselCerceveGuncelleyici.start();
		addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosed(java.awt.event.WindowEvent evt){
				//hide();
				setVisible(false);
			}
		});
	}
	abstract void fireUpdate();
	public abstract void addPacket(Packet p);
	public abstract void clear();

	public void guncellemeyeBasla(){
		istatikselCerceveGuncelleyici.setRepeats(true);
		istatikselCerceveGuncelleyici.start();
	}
	
	public void guncellemeyiDurdur(){
		istatikselCerceveGuncelleyici.stop();
		istatikselCerceveGuncelleyici.setRepeats(false);
		istatikselCerceveGuncelleyici.start();
	}

	javax.swing.Timer istatikselCerceveGuncelleyici=new javax.swing.Timer(500,new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			fireUpdate();
			repaint();
		}
	});

}
