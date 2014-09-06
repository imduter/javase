package com.dreateam.app.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTextPane;


/**
 * @description TODO
 * @author zcloud
 * @date 2014年2月12日
 */
@SuppressWarnings("serial")
public class HexEditPane extends JTextPane
{
	private File file;
	private String hexStr = "";
	private StringBuffer strBuffer = new StringBuffer();
	
	
	HexEditPane(File file)
	{
		this.file = file;
		//top,left,bottom,right
		setMargin(new Insets(25, 0, 0, 300));
		read();
		setText(hexStr);
		Font font = new Font("宋体", Font.PLAIN, 20);
		setFont(font);
	}
	
	private void read()
	{
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file);
			int b = 0;
			int count = 0;
			long offset = 0;
			strBuffer.append("0|");
			while((b = fis.read()) != -1)
			{
				if(count == 16)
				{
					offset++;
					strBuffer.append("\n");
					strBuffer.append(Long.toHexString(offset) + "|");
					count = 0;
				}
				String hexStr = Integer.toHexString(b);
				if(hexStr.matches("[a-f1-9]"))
				{
					hexStr = "0" + hexStr;
				}
				strBuffer.append(hexStr + " ");
				count++;
			}
			hexStr = strBuffer.toString();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fis.close();
				fis = null;
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Color color = g.getColor();
		g.setColor(new Color(230, 230, 230));
		g.fillRect(0, 0, getSize().width, 25);
		g.setColor(Color.blue);
		Font font = new Font("宋体", Font.PLAIN, 20);
		g.setFont(font);
		g.drawString("offset|", 10, 20);
		g.drawString("0 1 2 3 4 5 6 7 8 9 A B C D E F|", 80, 20);
		g.drawString("ASCII", 400, 20);
		g.setColor(color);
	}
}
