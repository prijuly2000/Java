package org;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.utility.Linklist;
import employees.Employee;
import employees.Engineer;
import employees.Manager;
import employees.SalesPerson;


public class SortButtonHandler implements ActionListener
{

	SortFrame sortFrm;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String actionCommand=e.getActionCommand();
		sortFrm=(SortFrame)((Button)e.getSource()).getParent();
		String order;
		int iTmp;
		int jTmp;
		int maxCount=sortFrm.frm.objLinklist.getMaxCount();
		int index=0;
		String []names=new String[maxCount];
        if(actionCommand.equals("Start"))
        {
        	Employee employee=(Employee)sortFrm.frm.objLinklist.getFirst();
        	for(index=0;index<maxCount;index++)
        	{
        		names[index]=new String(employee.getName());
        		employee=(Employee)sortFrm.frm.objLinklist.getNext();  
        		System.out.println(names[index]);
        	}
        	String tmp;
        	sortFrm.empList.removeAll();
        	if(sortFrm.sortChoice.getSelectedItem().equals("Name"))
        	{
        		order=sortFrm.groupName.getSelectedCheckbox().getLabel();
        		if(order.equals("Ascending"))
        		{      		
        			for(iTmp=0;iTmp<maxCount-1;iTmp++)
        			{
        				for(jTmp=0;jTmp<maxCount-jTmp;jTmp++)
        				{
        					if(names[jTmp].compareTo(names[jTmp+1])>0)
        					{
        						tmp=names[jTmp];
        						names[jTmp]=names[jTmp+1];
        						names[jTmp+1]=tmp;
        					}
        				
        				}
        			}
        		
        		}
        		else
        		{
        			for(iTmp=0;iTmp<maxCount-1;iTmp++)
        			{
        				for(jTmp=0;jTmp<maxCount-jTmp;jTmp++)
        				{
        					if(names[jTmp].compareTo(names[jTmp+1])<0)
        					{
        						tmp=names[jTmp];
        						names[jTmp]=names[jTmp+1];
        						names[jTmp+1]=tmp;
        					}
        				
        				}
        			
        			}
        		}
        		for(index=0;index<maxCount;index++)
            	{
            		sortFrm.empList.add(names[index]);
            	}
        		
        	}
        	else
        	{
        		order=sortFrm.groupDesignation.getSelectedCheckbox().getLabel();
        		if(order.equals("Manager"))
        		{
        			displayManager();
        		}
        		else if(order.equals("Sales Person"))
        		{
        			displaySalesPerson();
        		}
        		else
        		{
        			displayEngineer();
        		}
        		
        	}
        }
        else
        {
        	String selectedName=sortFrm.empList.getSelectedItem();
        	
			Employee objEmployee=(Employee)sortFrm.frm.objLinklist.getFirst();
			for(index=0;index<sortFrm.frm.objLinklist.getMaxCount();index++)
			{			
				if((objEmployee.getName()).equals(selectedName))
				{					
					break;
				}
				objEmployee=(Employee)sortFrm.frm.objLinklist.getNext();
			}
			displayInformation(objEmployee);
        }
        
	}
	private void displayInformation(Employee objEmployee)
	{
				
		sortFrm.frm.arrTextFields[0].setText(objEmployee.getName());
		sortFrm.frm.txtAddress.setText(objEmployee.getAddress());
		sortFrm.frm.arrTextFields[1].setText(String.valueOf(objEmployee.getAge()));
		
		if(objEmployee.isGender())
			sortFrm.frm.arrGender[0].setState(true);
		else
			sortFrm.frm.arrGender[1].setState(true);
		
		sortFrm.frm.arrTextFields[2].setText(String.valueOf(objEmployee.getBasicSalary()));
		
		int allowance=objEmployee.getAllowance();
		
		if(allowance==0)
		{
			sortFrm.frm.arrAllowance[0].setState(false);
			sortFrm.frm.arrAllowance[1].setState(false);
		}
		else if(allowance==1)
		{
			sortFrm.frm.arrAllowance[0].setState(true);
			sortFrm.frm.arrAllowance[1].setState(false);
		}
		else if(allowance==2)
		{
			sortFrm.frm.arrAllowance[0].setState(false);
			sortFrm.frm.arrAllowance[1].setState(true);
		}
		else if(allowance==3)
		{
			sortFrm.frm.arrAllowance[0].setState(true);
			sortFrm.frm.arrAllowance[1].setState(true);
		}	
		
		if(objEmployee instanceof Manager)
		{
			sortFrm.frm.chDesignation.select(0);
			String common=String.valueOf(((Manager)objEmployee).getHra());
			sortFrm.frm.arrTextFields[sortFrm.frm.TXTCOMMON].setText(String.valueOf(common));
		}
		else if(objEmployee instanceof SalesPerson)
		{
			sortFrm.frm.chDesignation.select(1);
			String common=String.valueOf(((SalesPerson)objEmployee).getCommission());
			sortFrm.frm.arrTextFields[sortFrm.frm.TXTCOMMON].setText(String.valueOf(common));
			
		}
		else if(objEmployee instanceof Engineer)
		{
			sortFrm.frm.chDesignation.select(2);
			String common=String.valueOf(((Engineer)objEmployee).getOt());
			sortFrm.frm.arrTextFields[sortFrm.frm.TXTCOMMON].setText(String.valueOf(common));
			
		}
	}
	private void displayManager()
	{
		int index;
		Linklist objLinklist=sortFrm.frm.objLinklist;
		Employee objEmp=(Employee)objLinklist.getFirst();
		for(index=0;index<objLinklist.getMaxCount();index++)
		{
			if(objEmp instanceof Manager)
			{
				sortFrm.empList.add(objEmp.getName());
			}
			objEmp=(Employee)objLinklist.getNext();
		}
	}
	
	private void displaySalesPerson()
	{
		int index;
		Linklist objLinklist=sortFrm.frm.objLinklist;
		Employee objEmp=(Employee)objLinklist.getFirst();
		for(index=0;index<objLinklist.getMaxCount();index++)
		{
			if(objEmp instanceof SalesPerson)
			{
				sortFrm.empList.add(objEmp.getName());
			}
			objEmp=(Employee)objLinklist.getNext();
		}
	}
	
	private void displayEngineer()
	{
		int index;
		Linklist objLinklist=sortFrm.frm.objLinklist;
		Employee objEmp=(Employee)objLinklist.getFirst();
		System.out.println(objEmp.getClass());
		for(index=0;index<objLinklist.getMaxCount();index++)
		{
			if(objEmp instanceof Engineer)
			{
				sortFrm.empList.add(objEmp.getName());
			}
			objEmp=(Employee)objLinklist.getNext();
		}
	}
	
	

}

