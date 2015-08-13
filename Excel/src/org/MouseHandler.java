package org;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class MouseHandler extends MouseAdapter implements TextListener
{
	Cell additionalCell;
	int xTxtPos;
	int yTxtPos;
	MainFrame frm;
	Cell objCell=null;
	int data;
	boolean flag;
	@Override
	public void textValueChanged(TextEvent e)
	{
		if(!frm.txtDisplay.getText().equals(""))
		{
			data=Integer.parseInt(frm.txtDisplay.getText());
			//System.out.println(data+" "+xTxtPos+" "+yTxtPos);
			if(additionalCell!=null)
			{
				additionalCell.data=data;
				additionalCell=null;
				return;
			}				
			else
				objCell=new Cell(data,yTxtPos,xTxtPos);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		int cellData=0;
			
		int xPos=e.getX();
		int yPos=e.getY();
		frm=(MainFrame)e.getSource();
		 xTxtPos=(xPos/60)*60;
		 yTxtPos=(yPos/40)*40;
		 Cell travCell=frm.objLinkedList.getFirst();
		 
		 for(int iTmp=0;iTmp<frm.objLinkedList.getMaxCount();iTmp++)
			{
				if(travCell.colNo==xTxtPos && travCell.rowNo==yTxtPos)
				{
					cellData=travCell.data;
					additionalCell=travCell;
				}
				else
				{
					
				}
				travCell=frm.objLinkedList.getNext();	
			}
		 if(cellData!=0)
		 {
			 frm.txtDisplay.setText(String.valueOf(cellData));
			 flag=true;
		 }
		 else
		 {
			 frm.txtDisplay.setText("");
			 flag=false;
		 }
			
		 
		if(objCell!=null)
		 {			
			frm.objLinkedList.add(objCell);	
			objCell=null;
			
		 }
		 frm.repaint();
		
		frm.txtDisplay.setBounds(xTxtPos,yTxtPos,60,40);
		
	}
	

}
