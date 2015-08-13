package org;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.Buffer;

public class ButtonHandler implements ActionListener
{
	int flag1;
	int flag2;
	int flag3;
	boolean minus1;
	boolean minus2;
	boolean minus3;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		MainFrame frm=(MainFrame)((Button)e.getSource()).getParent();
		
		String str1="0"+frm.txt1.getText();
		String str2="0"+frm.txt2.getText();
		String str3="0"+frm.txt3.getText();
		flag1=0;
		flag2=0;
		flag3=0;
		
		minus1=false;
		minus2=false;
		minus3=false;
		
		if(str1.indexOf('-')!=-1)
			minus1=true;
		if(str2.indexOf('-')!=-1)
			minus2=true;
		if(str3.indexOf('-')!=-1)
			minus3=true;
		
			
		str1=str1.replace('-', '0');
		str2=str2.replace('-', '0');
		str3=str3.replace('-', '0');
		
		System.out.println(str1);
		if(frm.txt1.getText().equals(""))
			flag1=1;
		if(frm.txt2.getText().equals(""))
			flag2=1;
		if(frm.txt3.getText().equals(""))
			flag3=1;
	
		int txt1=Integer.parseInt(str1);
		int txt2=Integer.parseInt(str2);
		int txt3=Integer.parseInt(str3);
		if(minus1)
			txt1=-txt1;
		if(minus2)
			txt2=-txt2;
		if(minus3)
			txt3=-txt3;
			
		if(e.getActionCommand().equals("Clockwise"))
		{
			frm.txt1.setText("");
			frm.txt2.setText("");
			frm.txt3.setText("");
			
			//if(txt1!=0)
			if(flag1!=1)
				frm.txt2.setText(txt1+10+"");
			//if(txt2!=0)
			if(flag2!=1)
				frm.txt3.setText(txt2+10+"");
			//if(txt3!=0)
			if(flag3!=1)
				frm.txt1.setText(txt3+10+"");
		}
		else if(e.getActionCommand().equals("Anticlockwise"))
		{
			frm.txt1.setText("");
			frm.txt2.setText("");
			frm.txt3.setText("");
			
			//if(txt1!=0)
			if(flag1!=1)
				frm.txt3.setText(txt1-10+"");
			//if(txt2!=0)
			if(flag2!=1)
				frm.txt1.setText(txt2-10+"");
			//if(txt3!=0)
			if(flag3!=1)
				frm.txt2.setText(txt3-10+"");
		}
		
			
	}

}
