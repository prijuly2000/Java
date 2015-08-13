package org;

import java.awt.Color;
import java.awt.Graphics;

public class RectThread implements Runnable
{

	MainFrame frm;
	public RectThread(MainFrame frm)
	{
		this.frm=frm;
	}
	@Override
	public void run()
	{
		int xPos=0;
		int yPos=70;
		Graphics grp=frm.getGraphics();
		grp.setXORMode(Color.white);
		
		try
		{
			
			grp.setColor(Color.blue);
			
			while(true)
			{
				grp.fillArc(xPos,yPos,50,50,0,360);
				
				/*xPos+=10;*/
				yPos+=5;
				synchronized (frm.signal)
				{
					if(yPos>=430)
						frm.signal.notify();
					
				}
				grp.fillArc(xPos,yPos,50,50,0,360);
				Thread.sleep(1000);
				if(yPos+60>500)
					break;
			}
			
		
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
