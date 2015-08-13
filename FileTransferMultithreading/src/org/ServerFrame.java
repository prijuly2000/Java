package org;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ServerFrame extends Frame 
{
	TextField txtFields[]=new TextField[2];
	Button arrButton[]=new Button[2];
	TextArea txtClients=new TextArea();
	public ServerFrame()
	{
		setBounds(100,100,300,500);
		setLayout(null);
		
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
			
		});
		
		ServerHandler handler=new ServerHandler();
		
		int yPos=50;
		int index=0;
		Label arrLabel[]=new Label[3];
		String []lblCaptions={"Port No.","Path"};
		String []btnCaptions={"Start","Stop"};
		for(index=0;index<2;index++)
		{
			arrLabel[index]=new Label(lblCaptions[index]);
			arrLabel[index].setBounds(20, yPos, 50, 30);
			add(arrLabel[index]);
						
			txtFields[index]=new TextField();
			txtFields[index].setBounds(70, yPos, 150, 20);
			add(txtFields[index]);
			
			arrButton[index]=new Button(btnCaptions[index]);
			arrButton[index].setBounds(230, yPos-5, 50, 30);
			arrButton[index].addActionListener(handler);
			add(arrButton[index]);
			
			yPos+=60;
		}
		
		arrLabel[index]=new Label("Connected Clients");
		arrLabel[index].setBounds(50, yPos, 120, 20);
		add(arrLabel[index]);
		
		txtClients.setBounds(30, yPos+30, 200, 200);
		add(txtClients);
		setVisible(true);
		
	}

	
}
