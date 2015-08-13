package org;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame
{
	Object signal=new Object();
	public MainFrame()
	{
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				
				super.windowClosing(e);
				dispose();
			}
		});
		ButtonHandler handler=new ButtonHandler();
		
		
		Button btnStart=new Button("Start");
		btnStart.addActionListener(handler);
		btnStart.setBounds(400, 100, 100, 30);
		add(btnStart);
		
		
		
		setVisible(true);
	}

}
