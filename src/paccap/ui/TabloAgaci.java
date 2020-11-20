package paccap.ui;
import jpcap.packet.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;
import java.util.List;

import paccap.JPaketAnalizciYukleyici;
import paccap.analizci.JPaketAnalizci;

class TabloAgaci extends JComponent
{
	JTree agac;
	DefaultMutableTreeNode kok=new DefaultMutableTreeNode();
	List<JPaketAnalizci> analizciler=JPaketAnalizciYukleyici.getAnalyzers();
	
	TabloAgaci(){
		agac=new JTree(kok);
		agac.setRootVisible(false);
		JScrollPane treeView=new JScrollPane(agac);
		
		setLayout(new BorderLayout());
		add(treeView,BorderLayout.CENTER);
	}
	
	void paketiAnalizEt(Packet paket){
		boolean[] isExpanded=new boolean[kok.getChildCount()];
		for(int i=0;i<kok.getChildCount();i++)
			isExpanded[i]=agac.isExpanded(new TreePath(((DefaultMutableTreeNode)kok.getChildAt(i)).getPath()));
		
		kok.removeAllChildren();
		
		DefaultMutableTreeNode dugum;
		for(JPaketAnalizci analizci:analizciler){
			if(analizci.isAnalyzable(paket)){
				analizci.analyze(paket);
				dugum=new DefaultMutableTreeNode(analizci.getProtocolName());
				kok.add(dugum);
				String[] adlar=analizci.getValueNames();
				Object[] degerler=analizci.getValues();
				if(adlar==null) continue;
				
				for(int j=0;j<adlar.length;j++){
					if(degerler[j] instanceof Vector){
						dugumleriEkle(dugum,adlar[j],(Vector)degerler[j]);
					}else if(degerler[j]!=null){
						dugumEkle(dugum,adlar[j]+": "+degerler[j]);
					}/*else{
						addNode(node,names[j]+": Geçerli değil");
					}*/
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
	
	private void dugumleriEkle(DefaultMutableTreeNode dugum,String str,Vector v){
		DefaultMutableTreeNode altDugum=new DefaultMutableTreeNode(str);
		
		for(int i=0;i<v.size();i++)
			altDugum.add(new DefaultMutableTreeNode(v.elementAt(i)));
		
		dugum.add(altDugum);
	}
	
	private void kullaniciNesnesiniYerlestir(TreeNode dugum,Object obj){
		((DefaultMutableTreeNode)dugum).setUserObject(obj);
	}
}
