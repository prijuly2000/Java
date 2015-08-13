package org;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame
{
	TextArea txtData=new TextArea();
	TextField txtFileName=new TextField();
	Label noFile=new Label("NO SUCH FILE EXISTS");
	public MainFrame()
	{
		setBounds(100,100,500,500);
		setLayout(null);
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
			
			
		});
		Label objLabel=new Label("File Name:");
		objLabel.setBounds(50, 50, 100, 30);
		add(objLabel);
		
		Font f=new Font("Arial Bold",Font.BOLD,30);
		noFile.setBounds(100, 150, 400, 30);
		noFile.setFont(f);
		add(noFile);
		noFile.setVisible(false);
		
		
		txtFileName.setBounds(160,50 , 150, 20);
		add(txtFileName);
		txtFileName.addFocusListener(new FocusAdapter()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
				noFile.setVisible(false);
			}
			
		});
		txtData.setBounds(50, 200,400, 200);
		add(txtData);
		
		Button arrButton[]=new Button[2];
		String[] btnCaptions={"Encrypt","Decrypt"};
		int xPos=100;
		int yPos=450;
		ButtonHandler handler=new ButtonHandler();
		for(int index=0;index<2;index++)
		{
			arrButton[index] =new Button(btnCaptions[index]);
			arrButton[index].setBounds(xPos, yPos, 100, 40);
			arrButton[index].addActionListener(handler);
			add(arrButton[index]);
			xPos+=150;
		}
		
		
		setVisible(true);
	}
}
