package excel;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import edu.utility.Linklist;




public class MainFrame extends Frame
{ 
	ButtonHandler handler =new ButtonHandler();
	TextField txtPos;
	Linklist objList=new Linklist();
	int arrData[];
	//Cell objCell;
	public MainFrame() 
	{
		setLayout(null);
		setBounds(0,0,400,400);
		setVisible(true);                                                 
		setResizable(false);
		
		txtPos=new TextField();
		txtPos.setBounds(50,20,50,20);
		add(txtPos);
		
		Button btn=new Button("Bar chart");
		btn.setBounds(330, 30, 70, 30);
		add(btn);
		btn.addActionListener(handler);
		
		Button btn1=new Button("Pie chart");
		btn1.setBounds(330, 70, 70, 30);
		add(btn1);
		btn1.addActionListener(handler);
		
		addMouseListener(new MouseHandler());
		
		addWindowListener(new WindowAdapter()
		{
		@Override
		public void windowClosing(WindowEvent we)
		{
			dispose();
		}
		});
	}
	
	@Override
	public void paint(Graphics grp)
	{
		
	  for(int iTemp=0,xPos=50;iTemp<getHeight();iTemp++,xPos=xPos+50)
		  grp.drawLine(xPos, getHeight(),xPos, 20);
	 for(int iTemp=0,yPos=20;iTemp<getWidth();iTemp++,yPos=yPos+20)
		  grp.drawLine(0, yPos,getWidth(), yPos);
	    Cell objCell=(Cell)objList.getFirst();
	    while(objCell!=null)
	    {
	    	int xPos=objCell.getxPos();
	    	int yPos=objCell.getyPos();
	    	String data=objCell.getData();
	    	
	    	grp.drawString(data, xPos+15, yPos+15);
	    	objCell=(Cell)objList.getNext();
	    	int newXPos = xPos/50;
			
	    if(!data.equals(""))
			arrData[newXPos] += Integer.parseInt(data);
	    }
	    for(int iTemp=0,xPos=20;iTemp<8;iTemp++,xPos+=50)
		{
			grp.drawString(String.valueOf(arrData[iTemp]), xPos, 500);
		}
	

	
	
	
	for(int iTemp=0,xPos=20;iTemp<8;iTemp++,xPos+=50)
	{
		grp.drawString(String.valueOf(arrData[iTemp]), xPos, 500);
	}
}

}
