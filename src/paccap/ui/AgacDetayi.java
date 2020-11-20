package paccap.ui;
import jpcap.packet.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;
import java.util.List;

import paccap.JPaketAnalizciYukleyici;
import paccap.analizci.JPaketAnalizci;

class AgacDetayi extends JComponent
{
	JTree agac;//Dallanma sağlar
	DefaultMutableTreeNode kok=new DefaultMutableTreeNode();//Varsayılan değişebilir ağaç düğümü
	List<JPaketAnalizci> analizciler=JPaketAnalizciYukleyici.getAnalyzers();
	
	AgacDetayi(){
		agac=new JTree(kok);
		agac.setRootVisible(false);
		JScrollPane treeView=new JScrollPane(agac);
		
		setLayout(new BorderLayout());
		add(treeView,BorderLayout.CENTER);
	}
	
	void analyzePacket(Packet packet){
		boolean[] isExpanded=new boolean[kok.getChildCount()];
		for(int i=0;i<kok.getChildCount();i++)
			isExpanded[i]=agac.isExpanded(new TreePath(((DefaultMutableTreeNode)kok.getChildAt(i)).getPath()));
		
		kok.removeAllChildren();
		
		DefaultMutableTreeNode dugum;
		for(JPaketAnalizci analizci:analizciler){
			if(analizci.isAnalyzable(packet)){
				analizci.analyze(packet);
				dugum=new DefaultMutableTreeNode(analizci.getProtocolName());
				kok.add(dugum);
				String[] names=analizci.getValueNames();
				Object[] values=analizci.getValues();
				
				for(int j=0;j<names.length;j++){
					if(values[j] instanceof Vector){
						dugumlerEkle(dugum,names[j],(Vector)values[j]);
					}else if(values[j]!=null){
						dugumEkle(dugum,names[j]+": "+values[j]);
					}else{
						dugumEkle(dugum,names[j]+": Kullanılabilir değil");
					}
				}
			}
		}
		((DefaultTreeModel)agac.getModel()).nodeStructureChanged(kok);
		
		for(int i=0;i<Math.min(kok.getChildCount(),isExpanded.length);i++)
			if(isExpanded[i]) agac.expandPath(new TreePath(((DefaultMutableTreeNode)kok.getChildAt(i)).getPath()));
	}

	private void dugumEkle(DefaultMutableTreeNode dugum,String str){
		dugum.add(new DefaultMutableTreeNode(str));
	}
	
	private void dugumlerEkle(DefaultMutableTreeNode dugum,String str,Vector v){//Vektor tek bir threadin(Diğer threadler bekliyor) çalıştığı liste tipi
		DefaultMutableTreeNode altDugum=new DefaultMutableTreeNode(str);
		
		for(int i=0;i<v.size();i++)
			altDugum.add(new DefaultMutableTreeNode(v.elementAt(i)));
		
		dugum.add(altDugum);
	}
	
	private void setUserObject(TreeNode node,Object obj){
		((DefaultMutableTreeNode)node).setUserObject(obj);
	}
}
