//Palette.java
/**
 * ��ɫ��
 * rgbת16���ƣ�r�߰�λ��g�а�λ��b�Ͱ�λ
 * 
 * */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;


public class Palette extends JFrame
{
	//�����ֶ�
	Color color;
	int red, green, blue;
	String info;
	JTextArea jta, showRGB, showHex;
	JLabel LabelRGB, LabelHex;
	JScrollBar jsbR, jsbG, jsbB;
	int SYS_W, SYS_H;
	
	//���캯��
	public Palette()
	{
		super("��ɫ��");
		SYS_W = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		SYS_H = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
//		
//		super("��ɫ��");===============�������������ǰ��
		creatComponents();
		jsbR.setValue(203);
		jsbG.setValue(233);
		jsbB.setValue(207);
		red = jsbR.getValue();
		green = jsbG.getValue();
		blue = jsbB.getValue();
		color = new Color(red, green, blue);
		jta.setBackground(color);
		info = String.valueOf(jsbR.getValue()) + ",";
		info = info + String.valueOf(jsbG.getValue()) + ",";
		info = info + String.valueOf(jsbB.getValue());
		showRGB.setText(info);
		showHex.setText("#"+Integer.toHexString(red)+Integer.toHexString(green)+Integer.toHexString(blue));
		layoutComponents();
		registerJsBar();
		this.setLocation(SYS_W/3, SYS_H/5);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		this.setVisible(true);
	}
	//����������Ķ���
	public void creatComponents()
	{
		jta = new JTextArea(7, 25);
		jta.setEditable(false);
		showRGB = new JTextArea(1, 10);
		showHex = new JTextArea(1, 10);
		LabelRGB = new JLabel("RGBֵ��");
		LabelHex = new JLabel("Hexֵ��");
		jsbR = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 255);
		jsbG = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 255);
		jsbB = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 255);
		jsbR.setPreferredSize(new Dimension(200, 18));
		jsbG.setPreferredSize(new Dimension(200, 18));
		jsbB.setPreferredSize(new Dimension(200, 18));
	}
	//���岼��
	public void layoutComponents()
	{
		Container contentPane = this.getContentPane();
		JPanel jsbPane =  new JPanel(new GridLayout(0, 1, 0, 50));
		jsbPane.add(jsbR);
		jsbPane.add(jsbG);
		jsbPane.add(jsbB);
		JPanel DownPane = new JPanel();
		DownPane.setLayout(new FlowLayout());
		DownPane.add(LabelRGB);
		DownPane.add(showRGB);
		DownPane.add(LabelHex);
		DownPane.add(showHex);
		JPanel panel = new JPanel(new BorderLayout(10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 20));
		panel.add(jsbPane, BorderLayout.EAST);
		panel.add(jta, BorderLayout.WEST);
		panel.add(DownPane, BorderLayout.SOUTH);
		contentPane.add(panel);
	}
	//�Թ������¼�ע��
	public void registerJsBar()
	{
		ScrollBarEventHander scrollbaEventHander = new ScrollBarEventHander();
		jsbR.addAdjustmentListener(scrollbaEventHander);
		jsbG.addAdjustmentListener(scrollbaEventHander);
		jsbB.addAdjustmentListener(scrollbaEventHander);
	}
	//�������¼�
	class ScrollBarEventHander implements AdjustmentListener
	{
		public void adjustmentValueChanged(AdjustmentEvent e)
		{
			red = jsbR.getValue();
			green = jsbG.getValue();
			blue = jsbB.getValue();
			jta.setBackground(new Color(red, green, blue));
			info = String.valueOf(jsbR.getValue()) + ",";
			info = info + String.valueOf(jsbG.getValue()) + ",";
			info = info + String.valueOf(jsbB.getValue());
			showRGB.setText(info);
			showHex.setText("#"+Integer.toHexString(red)+Integer.toHexString(green)+Integer.toHexString(blue));
		}
	}
	//������
	public static void main(String args[])
	{
		new Palette();
	}
}
