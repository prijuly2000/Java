package org;

import java.applet.Applet;
import java.awt.Button;

public class AppletDemo extends Applet
{

	@Override
	public void init()
	{
		Button btn=new Button("Start");
		btn.setBounds(10, 50, 70, 30);
		btn.addActionListener(new ButtonHandler());
		add(btn);
	}
	
}
