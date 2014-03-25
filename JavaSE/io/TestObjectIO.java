//TestObjectIO.java

import java.io.*;

public class TestObjectIO
{
	public static void main(String args[]) throws Exception
	{
		T t = new T();
		t.k = 8;
		FileOutputStream fos = new FileOutputStream("D:/bak/test.java");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		oos.close();

		FileInputStream fis = new FileInputStream("D:/bak/test.java");
		ObjectInputStream ois = new ObjectInputStream(fis);
		T tReaded = (T)ois.readObject();//将所读文件直接转换为T类。
		System.out.println(tReaded.i+" "+tReaded.j+" "+tReaded.d+" "+tReaded.k);
	}
}

class T implements Serializable
{
	int i = 10;
	int j = 9;
	double d = 2.3;
	transient int k = 15;//透明的，默认显示为0
	
}
