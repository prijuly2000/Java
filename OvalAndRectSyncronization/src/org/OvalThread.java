package org;

import java.awt.Color;
import java.awt.Graphics;

public class OvalThread implements Runnable
{
	MainFrame frm;
	
	

	public OvalThread(MainFrame frm)
	{
		super();
		this.frm = frm;
	}



	@Override
	public void run()
	{
		Graphics grp=frm.getGraphics();
		int xPos=300;
		int yPos=450;
		
		grp.drawOval(xPos, yPos, 60, 20);
		grp.setXORMode(Color.white);
		
		
		try
		{
			synchronized (frm.signal)
			{
				frm.signal.wait();
				
			}
			while(true)
			{
				grp.drawOval(xPos, yPos, 60, 20);
				yPos-=1;
				grp.drawOval(xPos, yPos, 60, 20);
				Thread.sleep(50);
			}
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
