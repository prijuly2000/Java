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
			while(true)
			{
				grp.fillArc(xPos,yPos,50,50,0,360);
				
				xPos+=10;
				yPos+=5;
				grp.fillArc(xPos,yPos,50,50,0,360);
				Thread.sleep(50);
				if(xPos+60>500)
					break;
			}
			while(true)
			{
				grp.fillArc(xPos,yPos,50,50,0,360);
				xPos-=10;
				yPos+=10;
				grp.fillArc(xPos,yPos,50,50,0,360);
				Thread.sleep(50);
				if(yPos+60>500)
					break;
			}
			while(true)
			{
				grp.fillArc(xPos,yPos,50,50,0,360);
				xPos-=12;
				yPos-=11;
				grp.fillArc(xPos,yPos,50,50,0,360);
				Thread.sleep(50);
				if(yPos<0 || xPos-10<0)
					break;
			}
			while(true)
			{
				grp.fillArc(xPos,yPos,50,50,0,360);
				xPos+=12;
				yPos-=10;
				grp.fillArc(xPos,yPos,50,50,0,360);
				Thread.sleep(50);
				if(yPos-40<0)
					break;
			}
		}
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
