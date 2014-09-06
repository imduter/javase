package com.appspot.zcloud;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 将个体Rectangle（）的宽与高改为图片宽高后，出现bug
 * bug:当敌方坦克被消灭后，重生出现在右上角
 * 原因：未知
 * 
 * */
public class TankClient extends Frame 
{
	
	Image offScreen = null;
	
	public static final int ClientW = 800;
	public static final int ClientH = 600;

	//初始化我方坦克属性：位置，持有门户，好坏，方向
	Tank myTank = new Tank(50, 50, this, true, Direction.STOP);
	List<Missile> missiles = new ArrayList<Missile>();
	List<Tank> tanks = new ArrayList<Tank>();
	List<Explode> explodes = new ArrayList<Explode>();
	
	//墙体1
	Wall w1 = new Wall(100, 200, 50, 300);
	//墙体2
	Wall w2 = new Wall(300, 200, 300, 50);
	//回血物
	BleedBackItem bbi = new BleedBackItem(this);

	/**
	 * 
	 * 用于添加敌方坦克
	 * */
	private void addTanks()
	{
		for(int i = 0; i < PropertiesMgr.getProperty("initTankCount"); i++)
		{
			tanks.add(new Tank(100+60*i, 50, this, false, Direction.DOWN));
		}
	}
	
	/**
	 * 初始化窗口
	 * 
	 * */
	private void launchClient()
	{
		this.setTitle("TankWar");
		this.setBounds(300, 100, ClientW, ClientH);
		this.setBackground(Color.BLACK);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyMonitor());
		this.setVisible(true);
		RefreshClient rc = new RefreshClient();
		addTanks();
		rc.start();
	}

	/**
	 * 窗体绘制
	 * */
	public void paint(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		//各物体状态显示
		g.drawString("missiles:"+missiles.size(), 10, 40);
		g.drawString("explodes:"+explodes.size(), 10, 60);
		g.drawString("tanks:"+tanks.size(), 10, 80);
		g.drawString("life:"+myTank.getLife(), 10, 100);
		g.setColor(c);
		
		//添加敌坦
		if(tanks.size() <= 0)
		{
			addTanks();
		}

		
		w1.draw(g);
		w2.draw(g);
		
		myTank.collidesWithWall(w1);
		myTank.collidesWithWall(w2);
		myTank.eat(bbi);
		bbi.draw(g);
		myTank.draw(g);
		//拿出每辆敌坦，撞墙，撞坦，然后画出
		for(int i = 0; i < tanks.size(); i++)
		{
			Tank t = tanks.get(i);
			t.collidesWithWall(w1);
			t.collidesWithWall(w2);
			t.collidesWithTanks(tanks);
			
			t.draw(g);
		}
		//拿出每棵子弹打击每辆坦克以及墙体
		for(int i = 0; i < missiles.size(); i++)
		{
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.hitTank(myTank);
			m.hitWall(w1);
			m.hitWall(w2);
			m.draw(g);
		}
		//画出爆炸
		for(int i = 0; i < explodes.size(); i++)
		{
			Explode e = explodes.get(i);
			e.draw(g);
		}
	}
	
	/**
	 * 双缓冲，解决闪烁
	 * 
	 * */
	public void update(Graphics g)
	{
		if(offScreen == null)
		{
			offScreen = this.createImage(ClientW, ClientH);
		}
		Graphics goffScreen = offScreen.getGraphics();
		Color c = g.getColor();
		goffScreen.setColor(Color.BLACK);
		goffScreen.fillRect(0, 0, ClientW, ClientH);
		goffScreen.setColor(c);
		paint(goffScreen);
		g.drawImage(offScreen, 0, 0, null);
	}

	/**
	 * 刷新窗口线程
	 * 
	 * */
	private class RefreshClient extends Thread
	{
		public void run()
		{
			while(true)
			{
				repaint();
				try
				{
					sleep(50);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 事件监听
	 * */
	private class KeyMonitor extends KeyAdapter
	{
		public void keyReleased(KeyEvent e)
		{
			myTank.keyReleased(e);
		}
		public void keyPressed(KeyEvent e)
		{
			myTank.keyPressed(e);
		}
	}

	public static void main(String[] args)
	{
		TankClient tc = new TankClient();
		tc.launchClient();
	}
	
}
