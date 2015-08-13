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
		Thread objThread=new Thread(new RectThread(frm));
		objThread.start();
	}

}
