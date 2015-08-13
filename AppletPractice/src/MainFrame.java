

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends Applet implements ActionListener
{
	Button button=new Button("Change Color");
	
	public MainFrame()
	{
		setLayout(null);
		setBounds(100, 100, 400, 400);
		button.setBounds(50, 50, 100, 100);
		button.addActionListener(this);
		add(button);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		setBackground(Color.BLACK);
	}
	
	
}
