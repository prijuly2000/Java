package org;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import employees.Employee;
import employees.Engineer;
import employees.Manager;
import employees.SalesPerson;


public class ButtonHandler implements ActionListener
{
	int allowance;
	String name;
	int age;
	boolean gender;
	Checkbox  chGender;
	Checkbox []arrAllowance;
	String address;
	float basicSalary;
	float common;
	Employee objEmployee;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		MainFrame frm=(MainFrame)((Button)e.getSource()).getParent();
		String actionCommand=e.getActionCommand();
		
		if(actionCommand.equals("Add"))
		{	
			informationFromControls(frm);
			
			int designation=frm.chDesignation.getSelectedIndex();
			
			if(designation==0)
			{
				Manager objManager=new Manager(name,address,age,gender,basicSalary,common,allowance);
				frm.objLinklist.add(objManager);
			}
			else if(designation==1)
			{
				SalesPerson objSalesPerson=new SalesPerson(name,address,age,gender,basicSalary,common,allowance);
				frm.objLinklist.add(objSalesPerson);
			}
			else if(designation==2)
			{
				Engineer objEngineer=new Engineer(name,address,age,gender,basicSalary,common,allowance);
				frm.objLinklist.add(objEngineer);
			}
						
			System.out.println(name+" || "+address+" || "+age+" || "+gender+" || "+basicSalary+" || "+common+" || "+allowance);			
						
			clearAll(frm);
		}
		else if(actionCommand.equals("Delete"))
		{			
			String nameDelete=frm.arrTextFields[frm.TXTNAME].getText();
			objEmployee=(Employee)frm.objLinklist.getFirst();
			for(int index=0;index<frm.objLinklist.getMaxCount();index++)
			{			
				if((objEmployee.getName()).equals(nameDelete))
				{
					frm.objLinklist.delete(index);
					return;
				}
				objEmployee=(Employee)frm.objLinklist.getNext();
			}
		}
		else if(actionCommand.equals("Update"))
		{			
			if(objEmployee!=null)
			{
				informationFromControls(frm);
				updateInformation();				
			}
		}
		else if(actionCommand.equals("Sort"))
		{
			new SortFrame(frm);
		}
		else if(actionCommand.equals("First"))
		{
			objEmployee=(Employee)frm.objLinklist.getFirst();
			displayInformation(frm);	
		
		}
		else if(actionCommand.equals("Previous"))
		{
			objEmployee=(Employee)frm.objLinklist.getPrevious();
			if(objEmployee!=null)
				displayInformation(frm);
		}
		else if(actionCommand.equals("Next"))
		{
			objEmployee=(Employee)frm.objLinklist.getNext();
			if(objEmployee!=null)
				displayInformation(frm);
		}
		else if(actionCommand.equals("Last"))
		{
			objEmployee=(Employee)frm.objLinklist.getLast();
			displayInformation(frm);
			
		}
		else if(actionCommand.equals("Save"))
		{
			FileOutputStream fos=null;
			ObjectOutputStream oos=null;
			try
			{
				fos=new FileOutputStream("D:\\nt-pritz\\javase\\EmployeeInformation\\Employee Data.txt");
				oos=new ObjectOutputStream(fos);
				Employee emp=(Employee)frm.objLinklist.getFirst();
				for(int index=0;index<frm.objLinklist.getMaxCount();index++)
				{
					oos.writeObject(emp);
					emp=(Employee)frm.objLinklist.getNext();
				}
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
					if(oos!=null)
						oos.close();
					if(fos!=null)
						fos.close();
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		else if(actionCommand.equals("Load"))
		{
			FileInputStream fis=null;
			ObjectInputStream ois=null;
			
			try
			{
				File objFile=new File("D:\\nt-pritz\\javase\\EmployeeInformation\\Employee Data.txt");
				fis=new FileInputStream(objFile);
				ois=new ObjectInputStream(fis);
								
				for(int index=0;index<objFile.length() ;index++)
				{
					frm.objLinklist.add((Employee)ois.readObject());
				}
			} 
			catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (ClassNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			finally
			{
				try
				{
					if(ois!=null)
						ois.close();
					if(fis!=null)
						fis.close();
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		else if(actionCommand.equals("Transfer"))
		{
			
		}
		else if(actionCommand.equals("Exit"))
		{
			frm.dispose();
		}
		
		
	}
	
	private void informationFromControls(MainFrame frm)
	{
		name=frm.arrTextFields[frm.TXTNAME].getText();
		
		String tmp=frm.arrTextFields[frm.TXTAGE].getText();
		age=Integer.parseInt(tmp);
		
		
		chGender=frm.group.getSelectedCheckbox();
		if((chGender.getLabel()).equals("Male"))
			gender=true;

		arrAllowance=frm.arrAllowance;
		
		if(arrAllowance[0].getState() && arrAllowance[1].getState())
			allowance=3;
		else if(arrAllowance[1].getState())
			allowance=2;
		else if(arrAllowance[0].getState())
			allowance=1;
		else
			allowance=0;
				
		address=frm.txtAddress.getText();
		
		tmp=frm.arrTextFields[frm.TXTBASICSALARY].getText();
		basicSalary=Float.parseFloat(tmp);
		
		tmp=frm.arrTextFields[frm.TXTCOMMON].getText();
		common=Float.parseFloat(tmp);
	}
	
	private void updateInformation()
	{
		objEmployee.setName(name);
		objEmployee.setAddress(address);
		objEmployee.setAge(age);
		objEmployee.setGender(gender);
		objEmployee.setBasicSalary(basicSalary);
		objEmployee.setAllowance(allowance);
	}
	
	private void clearAll(MainFrame frm)
	{
		int index;
		for(index=0;index<4;index++)
			frm.arrTextFields[index].setText("");
		
		frm.txtAddress.setText("");
		
		for(index=0;index<2;index++)
		{
			frm.arrGender[index].setState(false);
			frm.arrAllowance[0].setState(false);
		}
	}
	
	private void displayInformation(MainFrame frm)
	{
		frm.arrTextFields[0].setText(objEmployee.getName());
		frm.txtAddress.setText(objEmployee.getAddress());
		frm.arrTextFields[1].setText(String.valueOf(objEmployee.getAge()));
		
		if(objEmployee.isGender())
			frm.arrGender[0].setState(true);
		else
			frm.arrGender[1].setState(true);
		
		frm.arrTextFields[2].setText(String.valueOf(objEmployee.getBasicSalary()));
		
		allowance=objEmployee.getAllowance();
		
		if(allowance==0)
		{
			frm.arrAllowance[0].setState(false);
			frm.arrAllowance[1].setState(false);
		}
		else if(allowance==1)
		{
			frm.arrAllowance[0].setState(true);
			frm.arrAllowance[1].setState(false);
		}
		else if(allowance==2)
		{
			frm.arrAllowance[0].setState(false);
			frm.arrAllowance[1].setState(true);
		}
		else if(allowance==3)
		{
			frm.arrAllowance[0].setState(true);
			frm.arrAllowance[1].setState(true);
		}
		if(objEmployee instanceof Manager)
		{
			frm.chDesignation.select(0);
			frm.arrTextFields[frm.TXTCOMMON].setText(String.valueOf(((Manager)objEmployee).getHra()));
		}			
		else if(objEmployee instanceof SalesPerson)
		{
			frm.chDesignation.select(1);
			frm.arrTextFields[frm.TXTCOMMON].setText(String.valueOf(((SalesPerson)objEmployee).getCommission()));
		}
		else
		{
			frm.chDesignation.select(2);
			frm.arrTextFields[frm.TXTCOMMON].setText(String.valueOf(((Engineer)objEmployee).getOt()));
		}
	}
	private void writeToFile()
	{
		
	}

}
