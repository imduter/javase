package com.zcloud.snake;

import java.awt.*;
import java.awt.event.*;

public class Yard extends Frame
{

	public static final int ROWS = 50;
	public static final int COLS = 50;
	public static final int BLOCK_SIZE = 10;
	private boolean gameOver = false;

	private RefreshThread rt = new RefreshThread();
	
	int score;
	
	Snake snake = new Snake(this);
	Egg egg = new Egg();
	
	Image offScreen;
	
	private void launch()
	{
		this.setLocation(600, 100);
		//�д�����y�� �д�����x
		this.setSize((COLS-1) * BLOCK_SIZE , (ROWS-1) * BLOCK_SIZE);
		this.setBackground(Color.gray);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			
		});
		this.addKeyListener(new KeyMonitor());
		this.setResizable(false);
		new Thread(rt).start();
	}
	

	//�������Yard��Ϊ�ɼ����˷�������ִ��
	//�˷���Ҳ�����������߳���ѭ��
	@Override
	public void paint(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		for(int i = 0; i < ROWS; i++)
		{
			g.drawLine(0, i * BLOCK_SIZE, (ROWS-1) * BLOCK_SIZE, i * BLOCK_SIZE);
		}
		for(int i = 0; i < COLS; i++)
		{
			g.drawLine(i * BLOCK_SIZE, 0, i * BLOCK_SIZE, (COLS-1) * BLOCK_SIZE);
		}
		
		g.setColor(Color.yellow);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		g.drawString("score: " + score, 10, 50);
		if(gameOver)
		{
			g.drawString("GAME OVER", 200, 200);
			g.drawString("F2 to restart", 100, 300);
			rt.pause();
		}
		g.setColor(c);
		
		snake.draw(g);
		snake.eat(egg);
		egg.draw(g);

	}

	@Override
	public void update(Graphics g) 
	{
		if(offScreen == null)
			offScreen = this.createImage((COLS-1) * BLOCK_SIZE , (ROWS-1) * BLOCK_SIZE);
		//ͼƬ�����õ�ϵͳ��֧���������滭�Լ��ġ�
		Graphics gOffScreen = offScreen.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.gray);
		gOffScreen.fillRect(0, 0, (COLS-1) * BLOCK_SIZE , (ROWS-1) * BLOCK_SIZE);
		gOffScreen.setColor(c);
		//����n�ﻭ��n��
		paint(gOffScreen);
		g.drawImage(offScreen, 0, 0, null);
	}
	
	public void stop()
	{
		gameOver = true;
		/*repaint();
		 * �˷�����ʹstop�ᱻһֱ���ö�ִ��
		 * ����if���ܱ��浱ǰ���档
		 * ����ȡ�� 
		 * */
	}
	
	private class RefreshThread implements Runnable
	{
		
		private boolean running = true;
		private boolean pause = false;

		@Override
		public void run() 
		{
			while(running)
			{
				if(pause)	continue;
				else	repaint();
				try
				{
					Thread.sleep(100);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		public void pause()
		{
			this.pause = true;
		}
		
		public void reStart()
		{
			this.pause = false;
			snake = new Snake(Yard.this);
			gameOver = false;
			egg.reAppear();
			Yard.this.score = 0;
		}
		
		public void gameOver()
		{
			running = false;
		}
		
	}
	
	private class KeyMonitor extends KeyAdapter
	{

		@Override
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_F2)
				rt.reStart();
			snake.keyPressed(e);
		}
		
	}
	
	public static void main(String args[])
	{
		new Yard().launch();
	}
	
}
