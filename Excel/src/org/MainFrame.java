package org;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import edu.utility.Linklist;

public class MainFrame extends Frame
{
	TextField txtDisplay=new TextField();
	Linklist<Cell> objLinkedList=new Linklist<>();
	int sumAll[]={0,0,0,0,0,0,0,0,0,0};
	Cell objCell;
	public MainFrame()
	{
		setBounds(0, 0, 600, 500);
		setLayout(null);
		
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
			
			
		});
		add(txtDisplay);
		MouseHandler handler=new MouseHandler();
		addMouseListener(handler);
		txtDisplay.addTextListener(handler);
		
		ButtonHandler btnHandler=new ButtonHandler();
		Button barButton=new Button("Bar Graph");
		barButton.setBounds(100,430, 100, 30);
		barButton.addActionListener(btnHandler);
		add(barButton);
		
		Button pieButton=new Button("Pie Chart");
		pieButton.setBounds(300,430, 100, 30);
		pieButton.addActionListener(btnHandler);
		add(pieButton);
		
		setVisible(true);
	}
	
	public void paint(Graphics grp)
	{
		int xHPos1=0;
		int yHPos1=40;
		int xHPos2=600;
		int yHPos2=40;
		int iTmp;
		int xVPos1=0;
		int yVPos1=40;
		int xVPos2=0;
		int yVPos2=400;
		for( iTmp=0;iTmp<10;iTmp++)
		{
			grp.drawLine(xHPos1, yHPos1,xHPos2 ,yHPos2);
			grp.drawLine(xVPos1, yVPos1,xVPos2 ,yVPos2);
			yHPos1+=40;
			yHPos2+=40;
			xVPos1+=60;
			xVPos2+=60;
		}
		objCell=objLinkedList.getFirst();
		
		for(int index=0;index<objLinkedList.getMaxCount();index++)
		{				
			grp.drawString(String.valueOf(objCell.data),objCell.colNo+20,objCell.rowNo+20);
			objCell=objLinkedList.getNext();
		}
		int sum=0;
		int x=0;
		int y=40;
		
		for(iTmp=0;iTmp<10;iTmp++)
		{
			objCell=objLinkedList.getFirst();
			for(int jTmp=0;jTmp<objLinkedList.getMaxCount();jTmp++)
			{
				if(objCell.colNo==x)
					sum+=objCell.data;
				y+=40;
				objCell=objLinkedList.getNext();
			}
			grp.drawString(String.valueOf(sum), x+20, 380);
			x+=60;
			sumAll[iTmp]=sum;
			sum=0;
			y=40;
			
		}
		
		
	}
	
}
