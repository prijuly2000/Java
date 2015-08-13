package org;

import java.awt.Color;
import java.awt.Graphics;

public class Consumer implements Runnable
{
	MainFrame frm;
	
	public Consumer(MainFrame frm)
	{		
		this.frm=frm;
	}



	@Override
	public void run()
	{
		int xPos[]=frm.xPos;
		int yPos[]=frm.yPos;
		int index=0;
		
		Graphics grp=frm.getGraphics();
		grp.setXORMode(Color.white);
		try
		{
			while(true)
			{
				Thread.sleep(100);
				grp.drawPolyline(xPos, yPos, 150);
				
				
				
			}
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	

}
