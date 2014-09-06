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
 * ������Rectangle�����Ŀ���߸�ΪͼƬ��ߺ󣬳���bug
 * bug:���з�̹�˱�������������������Ͻ�
 * ԭ��δ֪
 * 
 * */
public class TankClient extends Frame 
{
	
	Image offScreen = null;
	
	public static final int ClientW = 800;
	public static final int ClientH = 600;

	//��ʼ���ҷ�̹�����ԣ�λ�ã������Ż����û�������
	Tank myTank = new Tank(50, 50, this, true, Direction.STOP);
	List<Missile> missiles = new ArrayList<Missile>();
	List<Tank> tanks = new ArrayList<Tank>();
	List<Explode> explodes = new ArrayList<Explode>();
	
	//ǽ��1
	Wall w1 = new Wall(100, 200, 50, 300);
	//ǽ��2
	Wall w2 = new Wall(300, 200, 300, 50);
	//��Ѫ��
	BleedBackItem bbi = new BleedBackItem(this);

	/**
	 * 
	 * ������ӵз�̹��
	 * */
	private void addTanks()
	{
		for(int i = 0; i < PropertiesMgr.getProperty("initTankCount"); i++)
		{
			tanks.add(new Tank(100+60*i, 50, this, false, Direction.DOWN));
		}
	}
	
	/**
	 * ��ʼ������
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
	 * �������
	 * */
	public void paint(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		//������״̬��ʾ
		g.drawString("missiles:"+missiles.size(), 10, 40);
		g.drawString("explodes:"+explodes.size(), 10, 60);
		g.drawString("tanks:"+tanks.size(), 10, 80);
		g.drawString("life:"+myTank.getLife(), 10, 100);
		g.setColor(c);
		
		//��ӵ�̹
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
		//�ó�ÿ����̹��ײǽ��ײ̹��Ȼ�󻭳�
		for(int i = 0; i < tanks.size(); i++)
		{
			Tank t = tanks.get(i);
			t.collidesWithWall(w1);
			t.collidesWithWall(w2);
			t.collidesWithTanks(tanks);
			
			t.draw(g);
		}
		//�ó�ÿ���ӵ����ÿ��̹���Լ�ǽ��
		for(int i = 0; i < missiles.size(); i++)
		{
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.hitTank(myTank);
			m.hitWall(w1);
			m.hitWall(w2);
			m.draw(g);
		}
		//������ը
		for(int i = 0; i < explodes.size(); i++)
		{
			Explode e = explodes.get(i);
			e.draw(g);
		}
	}
	
	/**
	 * ˫���壬�����˸
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
	 * ˢ�´����߳�
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
	 * �¼�����
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
