package org;

import java.awt.Graphics;

public class Producer implements Runnable
{
	
	MainFrame frm;
	
	int amplitude;
	int theta;
	double pi;
	
	public Producer(MainFrame frm)
	{
		this.frm=frm;
		
		amplitude=Integer.parseInt(frm.arrTextFields[MainFrame.TXTAMP].getText());
		theta=1;
		pi=3.24;
		
		
	}


	@Override
	public void run()
	{
		int xPos[]=frm.xPos;
		int yPos[]=frm.yPos;
		int index=0;
		
		yPos[index]=200;
		
		int incre=(int)500/150;
		try
		{
			while(true)
			{
				Thread.sleep(20);
				xPos[index+1]=xPos[index]+incre;
				System.out.println(index+"");
				yPos[index]=(int)(amplitude*(Math.sin(theta*pi/180)))+200;			
				theta+=2;
				index++;
				if(index==150)
					index=0;
			}
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
