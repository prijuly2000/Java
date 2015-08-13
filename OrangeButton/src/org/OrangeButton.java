package org;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

public class OrangeButton extends Canvas
{
	String caption;
	Vector <OrangeListener> receivers=new Vector<>();
	public OrangeButton()
	{
		this.caption = "Click";
		setSize(60,20);
		setBackground(Color.orange);
		addMouseListener(new MouseHandler());
	}
	public String getCaption()
	{
		return caption;
	}
	public void setCaption(String caption)
	{
		this.caption = caption;
		repaint();
	}
	@Override
	public void paint(Graphics grp)
	{
		grp.drawString(caption, 5,12);
	}
	
	public void addOrangeListener(OrangeListener ol)
	{
		receivers.add(ol);
	}
	
	public void removeOrangeListener(OrangeListener ol)
	{
		receivers.remove(ol);
	}
}
