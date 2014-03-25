	public void paint(Graphics g)
	{
		Iterator i = points.iterator();
		while(i.hasNext())
		{
			Point p = (Point)i.next();
			g.setColor(Color.blue);
			g.fillOval((int)p.getX(), (int)p.getY(), 20, 20);
		}
	}	public void paint(Graphics g)
	{
		Iterator i = points.iterator();
		while(i.hasNext())
		{
			Point p = (Point)i.next();
			g.setColor(Color.blue);
			g.fillOval((int)p.getX(), (int)p.getY(), 20, 20);
		}
	}