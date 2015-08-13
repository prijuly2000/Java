package org;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

public class MouseHandler implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		OrangeButton btn=(OrangeButton)e.getSource();
		btn.setBackground(Color.yellow);
		

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		OrangeButton btn=(OrangeButton)e.getSource();
		btn.setBackground(Color.orange);
		
		Iterator<OrangeListener>iter=btn.receivers.iterator();
		
		while(iter.hasNext())
		{
			OrangeListener ol=iter.next();
			ol.orangeClicked(new OrangeEvent(btn, "Hello world"));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}
