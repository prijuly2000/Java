import java.awt.Frame;
import java.awt.Graphics;


public class MainForm extends Frame
{
	public MainForm()
	{
		setBounds(10,10,400,400);
		setTitle("Form");
		setVisible(true);
		
	}
	public void paint(Graphics grp)
	{
		System.out.println("Paint");
		grp.drawString("HelloWorld", 150, 50);
	}
	
}
