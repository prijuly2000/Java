package org;

import java.applet.Applet;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuDisplay extends JApplet implements ActionListener
{
	JMenuBar mbr=new JMenuBar();
	
	JMenu file=new JMenu("File");
	JMenu edit=new JMenu("Edit");
	JMenu help=new JMenu("Help");
	
	JMenuItem newMenu=new JMenuItem("New");
	JMenuItem open=new JMenuItem("Open");
	JMenuItem close=new JMenuItem("Close");
	
	JMenuItem undo=new JMenuItem("Undo");
	JMenuItem redo=new JMenuItem("Redo");
	JMenuItem copy=new JMenuItem("Copy");
	
	JMenuItem index=new JMenuItem("Index");
	JMenuItem aboutUs=new JMenuItem("AboutUs");
	
	
	public void init()
	{
		
		setJMenuBar(mbr);
		
		
		setLayout(null);
		
		mbr.add(file);
		mbr.add(edit);
		mbr.add(help);
		
		file.add(newMenu);
		file.add(open);
		file.add(close);
		
		edit.add(undo);
		edit.add(redo);
		edit.add(copy);
		
		help.add(index);
		help.add(aboutUs);
		
		
		newMenu.addActionListener(this);
		open.addActionListener(this);
		close.addActionListener(this);
		undo.addActionListener(this);
		redo.addActionListener(this);
		copy.addActionListener(this);
		index.addActionListener(this);
		aboutUs.addActionListener(this);
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String action=e.getActionCommand();
		
		switch(action)
		{
		case "NewMenu":
			JOptionPane.showConfirmDialog(null," New Clicked");
			break;
		
		case "Open":
			JOptionPane.showConfirmDialog(null," open Clicked");
			break;
			
		case "Close":
			JOptionPane.showConfirmDialog(null," Close Clicked");
			break;
		case "Undo":
			JOptionPane.showConfirmDialog(null," Undo Clicked");
			break;
		case "Redo":
			JOptionPane.showConfirmDialog(null," Redo Clicked");
			break;
		case "Copy":
			JOptionPane.showConfirmDialog(null," Copy Clicked");
			break;
		
		case "Index":
			JOptionPane.showConfirmDialog(null," Index Clicked");
			break;
			
		case "AboutUs":
			JOptionPane.showConfirmDialog(null," AboutUs Clicked");
			break;
			
		}
	}
	

}
