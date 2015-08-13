import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AppletEntry extends Applet implements ActionListener
{
	TextField txtPassword=new TextField();
	static int change;
	public AppletEntry()
	{
		
		setLayout(null);
		setBounds(0, 0, 500, 500);
		
		Label password=new Label("Password");
		password.setBounds(0, 50, 100, 20);
		add(password);
		final int MAXBUTTONS=48;
		Button arrButton[]=new Button[MAXBUTTONS];
		String btnCaptions[]={"t","e","q","c","w","b","a","s","y","3","1","7",
							  "f","o","j","v","m","p","d","r","g","4","2","5",
							  "x","i","l","z","u","h","k","n","","8","9","6",
							  ":","@","~","$","-","<","]","[","","","0",""};
		
		int xPos=20;
		int yPos=100;
		
		txtPassword.setBounds(150, 50, 100, 20);
		add(txtPassword);
		
		
		for(int index=0;index<48;index++)
		{
			if(index%12==0)
			{
				xPos=20;
				yPos+=30;
			}
			arrButton[index]=new Button(btnCaptions[index]);
			arrButton[index].addActionListener(this);
			arrButton[index].setBounds(xPos, yPos, 30, 20);
			if(index==32 || index==47 ||index==45 || index==44)
				arrButton[index].setVisible(false);
			add(arrButton[index]);
			
			xPos+=60;
			change+=2;
		}
		
		
	}
	String txtData="";
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String btnPressed=e.getActionCommand();
		txtData+=e.getActionCommand();
		System.out.println(txtData);
		txtPassword.setText(txtPassword.getText()+"*");
		
		
	}
}
