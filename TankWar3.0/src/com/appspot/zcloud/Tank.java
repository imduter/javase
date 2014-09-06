package com.appspot.zcloud;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Tank 
{
	/**
	 * x方向速度
	 * */
	public static final int XSPEED = 5;
	/**
	 * y方向速度
	 * */
	public static final int YSPEED = 5;
	
	int x, y;
	/**
	 * 存储坦克前一次位置的变量
	 * */
	int oldX, oldY;
	boolean bU, bD, bL, bR;

	/*
	 * 炮筒方向
	 * */
	Direction ptDir = Direction.DOWN;
	TankClient tc;
	
	private boolean good;
	
	private int life = 100;
	BloodBar bb = new BloodBar();
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image TankImages[] = null;
	private static Map<String, Image> images = new HashMap<String, Image>();
	//静态代码区,常用于初始化变量
	static 
	{
		TankImages = new Image[]{
			tk.getImage(Tank.class.getClassLoader().getResource("images/TankUP.png")),
			tk.getImage(Tank.class.getClassLoader().getResource("images/TankDOWN.png")),
			tk.getImage(Tank.class.getClassLoader().getResource("images/TankLEFT.png")),
			tk.getImage(Tank.class.getClassLoader().getResource("images/TankRIGHT.png")),
			tk.getImage(Tank.class.getClassLoader().getResource("images/TankLUP.png")),
			tk.getImage(Tank.class.getClassLoader().getResource("images/TankLDOWN.png")),
			tk.getImage(Tank.class.getClassLoader().getResource("images/TankRUP.png")),
			tk.getImage(Tank.class.getClassLoader().getResource("images/TankRDOWN.png")),
			};
		images.put("UP", TankImages[0]);
		images.put("DOWN", TankImages[1]);
		images.put("LEFT", TankImages[2]);
		images.put("RIGHT", TankImages[3]);
		images.put("LUP", TankImages[4]);
		images.put("LDOWN", TankImages[5]);
		images.put("RUP", TankImages[6]);
		images.put("RDOWN", TankImages[7]);
	}
	public static final int W = 30;
	public static final int H = 30;
	
	/**
	 * 返回坦克好坏
	 * */
	boolean isGood()
	{
		return good;
	}

	/**
	 * */
	private void setGood(boolean good)
	{
		this.good = good;
	}

	private boolean live = true;
	
	private static Random rd = new Random();
	/**
	 * 坏坦克向某方向移动的步伐。
	 * */
	private int step = rd.nextInt(12)+3;

	Direction dir = Direction.STOP;

	public Tank(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
		
	public Tank(int x, int y, TankClient tc, boolean good, Direction dir)
	{
		this(x, y);			
		this.tc = tc;
		this.good = good;
		this.dir = dir;
	}
	
	void draw(Graphics g)
	{
		if(!live)
		{
			if(!good)
			{
				tc.tanks.remove(this);
			}
			return;
		}
		
		if(isGood())
		{
			bb.draw(g);
		}
		
		move();
		g.setColor(Color.WHITE); 
		 switch(ptDir)
		 {
			case UP:
				g.drawImage(images.get("UP"), x, y, null);
				break;
			case LUP:
				g.drawImage(images.get("LUP"), x, y, null);
				break;
			case RUP:
				g.drawImage(images.get("RUP"), x, y, null);
				break;
			case DOWN:
				g.drawImage(images.get("DOWN"), x, y, null);
				break;
			case LDOWN:
				g.drawImage(images.get("LDOWN"), x, y, null);
				break;
			case RDOWN:
				g.drawImage(images.get("RDOWN"), x, y, null);
				break;
			case LEFT:
				g.drawImage(images.get("LEFT"), x, y, null);
				break;
			case RIGHT:
				g.drawImage(images.get("RIGHT"), x, y, null);
				break;
			}
	}
	
	void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		switch(key)
		{
			case KeyEvent.VK_F2:
				if(!this.isLive())
				{
					this.setLive(true);
					this.setLife(100);
				}
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
		}
		locationDirection();
	}
	
	void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		switch(key)
		{
			case KeyEvent.VK_CONTROL:
				fire();	
				break;
			case KeyEvent.VK_A:
				superFire();
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
		}
		locationDirection();
	}

	/**
	 * 通过的按键的处理获得坦克方向。
	 * */
	void locationDirection()
	{
		if(bU && !bD && !bL && !bR)
			dir = Direction.UP;
		else if(bU && !bD && bL && !bR)
			dir = Direction.LUP;
		else if(bU && !bD && !bL && bR)
			dir = Direction.RUP;
		else if(!bU && bD && !bL && !bR)
			dir = Direction.DOWN;
		else if(!bU && bD && bL && !bR)
			dir = Direction.LDOWN;
		else if(!bU && bD && !bL && bR)
			dir = Direction.RDOWN;
		else if(!bU && !bD && bL && !bR)
			dir = Direction.LEFT;
		else if(!bU && !bD && !bL && bR)
			dir = Direction.RIGHT;
		else
			dir = Direction.STOP;
	}
	
	void move()
	{
		oldX = x;
		oldY = y;
		
		switch(dir)
		{
			case UP:
				y -= YSPEED;
				break;
			case LUP:
				y -= YSPEED;
				x -= XSPEED;
				break;
			case RUP:
				y -= YSPEED;
				x += XSPEED;
				break;
			case DOWN:
				y += YSPEED;
				break;
			case LDOWN:
				y += YSPEED;
				x -= XSPEED;
				break;
			case RDOWN:
				y += YSPEED;
				x += XSPEED;
				break;
			case LEFT:
				x -= YSPEED;
				break;
			case RIGHT:
				x += YSPEED;
				break;
			case STOP:
				break;
		}
		
		if(dir != Direction.STOP) ptDir = dir;
		
		if(x < 0) x = 0;
		if(y < 20) y = 20;
		if(x > TankClient.ClientW-TankImages[0].getWidth(null))		x = TankClient.ClientW-TankImages[0].getWidth(null);
		if(y > TankClient.ClientH-TankImages[0].getHeight(null)) y = TankClient.ClientH-TankImages[0].getHeight(null);
		
		//坏坦克，每行走完一定步骤后，改变方向。
		if(!good)
		{
			Direction dirs[] = Direction.values();
			if(step == 0)
			{
				step = rd.nextInt(12)+3;
				dir = dirs[rd.nextInt(dirs.length)];
			}
			step--;
			if(rd.nextInt(100) < 5)
			{
				fire();
			}
		}
	}

	/**
	 * 开火
	 * */
	Missile fire()
	{
		if(!live) return null;
		Missile m = new Missile(x+(W-Missile.W)/2, y+(H-Missile.H)/2, ptDir, this.tc, good);
		tc.missiles.add(m);
		return m;
	}
	/**
	 * 具备方向性开火，用于制作超级武器
	 * */
	Missile fire(Direction dir)
	{
		if(!live) return null;
		Missile m = new Missile(x+(W-Missile.W)/2, y+(H-Missile.H)/2, dir, this.tc, good);
		tc.missiles.add(m);
		return m;
	}
	
	/**
	 * 超级武器，八方开火。
	 * */
	void superFire()
	{
		Direction dirs[] = Direction.values();
		for(int i = 0; i < dirs.length-1; i++)
		{
			fire(dirs[i]);
		}
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
	
	Rectangle getRectangle()
	{
		return new Rectangle(x, y, TankImages[0].getWidth(null), TankImages[0].getHeight(null));
	}
	/**
	 * 与墙相撞
	 * */
	public void collidesWithWall(Wall w)
	{
		if(this.isLive() && w.getRectangle().intersects(this.getRectangle()))
		{
			stay();
		}
	}
	
	public void collidesWithTanks(List<Tank> tanks)
	{
		for(int i = 0; i < tanks.size(); i++)
		{
			Tank t = tanks.get(i);
			if(this != t)
			{
				if(this.isLive() && t.isLive() && this.getRectangle().intersects(t.getRectangle()))
				{
					this.stay();
					t.stay();
				}
			}
		}
	}
	
	/**
	 * 
	 * 返回坦克上一次位置
	 * */
	public void stay()
	{
		x = oldX;
		y = oldY;
	}

	int getLife() {
		return life;
	}

	void setLife(int life) {
		this.life = life;
	}
	/**
	 * 吃回血物方法
	 * */
	void eat(BleedBackItem bbi)
	{
		if(this.isLive() && bbi.isLive() && this.getRectangle().intersects(bbi.getRectangle()))
		{
			bbi.setLive(false);
			this.setLife(100);
		}
	}
	/**
	 * 坦克顶部小血条
	 * */
	private class BloodBar
	{
		void draw(Graphics g)
		{
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.drawRect(x, y-10, TankImages[0].getWidth(null), 10);
			g.fillRect(x, y-10, TankImages[0].getWidth(null)*life/100, 10);
			g.setColor(c);
		}
	}	
}