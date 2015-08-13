import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonHandler implements ActionListener
{

	boolean flag=false;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String btnPressed=e.getActionCommand();
		Button btn=(Button)e.getSource();
		MainFrame frm=(MainFrame)btn.getParent();
		int index;
		String []arrButtonCaptions={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","Space","Tab","Enter","Backspace","Cap"};
		
		
		
		for(index=0;index<MainFrame.MAXBUTTONS;index++)
		{
			if(index<26)
			{
				if(btnPressed.equals(arrButtonCaptions[index]))
				{
					if(!flag)
						frm.txtDisplay.append(arrButtonCaptions[index].toLowerCase());
					else
						frm.txtDisplay.append(arrButtonCaptions[index].toUpperCase());
					return;
				}				
			}
			else
			{
				if(btnPressed.equals("Enter"))
					frm.txtDisplay.append("\n");
				else if(btnPressed.equals("Space"))
					frm.txtDisplay.append(" ");
				else if(btnPressed.equals("Tab"))
					frm.txtDisplay.append("\t");
				else if(btnPressed.equals("Backspace"))
				{
					if(!frm.txtDisplay.getText().equals(""))
						frm.txtDisplay.setText(frm.txtDisplay.getText().substring(0, frm.txtDisplay.getText().length()-1));
						
				}
				else if(btnPressed.equals("Cap"))
				{
					System.out.println(btnPressed+" "+flag);
					if(flag)
						flag=false;
					else
						flag=true;
				}
				return;				
			}
			
		}
		
		
	}

}
