package exam;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener
{

	int num1=0;
	int num2=0;
	String op;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int index;
		String actionCommand=e.getActionCommand();
		MainFrame frm=(MainFrame)((Button)e.getSource()).getParent();
		
		TextField txtDisplay=frm.txtDisplay;
		String []arrCaptions={"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
		
		for(index=0;index<frm.MAXBUTTONS;index++)
		{
			if(actionCommand.equals(arrCaptions[index])&& !actionCommand.equals("=")&& !actionCommand.equals("/")&& !actionCommand.equals("+")&& !actionCommand.equals("-")&& !actionCommand.equals("*"))
			{
				
				txtDisplay.setText(txtDisplay.getText()+arrCaptions[index]);
				
				break;
			}
			else
			{
				if(actionCommand.equals("+"))
				{
					if(txtDisplay.getText().equals(""))
						return;
					if(num1==0)
					{
						num1=Integer.parseInt(txtDisplay.getText());
						txtDisplay.setText("");
						op="+";
						
					}
					else
					{
						num2=Integer.parseInt(txtDisplay.getText());
						txtDisplay.setText(String.valueOf(num1+num2));
						num1=0;
						num2=0;
					}
					break;
				}
				else if(actionCommand.equals("-"))
				{
					if(txtDisplay.getText().equals(""))
						return;
					if(num1==0)
					{
						num1=Integer.parseInt(txtDisplay.getText());
						txtDisplay.setText("");
						op="-";
					}
					else
					{
						num2=Integer.parseInt(txtDisplay.getText());
						txtDisplay.setText(String.valueOf(num1-num2));
						num1=0;
						num2=0;
					}
					break;
				}
				else if(actionCommand.equals("*"))
				{
					if(txtDisplay.getText().equals(""))
						return;
					if(num1==0)
					{
						num1=Integer.parseInt(txtDisplay.getText());
						txtDisplay.setText("");
						op="*";
					}
					else
					{
						num2=Integer.parseInt(txtDisplay.getText());
						txtDisplay.setText(String.valueOf(num1*num2));
						num1=0;
						num2=0;
					}
					break;
				}
				else if(actionCommand.equals("/"))
				{
					if(txtDisplay.getText().equals(""))
						return;
					if(num1==0)
					{
						num1=Integer.parseInt(txtDisplay.getText());
						txtDisplay.setText("");
						op="/";
					}
					else
					{
						num2=Integer.parseInt(txtDisplay.getText());
						float result=(float)num1/num2;
						txtDisplay.setText(String.valueOf(result));
						num1=0;
						num2=0;
					}
					break;
				}
				else if(actionCommand.equals("="))
				{
					if(txtDisplay.getText().equals(""))
						return;
					if(num1!=0 )
					{
					
					
						num2=Integer.parseInt(txtDisplay.getText());
						float result=Float.parseFloat(txtDisplay.getText());
						if(op.equals("+"))
							txtDisplay.setText(String.valueOf(num1+num2));
						else if(op.equals("-"))
							txtDisplay.setText(String.valueOf(num1-num2));
						else if(op.equals("*"))
							txtDisplay.setText(String.valueOf(num1*num2));
						else if(op.equals("/"))
							txtDisplay.setText(String.valueOf(num1/result));
						
						num1=0;
						num2=0;
						result=0;
					}
					else
					{
						txtDisplay.setText("0");
						num1=0;
						num2=0;

					}
					break;
				}	
					
			}
		}

	}

}
