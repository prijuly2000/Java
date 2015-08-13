package org;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PieChart extends Frame
{
	MainFrame frm;
	public PieChart(MainFrame frm)
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
		int index;
		float angles[]=new float[10];
		int total=0;
		int []sumAll=frm.sumAll;
		for(index=0;index<10;index++)
		{
			total+=sumAll[index];
		}
		System.out.println(total+"");
		int start=0;
		float each=(float)360/total;
		System.out.println("each:"+each+"");
		for(index=0;index<10;index++)
		{
			angles[index]=sumAll[index]*each;
		}
		int red=255;
		int green=0;
		int blue=125;
		for(index=0;index<10;index++)
		{
			
			grp.fillArc(100, 100, 200, 200, start, (int)angles[index]);
			start+=angles[index];
			Color color=new Color(red,green,blue);
			grp.setColor(color);
			red-=5;
			green+=5;
			blue+=5;
			System.out.println(String.valueOf(index));
		}
		
	
	}
	
}
