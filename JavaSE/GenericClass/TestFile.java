//ʹ�õݹ��г�Ŀ¼
//��Ŀ¼�к���Ŀ¼����Ŀ¼

import java.io.*;

public class TestFile
{
	public static void main(String args[])
	{
		listFileTree(new File("D:/A"), 0);
		
	}
	
	private static void listFileTree(File f, int level)
	{
		String preFile = "";
		for(int i = 0; i < level; i++)
		{
			preFile += "		";
		}
		
		File childs[] = f.listFiles();
		
		//��ָ���
		//ԭ��windows��Ȩ�޷��ʡ�
		for(int i = 0; i < childs.length; i++)
		{
			System.out.println(preFile + childs[i].getName());
			if(childs[i].isDirectory())
			{
				listFileTree(childs[i], level+1);
			}
		}
	}
}

