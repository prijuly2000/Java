package excel;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter

{
	
	int xPos;
	int yPos;
	String cellValue;
	int colno=0;
	int rowno=0;
	public void mousePressed(MouseEvent me)
	{
		
		MainFrame frm=(MainFrame)me.getSource();
		cellValue=frm.txtPos.getText();
		Cell objCell=new Cell( xPos, yPos,cellValue);
		
		
		//Graphics grp=frm.getGraphics();
		
		
		
		
		//frm.objList.add(objCell);
		//objcell(cellValue, xPos, yPos);
		
		 colno=me.getX();
		 rowno=me.getY();
	
		
		colno=(colno/50)*50;
		rowno=(rowno/20)*20;
		
		frm.txtPos.setText("");
		//frm.txtPos.setBounds(xPos, yPos, 50, 20);
		
		
		
		frm.txtPos.setBounds(colno, rowno, 50, 20);
		frm.repaint();
		
		
		
	    
		
		
		
	}
	
}
