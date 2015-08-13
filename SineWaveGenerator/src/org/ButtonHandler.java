package org;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		MainFrame frm=(MainFrame)((Button)e.getSource()).getParent();
		
		Thread producerThread=new Thread(new Producer(frm));
		producerThread.start();
		
		Thread consumerThread=new Thread(new Consumer(frm));
		consumerThread.start();
		
	}
	
}
