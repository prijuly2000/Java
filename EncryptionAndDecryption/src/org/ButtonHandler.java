package org;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ButtonHandler implements ActionListener
{

	MainFrame frm;
	@Override
	public void actionPerformed(ActionEvent e)
	{

		String btnPressed=e.getActionCommand();
		frm=(MainFrame)((Button)e.getSource()).getParent();
		
		
		File file=new File(frm.txtFileName.getText());
		
		if(btnPressed.equals("Encrypt"))
		{
			
			FileOutputStream fos=null;
			try
			{
				if(!file.exists())
					file.createNewFile();
				
				fos=new FileOutputStream(file);
				String data=frm.txtData.getText();
			
				char []newData=data.toCharArray();
					
				
				int length=data.length();
				data="";
				for(int index=0;index<length;index++)
				{
					int enChar=newData[index]+10;
					newData[index]=(char)enChar;
					data+=newData[index];
					System.out.println(data);
					
				}
				
				
				
				fos.write(data.getBytes());
			} catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else
		{
			if(!file.exists())
			{
				frm.noFile.setVisible(true);
				return;
			}
			
			FileInputStream fis=null;
			
			try
			{
				fis=new FileInputStream(file);
				byte []data=new byte[(int)file.length()];
				fis.read(data);
				String fileData=new String(data);
				char []newData=fileData.toCharArray();
				fileData="";
				for(int index=0;index<file.length();index++)
				{
					int enChar=newData[index]-10;
					newData[index]=(char)enChar;
					fileData+=newData[index];
					System.out.println(fileData);
					//System.out.println("New Data:  "+newData[index]+" || Encrypt Char:  "+enChar);
				}
				frm.txtData.setText(fileData);
			}
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			} 
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
			
			
		}

	}

}
