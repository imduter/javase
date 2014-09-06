import java.io.*;
import java.net.*;

/*
	请求体									是否必选
	GET/POST[URL]HTTP/[HTTP Version]			y	
	Host:[URL]									y
	User-Agent:[请求类型唯一标识]				n
	Accept:[设置服务器返回数据类型]				n
	Accept-Language:[设置服务器返回的语言]		n
	Accept-Encoding:[设置服务器返回的压缩编码]	n
	Accept-Charset[设置服务器返回的文字编码]	n
	\r\n\r\n									y
	Post内容									n
*/

public class HttpTest
{

	public static void main(String args[]) throws Exception
	{
		Socket s = new Socket("127.0.0.1", 8090);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		pw.println("GET / HTTP/1.1");
		pw.println("Host: localHost");
		pw.println("Content-Type: text/html");
		pw.println();
		pw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = "";
		while((str = br.readLine()) != null)
		{
			System.out.println(str);
		}
		
		br.close();
		pw.close();
		s.close();
	}
}