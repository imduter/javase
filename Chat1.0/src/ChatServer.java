import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer 
{

	boolean started = false;
	
	private List<Client> clients = new ArrayList<Client>();

	public static void main(String[] args)
	{
		new ChatServer().start();
	}
	
	private void start()
	{
		try 
		{
			ServerSocket serverSocket = new ServerSocket(8888);
			started = true;
			int count = 0;
			while(started)
			{
				Socket socket = serverSocket.accept();
				System.out.println((++count) + " clients connected.");
				Client c = new Client(socket);
				clients.add(c);
				new Thread(c).start();
			}			
		}
		catch(BindException e)
		{
			System.out.println("The port has been used.System will exit.");
			System.exit(0);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	private class Client implements Runnable
	{
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		boolean beConnected = false;
		
		Client(Socket socket)
		{
			this.socket = socket;
			try
			{
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		public void run() 
		{
			beConnected = true;
			while(beConnected)
			{
				//阻塞式，防碍了其他客户端的连接--采用多线程或异步方式
				try 
				{
					String message = null;
					if(dis != null)	message = dis.readUTF();
					System.out.println(message);
					for(int i = 0; i < clients.size(); i++)
					{
						Client c = clients.get(i);
						c.sendMessage(message);
					}
				}
				catch(EOFException e)
				{
					System.out.println("client closed.");
					clients.remove(this);
					beConnected = false;
					try
					{
						dis.close();
						dos.close();
					}
					catch (IOException e1)
					{
						e1.printStackTrace();
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

			}
		}

		public void sendMessage(String message)
		{
			try 
			{
				dos.writeUTF(message);
				dos.flush();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
	
}
