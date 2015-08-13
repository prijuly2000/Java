package exam;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame
{
	final int MAXBUTTONS=16;
	TextField txtDisplay=new TextField();
	public MainFrame()
	{
		setBounds(0,0,300,350);
		setLayout(null);
		
		
		txtDisplay.setBounds(100,100,150,20);
		
		add(txtDisplay);
		int index;
		int xPos=100;
		int yPos=100;
		
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		
		String []arrCaptions={"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
		Button arrButton[]=new Button[MAXBUTTONS];
		ButtonHandler handler=new ButtonHandler();
		for(index=0;index<MAXBUTTONS;index++)
		{
			if(index%4==0)
			{
				yPos+=40;
				xPos=100;
			}
			else
				xPos+=40;
			arrButton[index]=new Button();
			arrButton[index].setBounds(xPos, yPos, 30, 30);
			arrButton[index].setLabel(arrCaptions[index]);
			arrButton[index].addActionListener(handler);
			add(arrButton[index]);
			
		}
		
		setVisible(true);
	}
}
