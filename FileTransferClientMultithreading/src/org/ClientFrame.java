package org;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientFrame extends Frame
{
	
		TextField txtFields[]=new TextField[3];
		Button arrButton[]=new Button[3];
		List lstFiles=new List();
		public ClientFrame()
		{
			setBounds(100,100,350,500);
			setLayout(null);
			
			addWindowListener(new WindowAdapter()
			{

				@Override
				public void windowClosing(WindowEvent e)
				{
					dispose();
				}
				
			});
			
			ClientHandler handler=new ClientHandler();
			
			int yPos=50;
			int index=0;
			Label arrLabel[]=new Label[4];
			String []lblCaptions={"ipAddress","PortNo","Path"};
			String []btnCaptions={"Connect","Disconnect","Download"};
			for(index=0;index<3;index++)
			{
				arrLabel[index]=new Label(lblCaptions[index]);
				arrLabel[index].setBounds(20, yPos, 50, 30);
				add(arrLabel[index]);
							
				txtFields[index]=new TextField();
				txtFields[index].setBounds(70, yPos, 150, 20);
				add(txtFields[index]);
				
				if(index>1)
					yPos+=100;
				arrButton[index]=new Button(btnCaptions[index]);
				arrButton[index].setBounds(250, yPos-5, 70, 30);
				arrButton[index].addActionListener(handler);
				add(arrButton[index]);
				
				yPos+=60;
			}
			
			arrLabel[index]=new Label("Files on Server");
			arrLabel[index].setBounds(50, yPos-100, 120, 20);
			add(arrLabel[index]);
			
			lstFiles.setBounds(30, yPos-60, 200, 200);
			add(lstFiles);
			setVisible(true);
			
		}

}	


