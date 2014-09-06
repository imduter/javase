package com.zcloud.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Egg
{

	private static int w = Yard.BLOCK_SIZE;
	private static int h = Yard.BLOCK_SIZE;
	
	private static Random rd = new Random();
	
	private int col = rd.nextInt(Yard.COLS - 2) + 2;
	private int row = rd.nextInt(Yard.ROWS - 4) + 4;
	
	public void draw(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.green);
		g.fillOval(col * Yard.BLOCK_SIZE, row * Yard.BLOCK_SIZE, w, h);
		g.setColor(c);
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle(this.col * Yard.BLOCK_SIZE, this.row * Yard.BLOCK_SIZE, w, h);
	}

	public void reAppear() 
	{
		col = rd.nextInt(Yard.COLS - 1) + 1;
		row = rd.nextInt(Yard.ROWS - 3) + 3;
	}
	
}
