package org;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientFrame extends Frame
{
	TextField txtUrl=new TextField();
	List lstEmp=new List();
	public ClientFrame()
	{
		setBounds(100,100,400,400);
		setLayout(null);
		Label lblUrl=new Label("RMI Url");
		lblUrl.setBounds(10, 50, 50, 20);
		add(lblUrl);
		
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
			
		});
		
		
		txtUrl.setBounds(60, 50, 100, 20);
		add(txtUrl);
		
		ButtonHandler handler=new ButtonHandler();
		
		Button btnGet=new Button("Get");
		btnGet.setBounds(300, 300, 50, 50);
		btnGet.addActionListener(handler);
		add(btnGet);
		
		Label lblList=new Label("Employees");
		lblList.setBounds(10, 100, 100, 20);
	
		add(lblList);
		
		
		lstEmp.setBounds(100, 150, 150, 200);
		
		lstEmp.addActionListener(handler);
		add(lstEmp);
		
		setVisible(true);
		
	}
}
