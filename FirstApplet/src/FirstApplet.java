import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstApplet extends Applet implements ActionListener
{
	Button btn=new Button("Change Color");
	int red=255;
	int green=150;
	int blue=0;
	public FirstApplet()
	{
		setLayout(null);
		btn.setBounds(50, 125, 100, 30);
		setBounds(10, 10,100, 100);
		btn.addActionListener(this);
		add(btn);
		red=255;
		green=150;
		blue=0;
	}
	
	public void paint(Graphics grp)
	{
		grp.drawString("hello world", 100,100);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		setBackground(Color.RED);
			
	}
	float []arrHSB={0.1f,0.2f,0.3f};
	@Override
	public void init()
	{
		System.out.println("FirstApplet.init()");
		
	}

	@Override
	public void start()
	{
		Color c;
		c=new Color(red,green,blue);
		setBackground(c);
		red-=20;
		green-=10;
		blue+=20;
		System.out.println("FirstApplet.start()");
		
		
	}

	@Override
	public void stop()
	{
		System.out.println("FirstApplet.stop()");
		
	}

	@Override
	public void destroy()
	{
		System.out.println("FirstApplet.destroy()");
	}
	
}
