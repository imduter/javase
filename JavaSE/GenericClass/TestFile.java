//使用递归列出目录
//子目录中含子目录含子目录

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
		
		//空指针错
		//原因：windows无权限访问。
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

