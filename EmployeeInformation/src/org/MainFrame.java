package org;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;


import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import edu.utility.Linklist;

public class MainFrame extends Frame
{
	final int TXTNAME=0;
	final int TXTAGE=1;
	final int TXTBASICSALARY=2;
	final int TXTCOMMON=3;
	
	Linklist objLinklist=new Linklist();
	final int MAXALLOWANCE=2;
	final int MAXTEXTFIELDS=4;
	TextField [] arrTextFields=new TextField[MAXTEXTFIELDS];
	Checkbox [] arrAllowance=new Checkbox[MAXALLOWANCE];
	Checkbox [] arrGender=new Checkbox[2];
	TextArea txtAddress;
	Choice chDesignation;
	CheckboxGroup group;
	
	public MainFrame()
	{
		
		setBounds(100,100,400,600);
		setLayout(null);
		setTitle("Employee");
		
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});
		
		Label lblHeader= new Label("Employee Information");
		lblHeader.setBounds(100,40,300,30);
		add(lblHeader);
		
		int xPos=20;
		int yPos=75;
		int heightLabel=50;
		int widthLabel=100;
		int xposTxtField=120;
		int []arrYPosTxtField={90,180,270,300};
		int widthTxtField=150;
		int heightTxtField=20;
		
		String [] labelCaptions={"Employee Information","Name:","Address:","Age:","Gender:","Designation:","Basic Salary:","HRA/OT/Comm:","Allowance:"};
		Label [] arrLabels=new Label[9];
		int index;	
		
		
		//Adding labels
		for(index=1;index<9;index++)
		{
			arrLabels[index]=new Label(labelCaptions[index]);
			if(index==2)
			{			
				arrLabels[2].setBounds(xPos, yPos,widthLabel,heightLabel);
				yPos+=30;
			}
			else
				arrLabels[index].setBounds(xPos,yPos,widthLabel,heightLabel);
			
			add(arrLabels[index]);
			yPos+=30;
		}
		//Adding Textfields
		for(index=0;index<4;index++)
		{
			arrTextFields[index]=new TextField();
			arrTextFields[index].setBounds(xposTxtField, arrYPosTxtField[index], widthTxtField, heightTxtField);
			add(arrTextFields[index]);
			
		}
		
		//Adding Textarea 	
		txtAddress=new TextArea();
		txtAddress.setBounds(120, 115, 150, 60);
		add(txtAddress);
		
		//Adding Radio buttons		
		group=new CheckboxGroup();
		
		xPos=120;
		yPos=205;
		String []arrGenders={"Male","Female"};
		
		for(index=0;index<2;index++)
		{
			arrGender[index]=new Checkbox(arrGenders[index]);
			arrGender[index].setBounds(xPos, yPos, 70, 30);
			arrGender[index].setCheckboxGroup(group);
			add(arrGender[index]);
			xPos+=70;
		}
		//Adding Choice				
		chDesignation=new Choice();
		chDesignation.setBounds(120, 240, 150, 30);
		add(chDesignation);
		chDesignation.add("Manager");
		chDesignation.add("Sales Person");
		chDesignation.add("Engineer");
		
		//Adding check boxes
		String []arrAllowanceCaptions={"Travelling","Food"};
		xPos=120;
		yPos=330;
		for(index=0;index<MAXALLOWANCE;index++)
		{
			arrAllowance[index] = new Checkbox(arrAllowanceCaptions[index]);
			arrAllowance[index].setBounds(xPos, yPos, 100, 20);
			add(arrAllowance[index]);
			xPos+=100;
		}
		//Adding buttons
     	xPos=40;
		yPos=350;
		final int MAXBUTTONS=12;
		Button [] arrButtons=new Button[12]; 
		String [] buttonCaptions={"Add","Delete","Update","Sort","First","Previous","Next","Last","Save","Load","Transfer","Exit"};
		
		ButtonHandler handler=new ButtonHandler();
		for( index=0;index<MAXBUTTONS;index++)
		{
			if(index%4==0)
			{
				yPos+=50;
				xPos=40;
			}
			else
				xPos+=60;
			
			arrButtons[index]=new Button(buttonCaptions[index]);
			arrButtons[index].setBounds(xPos, yPos, 55, 30);
			arrButtons[index].addActionListener(handler);			
			add(arrButtons[index]);
		}
		
		setVisible(true);
	}
	
}
