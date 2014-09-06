package com.appspot.zcloud;

import java.awt.*;
import java.util.*;
/**
 * »ØÑªÀà
 * */
public class BleedBackItem
{
	public static final int width = 20;
	public static final int height = 20;
	
	Random rd = new Random();
	TankClient tc;
	
	int x, y;
	int appearTime = 200;
	
	private boolean live = true;
	
	BleedBackItem(TankClient tc)
	{
		this.tc = tc;
		x = rd.nextInt(tc.ClientW);
		y = rd.nextInt(tc.ClientH);
	}
	
	void draw(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		if(isLive() && appearTime >= 100)
		{
			g.fillRect(x, y, width, height);
		}
		g.setColor(c);
		appearTime--;
		if(appearTime == 0)
		{
			this.setLive(true);
			appearTime = 200;
			x = rd.nextInt(tc.ClientW);
			y = rd.nextInt(tc.ClientH);
		}
	}

	Rectangle getRectangle()
	{
		return new Rectangle(x, y, width, height);
	}
	
	boolean isLive() {
		return live;
	}

	void setLive(boolean live) {
		this.live = live;
	}
}
