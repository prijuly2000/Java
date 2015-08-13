package excel;



import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener
{

	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Button  btn=(Button)e.getSource();
		MainFrame frm=(MainFrame)btn.getParent();
		String actionCommand=e.getActionCommand();
		System.out.println("Action Command :"+ actionCommand);
		

	}

}
