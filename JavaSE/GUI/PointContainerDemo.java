//PointContainerDemo.java

import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class PointContainerDemo
{
	public static void main(String args[])
	{
		new MyFrame("drawing...");
	}
}

class MyFrame extends Frame
{

	ArrayList points = new ArrayList();
	public MyFrame(String s)
	{
		super(s);
		setBounds(300, 100, 400, 300);
		setBackground(Color.blue);
		addMouseListener(new MyMouseAdapter());
		setVisible(true);
	}
	
	public void paint(Graphics g)//这种神奇的画笔由系统传来
	{
		Iterator i = points.iterator();
		while(i.hasNext())
		{
			Point p = (Point)i.next();
			g.setColor(Color.BLACK);
			g.fillOval(p.x, p.y, 20, 20);
		}
	}
	public void addPoint(Point p)
	{
		points.add(p);
	}
}

class MyMouseAdapter extends MouseAdapter
{
	public void mousePressed(MouseEvent e)
	{
		MyFrame mf = (MyFrame)e.getSource();
		mf.addPoint(new Point(e.getX(), e.getY()));
		mf.repaint();
	}
}