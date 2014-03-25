package com.zcloud.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*java中的序列化(serialization)机制能够将一个实例对象的状态信息写入到一个字节流中
使其可以通过socket进行传输，或则持久存储到数据库或文件系统中；然后在需要的时候，可以读取字节流
中的信息来重构一个相同的对象。序列化机制在java中有广泛的应用：EJB,RMI,hessian等技术都是以此为基础
因此，序列话一般用于以下场景：
1.永久性保存对象，保存对象的字节序列到本地文件或数据库中
2.通过序列化以字节流的形式使对象在网络中进行传递和接受
3.通过序列化在进程中传递对象
*/
//如何序列化一个对象？
//通过实现java.io.Serializable借口以启动其序列化功能。
//未实现此接口的雷将无法使其任何状态序列化或反序列化
//可序列化类的所有子类型本身是可序列化的。序列化接口的方法和字段，
//仅用于标识可序列化的语义

public class TestSerial implements Serializable
{
	public byte version = 10;
	public byte count = 0;
	
	public void f()
	{
		System.out.println("hello serialization!");
	}
	
	public static void main(String args[]) throws Exception
	{
		FileOutputStream fos = new FileOutputStream("temp.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		TestSerial ts = new TestSerial();
		oos.writeObject(ts);
		oos.flush();
		oos.close();
		FileInputStream fis = new FileInputStream("temp.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		TestSerial ts1 = (TestSerial) oin.readObject();
		System.out.println("version=" + ts1.version);
	}
}
