//TFMath.java---���жԷ����ã�����ģʽ��

import java.awt.*;
import java.awt.event.*;

public class TFMath
{
	public static void main(String args[])
	{
		new MyFrame().launchMyFrame();
	}
}

class MyFrame extends Frame
{
	static TextField tf1, tf2, tf3;
	
	public void launchMyFrame()
	{
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(15);
		
		Label lb = new Label("+");
		Button bt = new Button("=");
		MyActionListener mal = new MyActionListener();
		bt.addActionListener(mal);
		setLayout(new FlowLayout());
		add(tf1);
		add(lb);
		add(tf2);
		add(bt);
		add(tf3);
		pack();
		setVisible(true);
	}
}

	MyFrame mf = null;
	
	public MyActionListener(MyFrame mf)
	{
		this.mf = mf;
	}
	// public void actionPerformed(ActionEvent e)
	// {
		// int n1 = Integer.parseInt(MyFrame.tf1.getText());
		// int n2 = Integer.parseInt(MyFrame.tf2.getText());
		
		// MyFrame.tf3.setText("" + (n1 + n2));
	// }
// }
//������---����Ϊ�ڲ���

//������
// class MyActionListener implements ActionListener
// {
	// MyFrame mf = null;
	
	// public MyActionListener(MyFrame mf)
	// {
		// this.mf = mf;
	// }
	// public void actionPerformed(ActionEvent e)
	// {
		// int n1 = Integer.parseInt(mf.tf1.getText());
		// int n2 = Integer.parseInt(mf.tf2.getText());
		
		// mf.tf3.setText("" + (n1 + n2));
	// }
// }

//������-----�����޷��Ӿ�̬�����������÷Ǿ�̬����tf1
// class MyActionListener implements ActionListener
// {