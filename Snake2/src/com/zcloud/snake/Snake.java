package com.zcloud.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


/**
 * 单向链表
 * 
 * */
public class Snake 
{
	
	private Node head;
	private Node tail;
	private int size;
	private Node node = new Node(20, 30, Dir.DOWN);
	private Yard yard;
	
	public Snake(Yard yard)
	{
		head = node;
		tail = node;
		size = 1;
		this.yard = yard;
	}
	
	private void addToTail()
	{
		Node node = null;
		switch(tail.dir)
		{
		case UP:
			node = new Node(tail.row + 1, tail.col, tail.dir);
			break;
		case DOWN:
			node = new Node(tail.row - 1, tail.col, tail.dir);
			break;
		case LEFT:
			node = new Node(tail.row, tail.col + 1, tail.dir);
			break;			
		case RIGHT:
			node = new Node(tail.row, tail.col - 1, tail.dir);
			break;
		}
		//将新new出来的node实例添加到tail后
		tail.next = node;
		//尾巴变成新node之前段
		node.prev = tail;
		//新的tail就为新new出来的node
		tail = node;
		size++;
	}

	private void addToHead()
	{
		Node node = null;
		switch(head.dir)
		{
		case UP:
			node = new Node(head.row - 1, head.col, head.dir);
			break;
		case DOWN:
			node = new Node(head.row + 1, head.col, head.dir);
			break;
		case LEFT:
			node = new Node(head.row, head.col - 1, head.dir);
			break;			
		case RIGHT:
			node = new Node(head.row, head.col + 1, head.dir);
			break;
		}
		node.next = head;
		head.prev = node;
		head = node;
		size++;
	}
	
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		//蛇的方向为蛇头的方向
		switch(key)
		{
		case KeyEvent.VK_UP:
			//使蛇不能掉头,除DOWN这种情况不能向上，其他情况都能向上
			if(head.dir != Dir.DOWN)
				head.dir = Dir.UP;
			break;
		case KeyEvent.VK_DOWN:
			if(head.dir != Dir.UP)	
				head.dir = Dir.DOWN;
			break;
		case KeyEvent.VK_LEFT:
			if(head.dir != Dir.RIGHT)
				head.dir = Dir.LEFT;
			break;
		case KeyEvent.VK_RIGHT:
			if(head.dir != Dir.LEFT)
				head.dir = Dir.RIGHT;
			break;
		}
	}
	
	public void draw(Graphics g)
	{
		if(size <= 0)	return;

		move();
		//从蛇头一直到蛇尾
		for(Node n = head; n != null; n = n.next)
		{
			n.draw(g);
		}
		
	}
	
	private void move()
	{
		//蛇的移动相当于将蛇尾接到蛇头，再将蛇尾移出
		addToHead();
		removeFromTail();
		checkLife();
	}

	private void checkLife() 
	{
		if(head.col < 0+1 || head.col > Yard.COLS-1 || head.row < 0+3 || head.row > Yard.ROWS-3)
		{
			yard.stop();
		}
		
		for(Node n = head.next; n != null; n = n.next)
		{
			if(head.col == n.col && head.row == n.row)
			{
				yard.stop();
			}
		}
	}

	//改为双向链表
	private void removeFromTail()
	{
		if(size == 0)	return;
		tail = tail.prev;
		tail.next = null;
	}

	public void eat(Egg e)
	{
		if(this.getRectangle().intersects(e.getRectangle()))
		{
			this.addToHead();
			e.reAppear();
			yard.score += 10;
		}
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle(head.col * Yard.BLOCK_SIZE, head.row * Yard.BLOCK_SIZE, head.w, head.h);
	}
	
	private class Node
	{
		
		private int row, col;
		private int w = Yard.BLOCK_SIZE;
		private int h = Yard.BLOCK_SIZE;
		
		Dir dir = Dir.DOWN;
		Node next;
		Node prev;
		
		private Node(int row, int col, Dir dir) 
		{
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		
		public void draw(Graphics g)
		{
			Color c = g.getColor();
			g.setColor(Color.BLACK);
			//此处错误,导致按键出错
			g.fillRect(col * Yard.BLOCK_SIZE, row * Yard.BLOCK_SIZE, w, h);
			g.setColor(c);
		}
		
	}
	
}
