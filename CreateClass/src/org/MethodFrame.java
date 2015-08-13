package org;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MethodFrame extends Frame
{
	TextField arrTextField[]=new TextField[1];
	List lstDataMember=new List();
	Choice chType=new Choice();
	MainFrame frm;
	CheckboxGroup group=new CheckboxGroup();
	public MethodFrame(MainFrame frm)
	{
		this.frm=frm;
		System.out.println("MEthod Frame");
		setBounds(200, 0, 500, 500);
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
		String lblCaptions[]={"Name : ","Access : ","Return Type: ","Parameters : "};
		
		int xPos=30;
		int yPos=50;
		
		arrTextField[0]=new TextField();
		arrTextField[0].setBounds(xPos+90, yPos, 100, 20);
		add(arrTextField[0]);
		
		chType.setBounds(120, 155, 100, 20);
		chType.add("void");
		chType.add("int");
		chType.add("float");
		chType.add("char");
		chType.add("String");
		chType.add("double");
		add(chType);		
		
		for(int index=0;index<4;index++)
		{
			arrLabels[index]=new Label(lblCaptions[index]);
			arrLabels[index].setBounds(xPos, yPos, 70, 30);
			add(arrLabels[index]);
			
			yPos+=50;
			if(index>=3)
				yPos+=50;
		}
		
		
		
		String []accessCaptions={"private","protected","default","public"};
		
		
		Checkbox arrCheckBox[]=new Checkbox[4];
		for(int index=0;index<4;index++)
		{
				arrCheckBox[index]=new Checkbox(accessCaptions[index]);
				arrCheckBox[index].setBounds(xPos+90, 105, 70, 30);
				arrCheckBox[index].setCheckboxGroup(group);
				add(arrCheckBox[index]);
				xPos+=100;
		}	
		
		
		
		lstDataMember.setBounds(120, 200, 200, 100);
		add(lstDataMember);
				
		yPos=180;
		Button []arrButton=new Button[3];
		MethodHandler handler=new MethodHandler();
		String arrBtnCaptions[]={"Add","Remove","Close"};
		//String btnNames[]={"dataMemberAdd","dataMemberRemove","methodAdd","methodRemove"};
		int index;
		for(index=0;index<3;index++)
		{
			arrButton[index]=new Button(arrBtnCaptions[index]);
			arrButton[index].setBounds(360,yPos+20 , 100, 30);
			arrButton[index].addActionListener(handler);
			//arrButton[index].setName(btnNames[index]);
			add(arrButton[index]);
			
			yPos+=60;
		}
		
		
		
		setVisible(true);
	}
}
