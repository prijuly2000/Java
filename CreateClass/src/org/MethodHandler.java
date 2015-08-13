package org;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MethodHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		MethodFrame secondFrm=(MethodFrame)((Button)e.getSource()).getParent();
		String memberBtn=e.getActionCommand();
		
		if(memberBtn.equals("Add"))
		{
			secondFrm.frm.methodFrm=secondFrm;
			new MemberFrame(secondFrm.frm);
		}
		else if(memberBtn.equals("Remove"))
		{
			secondFrm.lstDataMember.remove(secondFrm.lstDataMember.getSelectedIndex());
		}
		else
		{
			String item=secondFrm.group.getSelectedCheckbox().getLabel();
			item+=" "+secondFrm.chType.getSelectedItem();
			item+=" "+secondFrm.arrTextField[0].getText();
			item+=" ( ";
			for(int index=0;index<secondFrm.lstDataMember.getItemCount();index++)
			{
				if(index>0)
					item+=",";
				item+=secondFrm.lstDataMember.getItem(index);
				
			}
			
			item+=" );";
			secondFrm.frm.lstMethod.add(item);
			secondFrm.dispose();
		}

	}

}
