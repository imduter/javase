package com.zcloud.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*java�е����л�(serialization)�����ܹ���һ��ʵ�������״̬��Ϣд�뵽һ���ֽ�����
ʹ�����ͨ��socket���д��䣬����־ô洢�����ݿ���ļ�ϵͳ�У�Ȼ������Ҫ��ʱ�򣬿��Զ�ȡ�ֽ���
�е���Ϣ���ع�һ����ͬ�Ķ������л�������java���й㷺��Ӧ�ã�EJB,RMI,hessian�ȼ��������Դ�Ϊ����
��ˣ����л�һ���������³�����
1.�����Ա�����󣬱��������ֽ����е������ļ������ݿ���
2.ͨ�����л����ֽ�������ʽʹ�����������н��д��ݺͽ���
3.ͨ�����л��ڽ����д��ݶ���
*/
//������л�һ������
//ͨ��ʵ��java.io.Serializable��������������л����ܡ�
//δʵ�ִ˽ӿڵ��׽��޷�ʹ���κ�״̬���л������л�
//�����л�������������ͱ����ǿ����л��ġ����л��ӿڵķ������ֶΣ�
//�����ڱ�ʶ�����л�������

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
