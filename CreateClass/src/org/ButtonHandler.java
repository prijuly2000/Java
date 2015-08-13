package org;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ButtonHandler implements ActionListener
{

	MainFrame frm;
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String btnName=((Button)e.getSource()).getName();
		
		frm=(MainFrame)((Button)e.getSource()).getParent();
		frm.btnName=btnName;
		
		if(btnName.equals("dataMemberAdd"))
		{
			new MemberFrame(frm);
		}
		else if(btnName.equals("dataMemberRemove"))
		{
			
		}
		else if(btnName.equals("methodAdd"))
		{
			new MethodFrame(frm);
		}
		else if(btnName.equals("methodRemove"))
		{
			frm.lstMethod.remove(frm.lstMethod.getSelectedIndex());
		}
		else
		{
			String fileData="package "+frm.arrTextField[frm.TXTPACKAGE].getText()+";\n\n\n";
			fileData+=frm.group.getSelectedCheckbox().getLabel();
			fileData+=" class "+frm.arrTextField[frm.TXTCLASSNAME].getText()+" \n { \n";
			System.out.println(frm.arrTextField[frm.TXTCLASSNAME].getText());
			for(int index=0;index<frm.lstDataMember.getItemCount();index++)
			{
				fileData+=frm.lstDataMember.getItem(index)+"\n";
				System.out.println(frm.lstDataMember.getItem(index));
			}
			fileData+="\n\n\n";
			for(int index=0;index<frm.lstMethod.getItemCount();index++)
			{
				fileData+=frm.lstMethod.getItem(index)+"\n";
				System.out.println(frm.lstMethod.getItem(index));
			}
			fileData+="\n\n}";
			File pkg=new File("D:\\nt-pritz\\javase\\CreateClass\\"+frm.arrTextField[frm.TXTPACKAGE].getText());
			if(!pkg.exists())
			{
				System.out.println("Folder created");
				pkg.mkdir();
			}
		
			File objFile=new File("D:\\nt-pritz\\javase\\CreateClass\\"+frm.arrTextField[frm.TXTPACKAGE].getText()+"\\"+frm.arrTextField[frm.TXTCLASSNAME].getText()+".java");
			System.out.println(fileData);
			FileOutputStream fos=null;
			
			try
			{
				if(!objFile.exists())
					objFile.createNewFile();
				fos=new FileOutputStream(objFile);
				fos.write(fileData.getBytes());
			} catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally
			{
				try
				{
					if(fos!=null)
						fos.close();
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}	
			
			
	}
	
	

}
