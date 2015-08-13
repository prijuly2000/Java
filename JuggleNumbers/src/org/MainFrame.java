package org;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame
{
	TextField txt1=new TextField();
	TextField txt2=new TextField();
	TextField txt3=new TextField();
	
	public MainFrame()
	{
		setBounds(50,50,400,400);
		setLayout(null);
		
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
			
		});
		ButtonHandler handler=new ButtonHandler();
		Button btn1=new Button("Clockwise");
		btn1.addActionListener(handler);
		btn1.setBounds(50,200,100,30);
		
		Button btn2=new Button("Anticlockwise");
		btn2.setBounds(150,200,100,30);
		btn2.addActionListener(handler);
		
		txt1.setBounds(150, 50, 50, 30);
		txt2.setBounds(200, 150, 50, 30);
		txt3.setBounds(100, 150, 50, 30);
		add(txt1);
		add(txt2);
		add(txt3);
		
		add(btn1);
		add(btn2);
		
		setVisible(true);
	}
}
