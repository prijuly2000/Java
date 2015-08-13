import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame extends Frame
{
	String str;
	static final int MAXBUTTONS=31;
	Button arrButtons[]=new Button[MAXBUTTONS];
	//TextField txtDisplay=new TextField();
	TextArea txtDisplay=new TextArea();
	public MainFrame()
	{
		setLayout(null);
		setBounds(0,0,600,500);
		
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{				
				dispose();
			}
			
		});
		
		txtDisplay.setBounds(20, 50, 500, 100);
		
		add(txtDisplay);
		
		int index;
		int xPos=50;
		int yPos=120;
		ButtonHandler handler=new ButtonHandler();
		String []arrButtonCaptions={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","Space","Tab","Enter","Backspace","Cap"};
		for(index=0;index<MAXBUTTONS;index++)
		{
			if(index%6==0)
			{
				xPos=20;
				yPos+=50;
			}
			else
				xPos+=80;
			arrButtons[index]=new Button();
			arrButtons[index].addActionListener(handler);
			arrButtons[index].setLabel(arrButtonCaptions[index]);
			arrButtons[index].setBounds(xPos,yPos,70,20);
			add(arrButtons[index]);
			
			
		}
		
		setVisible(true);
	}
}
