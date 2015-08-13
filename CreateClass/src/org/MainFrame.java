package org;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame
{
	MethodFrame methodFrm; 
	String method;
	String btnName;
	TextField arrTextField[]=new TextField[2];
	final static int TXTPACKAGE=0;
	final static int TXTCLASSNAME=1;
	List lstDataMember=new List();
	CheckboxGroup group=new CheckboxGroup();
	List lstMethod=new List();
	public MainFrame()
	{
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
			
		});
		
		Label arrLabels[]=new Label[5];
		String lblCaptions[]={"Package : ","Class Name : ","Access : ","Data Members : ","Methods : "};
		int xPos=50;
		int yPos=50;
		for(int index=0;index<5;index++)
		{
			arrLabels[index]=new Label(lblCaptions[index]);
			arrLabels[index].setBounds(xPos, yPos, 100, 30);
			add(arrLabels[index]);
			if(index<2)
			{
				arrTextField[index]=new TextField();
				arrTextField[index].setBounds(xPos+100, yPos, 100, 20);
				add(arrTextField[index]);
			}
			yPos+=50;
			if(index>=3)
				yPos+=50;
		}
		
		String []accessCaptions={"default","public"};
		
		
		Checkbox arrCheckBox[]=new Checkbox[2];
		for(int index=0;index<2;index++)
		{
			arrCheckBox[index]=new Checkbox(accessCaptions[index]);
			arrCheckBox[index].setBounds(xPos+100, 155, 100, 20);
			arrCheckBox[index].setCheckboxGroup(group);
			add(arrCheckBox[index]);
			xPos+=100;
				
		}
		
		
		lstDataMember.setBounds(150, 180, 200, 100);
		add(lstDataMember);
		
		
		lstMethod.setBounds(150, 300, 200, 100);
		add(lstMethod);
		
		yPos=180;
		Button []arrButton=new Button[5];
		ButtonHandler handler=new ButtonHandler();
		String arrBtnCaptions[]={"Add","Remove","Add","Remove","Generate Class"};
		String btnNames[]={"dataMemberAdd","dataMemberRemove","methodAdd","methodRemove"};
		int index;
		for(index=0;index<4;index++)
		{
			arrButton[index]=new Button(arrBtnCaptions[index]);
			arrButton[index].setBounds(360,yPos , 100, 30);
			arrButton[index].setName(btnNames[index]);
			arrButton[index].addActionListener(handler);
			add(arrButton[index]);
			
			yPos+=60;
		}
		
		arrButton[index]=new Button(arrBtnCaptions[index]);
		arrButton[index].setBounds(160,yPos , 100, 30);
		arrButton[index].setName("GenerateClass");
		arrButton[index].addActionListener(handler);
		add(arrButton[index]);
		
		setVisible(true);
	}
}
