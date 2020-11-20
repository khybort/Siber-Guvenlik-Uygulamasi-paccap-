package paccap.ui;
import jpcap.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class YakalamaPenceresi extends JDialog implements ActionListener
{
	static JpcapCaptor jpcap=null;
	
	NetworkInterface[] cihazlar;
	
	JComboBox adapterComboBox;
	JTextField filtreAlani,yakalamaUzunluguAlani;
	JRadioButton wholeCheck,headCheck,userCheck;
	JCheckBox promiscCheck;
	
	public YakalamaPenceresi(JFrame parent){
		super(parent,"Cihaz ve seçenekleri seçin",true);
		
		cihazlar=JpcapCaptor.getDeviceList();
		if(cihazlar==null){
			JOptionPane.showMessageDialog(parent,"Cihaz bulunamadı.");
			dispose();
			return;
		}else{
			String[] names=new String[cihazlar.length];
			for(int i=0;i<names.length;i++)
				names[i]=(cihazlar[i].description==null?cihazlar[i].name:cihazlar[i].description);
			adapterComboBox=new JComboBox(names);
		}
		JPanel adapterPane=new JPanel();
		adapterPane.add(adapterComboBox);
		adapterPane.setBorder(BorderFactory.createTitledBorder("Yakalama cihazını seçin"));
		adapterPane.setAlignmentX(Component.LEFT_ALIGNMENT);

		promiscCheck=new JCheckBox("Karışık moda sokmak");
		promiscCheck.setSelected(true);
		promiscCheck.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		filtreAlani=new JTextField(20);
		//filterField.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
		JPanel filtrePaneli=new JPanel();
		filtrePaneli.add(new JLabel("Filtre"));
		filtrePaneli.add(filtreAlani);
		filtrePaneli.setBorder(BorderFactory.createTitledBorder("Yakalama Filtresi"));
		filtrePaneli.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		JPanel yakalamaUzunluguPaneli=new JPanel();
		yakalamaUzunluguPaneli.setLayout(new BoxLayout(yakalamaUzunluguPaneli,BoxLayout.Y_AXIS));
		yakalamaUzunluguAlani=new JTextField("1514");
		yakalamaUzunluguAlani.setEnabled(false);
		yakalamaUzunluguAlani.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
		wholeCheck=new JRadioButton("Bütün paket");
		wholeCheck.setSelected(true);
		wholeCheck.setActionCommand("Whole");
		wholeCheck.addActionListener(this);
		headCheck=new JRadioButton("Sadece Başlık");
		headCheck.setActionCommand("Head");
		headCheck.addActionListener(this);
		userCheck=new JRadioButton("Diğer");
		userCheck.setActionCommand("Other");
		userCheck.addActionListener(this);
		ButtonGroup group=new ButtonGroup();
		group.add(wholeCheck);
		group.add(headCheck);
		group.add(userCheck);
		yakalamaUzunluguPaneli.add(yakalamaUzunluguAlani);
		yakalamaUzunluguPaneli.add(wholeCheck);
		yakalamaUzunluguPaneli.add(headCheck);
		yakalamaUzunluguPaneli.add(userCheck);
		yakalamaUzunluguPaneli.setBorder(BorderFactory.createTitledBorder("Maksimum paket uzunluğu"));
		yakalamaUzunluguPaneli.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JPanel butonPaneli=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton okButton=new JButton("Tamam");
		okButton.setActionCommand("OK");
		okButton.addActionListener(this);
		JButton cancelButton=new JButton("İptal");
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(this);
		butonPaneli.add(okButton);
		butonPaneli.add(cancelButton);
		butonPaneli.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JPanel batiPaneli=new JPanel(),doguPaneli=new JPanel();
		batiPaneli.setLayout(new BoxLayout(batiPaneli,BoxLayout.Y_AXIS));
		batiPaneli.add(Box.createRigidArea(new Dimension(5,5)));
		batiPaneli.add(adapterPane);
		batiPaneli.add(Box.createRigidArea(new Dimension(0,10)));
		batiPaneli.add(promiscCheck);
		batiPaneli.add(Box.createRigidArea(new Dimension(0,10)));
		batiPaneli.add(filtrePaneli);
		batiPaneli.add(Box.createVerticalGlue());
		doguPaneli.add(Box.createRigidArea(new Dimension(5,5)));
		doguPaneli.setLayout(new BoxLayout(doguPaneli,BoxLayout.Y_AXIS));
		doguPaneli.add(yakalamaUzunluguPaneli);
		doguPaneli.add(Box.createRigidArea(new Dimension(5,30)));
		doguPaneli.add(butonPaneli);
		doguPaneli.add(Box.createRigidArea(new Dimension(5,5)));
		
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
		getContentPane().add(Box.createRigidArea(new Dimension(10,10)));
		getContentPane().add(batiPaneli);
		getContentPane().add(Box.createRigidArea(new Dimension(10,10)));
		getContentPane().add(doguPaneli);
		getContentPane().add(Box.createRigidArea(new Dimension(10,10)));
		pack();
		
		setLocation(parent.getLocation().x+100,parent.getLocation().y+100);
	}
	
	public void actionPerformed(ActionEvent evt){
		String cmd=evt.getActionCommand();
		
		if(cmd.equals("Whole")){
			yakalamaUzunluguAlani.setText("1514");
			yakalamaUzunluguAlani.setEnabled(false);
		}else if(cmd.equals("Head")){
			yakalamaUzunluguAlani.setText("68");
			yakalamaUzunluguAlani.setEnabled(false);
		}else if(cmd.equals("Other")){
			yakalamaUzunluguAlani.setText("");
			yakalamaUzunluguAlani.setEnabled(true);
			yakalamaUzunluguAlani.requestFocus();
		}else if(cmd.equals("OK")){
			try{
				int yakalamauzunlugu=Integer.parseInt(yakalamaUzunluguAlani.getText());
				if(yakalamauzunlugu<68 || yakalamauzunlugu>1514){
					JOptionPane.showMessageDialog(null,"Yakalama uzunluğu 68 ile 1514 arasında olmak zorundadır.");
					return;
				}
				
				jpcap=JpcapCaptor.openDevice(cihazlar[adapterComboBox.getSelectedIndex()],yakalamauzunlugu,
						promiscCheck.isSelected(),50);
				
				if(filtreAlani.getText()!=null && filtreAlani.getText().length()>0){
					jpcap.setFilter(filtreAlani.getText(),true);
				}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null,"Lütfen yakalama uzunluğunda geçerli tam sayı değerini giriniz.");
			}catch(java.io.IOException e){
				JOptionPane.showMessageDialog(null,e.toString());
				jpcap=null;
			}finally{
				dispose();
			}
		}else if(cmd.equals("Cancel")){
			dispose();
		}
	}
	
	public static JpcapCaptor getJpcap(JFrame parent){
		new YakalamaPenceresi(parent).setVisible(true);
		return jpcap;
	}
}
