package com.appspot.zcloud;
/**
 * 
 * 子弹速度不能过快，否者要穿墙。
 * 
 * */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Missile
{	
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	public static final int W = 10;
	public static final int H = 10;
	
	public int x, y;
	Direction ptDir;
	TankClient tc;
	
	private boolean live = true;
	private boolean good;
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image missileImages[] = null;
	private static Map<String, Image> images = new HashMap<String, Image>(); 
	
	static
	{
		missileImages = new Image[]{
				tk.getImage(Missile.class.getClassLoader().getResource("images/MissileUP.png")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/MissileLUP.png")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/MissileRUP.png")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/MissileDOWN.png")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/MissileLDOWN.png")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/MissileRDOWN.png")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/MissileLEFT.png")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/MissileRIGHT.png")),
		};
		images.put("UP", missileImages[0]);
		images.put("LUP", missileImages[1]);
		images.put("RUP", missileImages[2]);
		images.put("DOWN", missileImages[3]);
		images.put("LDOWN", missileImages[4]);
		images.put("RDOWN", missileImages[5]);
		images.put("LEFT", missileImages[6]);
		images.put("RIGHT", missileImages[7]);
	}
	
	public Missile(int x, int y, Direction ptDir, TankClient tc, boolean good)
	{
		this.x = x;
		this.y = y;
		this.ptDir = ptDir;
		this.tc = tc;
		this.good = good;
	}
	
	void draw(Graphics g)
	{
		if(!live)
		{
			tc.missiles.remove(this);
			return;
		}
		
		switch(ptDir)
		{
			case UP:
				g.drawImage(images.get("UP"), x, y, null);
				y -= YSPEED;
				break;
			case LUP:
				g.drawImage(images.get("LUP"), x, y, null);
				y -= YSPEED;
				x -= XSPEED;
				break;
			case RUP:
				g.drawImage(images.get("RUP"), x, y, null);
				y -= YSPEED;
				x += XSPEED;
				break;
			case DOWN:
				g.drawImage(images.get("DOWN"), x, y, null);
				y += YSPEED;
				break;
			case LDOWN:
				g.drawImage(images.get("LDOWN"), x, y, null);
				y += YSPEED;
				x -= XSPEED;
				break;
			case RDOWN:
				g.drawImage(images.get("RDOWN"), x, y, null);
				y += YSPEED;
				x += XSPEED;
				break;
			case LEFT:
				g.drawImage(images.get("LEFT"), x, y, null);
				x -= YSPEED;
				break;
			case RIGHT:
				g.drawImage(images.get("RIGHT"), x, y, null);
				x += YSPEED;
				break;
		}
		/**
		 * 判断子弹是否越出窗体
		 * */
		if(x < 0 || y < 0 || x > TankClient.ClientW || y > TankClient.ClientH)
		{
			this.setLive(false);
		}
	}

	public boolean isLive()
	{
		return live;
	}

	public void setLive(boolean live)
	{
		this.live = live;
	}
	
	Rectangle getRectangle()
	{
		return new Rectangle(x, y, W, H);
	}
	
	/**
	 * 子弹打一辆坦克
	 * */
	public boolean hitTank(Tank t)
	{

		if(t.isLive() && this.isLive() && this.getRectangle().intersects(t.getRectangle()) && this.good != t.isGood())
		{
			if(t.isGood())
			{
				t.setLife(t.getLife()-20);
				if(t.getLife() <= 0) t.setLive(false);
			}
			else t.setLive(false);
			Explode e = new Explode(x, y, this.tc);
			tc.explodes.add(e);
			this.setLive(false);
			return true;
		}
			return false;
	}
	
	/**
	 * 子弹打多辆坦克
	 * */
	public void hitTanks(List<Tank> tanks)
	{
		//将集合中坦克取出
		for(int i = 0; i < tanks.size(); i++)
		{
			hitTank(tanks.get(i));
		}
	}

	/**
	 * 子弹打墙
	 * */
	public void hitWall(Wall w)
	{
		if(w.getRectangle().intersects(this.getRectangle()))
		{
			this.setLive(false);
		}
	}
	
	private boolean isGood()
	{
		return good;
	}

	private void setGood(boolean good)
	{
		this.good = good;
	}
}
