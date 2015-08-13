package org;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;


public class MainFrame extends Frame
{
	int width;
	int height;
	List<Button>arrButtons;
	
	public MainFrame(String title)
	{
		super(title);
		setLayout(new FlowLayout());
		
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		
	}
	public void initializeFrame()
	{
		setSize(width,height);
		if(arrButtons!=null)
		{
			Iterator<Button>iter=arrButtons.iterator();
			while(iter.hasNext())
				add(iter.next());
		}
		setVisible(true);
		
	}
	public int getWidth()
	{
		return width;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	public List<Button> getArrButtons()
	{
		return arrButtons;
	}
	public void setArrButtons(List<Button> arrButtons)
	{
		this.arrButtons = arrButtons;
	}
	

}
