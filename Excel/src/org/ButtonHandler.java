package org;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String btn=e.getActionCommand();
		MainFrame frm=(MainFrame)((Button)e.getSource()).getParent();
		if(btn.equals("Bar Graph"))
		{
			new BarChart(frm);
		}
		else
		{
			new PieChart(frm);
		}
	}

}
