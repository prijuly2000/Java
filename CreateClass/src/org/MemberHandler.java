package org;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		MemberFrame secondFrm=(MemberFrame)((Button)e.getSource()).getParent();
		String memberBtn=e.getActionCommand();
		
		if(memberBtn.equals("Add"))
		{
			if(secondFrm.frm.btnName.equals("dataMemberAdd") )
			{
				String item=secondFrm.group.getSelectedCheckbox().getLabel();
				item+=" "+secondFrm.chType.getSelectedItem();
				item+=" "+secondFrm.arrTextField[0].getText();
				item+=" ;";
				secondFrm.lstDataMember.add(item);
			}
			else  
			{
				String item="";
				item+=" "+secondFrm.chType.getSelectedItem();
				item+=" "+secondFrm.arrTextField[0].getText();
				secondFrm.lstDataMember.add(item);
				
			}
			
			
		}
		else if(memberBtn.equals("Remove"))
		{
			secondFrm.lstDataMember.remove(secondFrm.lstDataMember.getSelectedItem());
		}
		else
		{
			System.out.println(secondFrm.frm.btnName);
			if(secondFrm.frm.btnName.equals("dataMemberAdd"))
			{
				for(int index=0;index<secondFrm.lstDataMember.getItemCount();index++)
				{
					secondFrm.frm.lstDataMember.add(secondFrm.lstDataMember.getItem(index));
				}
			}
			else 
			{
				for(int index=0;index<secondFrm.lstDataMember.getItemCount();index++)
				{
					secondFrm.frm.methodFrm.lstDataMember.add(secondFrm.lstDataMember.getItem(index));
				}
			}
			secondFrm.dispose();
		}
		
		
	}

}
