package com.appspot.zcloud;

import java.awt.*;

/**
 * 
 * «ΩÃÂ¿‡
 * */
public class Wall 
{
	Wall(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	private int x, y;
	private int width, height;
	
	void draw(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
		g.setColor(c);
	}
	
	Rectangle getRectangle()
	{
		return new Rectangle(x, y, width, height);
	}
}
