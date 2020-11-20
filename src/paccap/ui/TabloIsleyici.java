package paccap.ui;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

class TabloIsleyici extends JLabel implements TableCellRenderer
{
	protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1); 

	public TabloIsleyici(){
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable tablo,
			Object deger,boolean secildi,boolean odaklandi,int satir,int sutun){
		
		if(secildi){
			super.setForeground(tablo.getSelectionForeground());
			super.setBackground(tablo.getSelectionBackground());
		}else{
			super.setForeground(tablo.getForeground());
			super.setBackground(tablo.getBackground());
		}
		
		setFont(tablo.getFont());

		if(odaklandi){
	    setBorder( UIManager.getBorder("Table.focusCellHighlightBorder") );
		}else{
			setBorder(noFocusBorder);
		}
		
		if(deger==null){
			setText("Not Available ");
			return this;
		}
		
		setText(deger.toString());
		
		if(deger.getClass().equals(Integer.class) || deger.getClass().equals(Long.class)){
			setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		// Ekranı boyamaktan kaçınmak için optimizasyon başlangıcı
		Color geri = getBackground();
		boolean renkEslesmesi = (geri != null) && ( geri.equals(tablo.getBackground()) ) && tablo.isOpaque();
		setOpaque(!renkEslesmesi);
		//Ekranı boyamaktan kaçınmak için optimizasyon bitişi

		return this;
	}
}