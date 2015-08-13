package org;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener
{

	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		MainFrame frm=(MainFrame)((Button)(e.getSource())).getParent();
		Thread objThread1=new Thread(new RectThread(frm));
		objThread1.start();
		
		Thread objThread2=new Thread(new OvalThread(frm));
		objThread2.start();
	}

}
