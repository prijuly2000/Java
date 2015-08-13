package org;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame
{
	int xPos[]=new int[250];
	int yPos[]=new int[250];
	TextField []arrTextFields=new TextField[2];
	static final int TXTDELAY=0;
	static final int TXTAMP=1;
	public MainFrame()
	{
		setBounds(0, 0, 500, 500);
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
		Button btnStart=new Button("Start");
		btnStart.setBounds(420, 450, 50, 30);
		btnStart.addActionListener(handler);
		add(btnStart);
		int x=440;
		int y=390;
		Label arrLabels[]=new Label[2];
		String []lblCaptions={"Delay:","Amplitude:"};
		for(int index=0;index<2;index++)
		{
			arrLabels[index]=new Label(lblCaptions[index]);
			arrLabels[index].setBounds(x-60, y, 60, 20);
			add(arrLabels[index]);
			
			arrTextFields[index]=new TextField();
			arrTextFields[index].setBounds(x, y, 50, 20);
			y+=30;
			add(arrTextFields[index]);
		}
		
		setVisible(true);
		
		
	}
	

}
