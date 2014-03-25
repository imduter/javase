//TestActioEvent2.java

import java.awt.*;
import java.awt.event.*;

public class TestActionEvent2
{
	public static void main(String args[])
	{
		Frame f = new Frame();
		Button b1 = new Button("Start");
		Button b2 = new Button("Stop");
		Monitor m = new Monitor();
		b1.addActionListener(m);
		b2.addActionListener(m);
		b2.setActionCommand("Game over");
		f.add(b1, BorderLayout.NORTH);
		f.add(b2, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
} 

class Monitor implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("The button has been pressed." + "the relative info is:" + e.getActionCommand());
	}
}