package org;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BarChart extends Frame
{
	MainFrame frm;
	public BarChart(MainFrame frm)
	{
		this.frm=frm;
		setBounds(0, 0, 500, 500);
		setLayout(null);
		setVisible(true);

		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
			
			
		});
	}
	
	public void paint(Graphics grp)
	{
		int []sumAll=frm.sumAll;
		int xPos=50;
		int yPos=400;
		for(int index=0;index<10;index++)
		{
			yPos=yPos-sumAll[index];
			grp.fillRect(xPos, yPos, 20, sumAll[index]);
			xPos+=30;
			yPos=400;
		}
		
	}
}
