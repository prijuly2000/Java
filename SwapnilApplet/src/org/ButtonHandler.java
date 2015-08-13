package org;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Graphics grp=((Button)e.getSource()).getGraphics();
		grp.drawString("Welcome To Pritesh Applet",50,50);
	}
	
}
