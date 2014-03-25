//TestDataStream.java

import java.io.*;

public class TestDataStream  
{
	public static void main(String[] args) 
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
										//内存中的字节数组，一根管道套其上。
		DataOutputStream dos = new DataOutputStream(baos);//外包一根管道。
		try
		{
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);
			
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			System.out.println(bais.available());
			DataInputStream dis = new DataInputStream(bais);
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			dos.close();
			dis.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	
	}
}
