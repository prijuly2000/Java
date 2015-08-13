package org;


import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SortFrame extends Frame implements ItemListener 
{
	MainFrame frm;
	
	
	Choice sortChoice=new Choice();
	Checkbox arrNameOptions[]=new Checkbox[2];	
	Checkbox arrDesignationOptions[]=new Checkbox[3];
	CheckboxGroup groupName=new CheckboxGroup();
	CheckboxGroup groupDesignation=new CheckboxGroup();
	List empList=new List();
	public SortFrame(MainFrame frm)
	{
		this.frm=frm;
		setBounds(0,0,500,500);
		setLayout(null);
		
		
		sortChoice.setBounds(150, 40, 100, 20);
		sortChoice.add("Name");
		sortChoice.add("Designation");
		sortChoice.addItemListener(this);
		add(sortChoice);
		
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		 
		displayOptions();
		
		
		empList.setBounds(100, 200, 200, 200);
		add(empList);
		int index;
		Button []arrButtons=new Button[2];
		int yPos=220;
		String []btnCaptions={"Start","Details"};
		SortButtonHandler handler=new SortButtonHandler();
		for(index=0;index<2;index++)
		{
			arrButtons[index]=new Button();
			arrButtons[index].setBounds(310,yPos, 100, 30);
			arrButtons[index].setLabel(btnCaptions[index]);
			arrButtons[index].addActionListener(handler);
			add(arrButtons[index]);
			yPos+=50;
		}
		
		
		setVisible(true);
	}
	
	public void paint(Graphics grp)
	{
		grp.drawString("Sort By : ", 100, 55);
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		int index;
		String choice=e.getItem().toString();
		 if(choice.equals("Name"))
		 {
			for(index=0;index<2;index++)
			{
				arrNameOptions[index].setVisible(true);
				arrDesignationOptions[index].setVisible(false);
			}
			arrDesignationOptions[index].setVisible(false);
		 }
		 else
		 {
			 for(index=0;index<3;index++)
			{
				 if(index<2)
					arrNameOptions[index].setVisible(false);
				 arrDesignationOptions[index].setVisible(true);
			}
		 }
		 	
		 
			 
		
			
		
	}
	
	private void displayOptions()
	{
		int index;
		int xPos=100;
		int yPos=100;
		final int MAXCHOICE=3; 
		
		
		
		String arrOrderCaptions[]={"Ascending","Descending"};
		for(index=0;index<MAXCHOICE-1;index++)
		{
			arrNameOptions[index]=new Checkbox();
			arrNameOptions[index].setLabel(arrOrderCaptions[index]);
			arrNameOptions[index].setBounds(xPos, yPos, 100, 30);
			arrNameOptions[index].setCheckboxGroup(groupName);
			add(arrNameOptions[index]);
			xPos+=110;
		}
		
		xPos=100;
		yPos=100;
		String arrOrderCaption[]={"Manager","Sales Person","Engineer"};
		for(index=0;index<MAXCHOICE;index++)
		{
			arrDesignationOptions[index]=new Checkbox();
			arrDesignationOptions[index].setLabel(arrOrderCaption[index]);
			arrDesignationOptions[index].setBounds(xPos, yPos, 100, 30);
			arrDesignationOptions[index].setCheckboxGroup(groupDesignation);
			arrDesignationOptions[index].setVisible(false);
			add(arrDesignationOptions[index]);
			xPos+=110;
		}
			
		
	
	}
	
	
}
