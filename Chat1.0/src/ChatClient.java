import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;


public class ChatClient extends Frame
{
	public static final int ClientW = 400;
	public static final int ClientH = 200;
	public static final int x = 500, y = 300;
	
	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	
	Socket socket;
	DataOutputStream dos;
	DataInputStream dis;
	ChatServer cs;
	
	
	public void launchFrame()
	{
		this.setLocation(x, y);
		this.setSize(ClientW, ClientH);
		this.setResizable(false);
		
		taContent.setEditable(false);
		tfTxt.addActionListener(new TFMonitor());
		this.add(tfTxt, BorderLayout.SOUTH);
		this.add(taContent, BorderLayout.NORTH);
		pack();
		
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				disconnect();
			}
		});
		
		this.setVisible(true);
		this.connect();
		new ServerSent().start();
	}
	
	private void connect()
	{
		try
		{
			socket = new Socket("127.0.0.1", 8888);
			dis = new DataInputStream(socket.getInputStream());
			//连接建立，管道建立,拿起管道
			dos = new DataOutputStream(socket.getOutputStream());
		}
		catch(IOException e)
		{
			this.taContent.setText("连接服务器异常,3s后程序将自动关闭");
			try 
			{
				Thread.sleep(3000);
			} catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			System.exit(0);
		}
	}
	
	private void disconnect()
	{
		try
		{
			socket.close();
			dis.close();
			dos.close();
			System.exit(0);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		ChatClient cc = new ChatClient();
		cc.launchFrame();
	}

	private class TFMonitor implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//trim()回车去空格方法 
			String sendMessage = tfTxt.getText().trim();
			try 
			{
				//写入东西
				dos.writeUTF(sendMessage);
				//向对方传输
				dos.flush();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
			
			tfTxt.setText("");
		}
	}

	private class ServerSent extends Thread
	{

		public void run() 
		{
			while(true)
			{
					if (dis != null)
					{
						try
						{
							String message = dis.readUTF();
							taContent.setText(taContent.getText() + message + "\n");
						} 
						catch (IOException e) 
						{
							try 
							{
								this.join();
							}
							catch (InterruptedException e1)
							{
								e1.printStackTrace();
							}
							System.exit(0);
						}
						
					}
			}
		}
		
	}
	
}
