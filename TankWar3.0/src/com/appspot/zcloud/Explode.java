package com.appspot.zcloud;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * ��ը��
 * */
public class Explode
{
	int x, y;
	boolean live = true;
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	//����Ϊ��̬,��Ȼÿ��new������������
	//�������
	//Class��Ϊ�Ե�ǰ�������Ϣ������
	private static Image images[] = {
		tk.getImage(Explode.class.getClassLoader().getResource("images/explode0.png")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/explode1.png")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/explode2.png")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/explode3.png")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/explode4.png")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/explode5.png")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/explode6.png")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/explode7.png")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/explode8.png")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/explode9.png")),
	};
	
	TankClient tc;
	int step = 0;
	
	private boolean init = false;
	
	public Explode(int x, int y, TankClient tc) 
	{
		this.x = x;
		this.y = y;
		this.tc = tc;
	}
	
	void draw(Graphics g)
	{
		//������ͼƬ�Ȼ�һ�Σ�����⣡
		if(!init)
		{
			for (int i = 0; i < images.length; i++)
			{
				g.drawImage(images[i], -100, -100, null);
			}
			init = true;
		}
		
		if(!live)
		{
			tc.explodes.remove(this);
			return;
		}	
		if(step == images.length)
		{
			this.setLive(false);
			step = 0;
			return;
		}
		//�첽IO
		g.drawImage(images[step], x, y, null);
		step++;
		
	}
	boolean isLive() 
	{
		return live;
	}

	void setLive(boolean live)
	{
		this.live = live;
	}
}
