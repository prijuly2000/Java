package org;

import java.awt.Button;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ButtonHandler implements ActionListener
{

	ClientFrame frm;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		String cmd=e.getActionCommand();
		
		if(cmd.equals("Get"))
		{
			frm=(ClientFrame)((Button)e.getSource()).getParent();
		if(frm.txtUrl.getText()!="")
		{
			try
			{
				Employee objEmp=(Employee)Naming.lookup("rmi://"+frm.txtUrl.getText()+"/EmployeeDetails");
				String []names=objEmp.getAllEmployeeNames();
				frm.lstEmp.removeAll();
				for(int index=0;index<10;index++)
				{
					frm.lstEmp.add(names[index]);
				}
			}
			catch (MalformedURLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (RemoteException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (NotBoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		}
		else 
		{
			frm=(ClientFrame)((List)e.getSource()).getParent();
			try
			{
				Employee objEmp=(Employee)Naming.lookup("rmi://"+frm.txtUrl.getText()+"/EmployeeDetails");
				String name=frm.lstEmp.getSelectedItem();
				String []names=objEmp.getEmployeeDetails(name);
				frm.lstEmp.removeAll();
				for(int index=0;index<3;index++)
				{
					frm.lstEmp.add(names[index]);
					System.out.println(names[index]);
				}
			}
			catch (MalformedURLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (RemoteException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (NotBoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	
	}

	
}
